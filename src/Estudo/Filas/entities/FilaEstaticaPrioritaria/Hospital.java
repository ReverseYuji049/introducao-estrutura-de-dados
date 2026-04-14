package Estudo.Filas.entities.FilaEstaticaPrioritaria;

import java.util.Scanner;

public class Hospital {
    static void main() {

        Scanner sc = new Scanner(System.in);
        FilaEstaticaPrioritaria<Paciente> pacientes = new FilaEstaticaPrioritaria<>(10);

        int opcao;

        do {
            System.out.println("\n==== HOSPITAL ====");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Atender paciente");
            System.out.println("3 - Ver fila");
            System.out.println("4 - Explicar classificações");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {

                case 1:
                    cadastrarPaciente(sc, pacientes);
                    break;

                case 2:
                    atenderPaciente(pacientes);
                    break;

                case 3:
                    System.out.println("\nFila atual:");
                    System.out.println(pacientes);
                    break;

                case 4:
                    explicarClassificacoes();
                    break;

                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }

    public static void cadastrarPaciente(Scanner sc, FilaEstaticaPrioritaria<Paciente> pacientes) {
        System.out.print("Nome do paciente: ");
        String nome = sc.nextLine();

        System.out.println("\nClassificação de risco:");
        System.out.println("Vermelho, Laranja, Amarelo, Verde, Azul");
        System.out.print("Digite: ");
        String risco = sc.nextLine();

        System.out.println("\nTipo social:");
        System.out.println("Criança de colo, Gestante, Idoso, Deficiente, Normal");
        System.out.print("Digite: ");
        String tipoSocial = sc.nextLine();

        Paciente paciente = new Paciente(nome, risco, tipoSocial);

        pacientes.enfileirar(paciente);

        System.out.println("Paciente cadastrado com sucesso!");

    }

    public static void atenderPaciente(FilaEstaticaPrioritaria<Paciente> fila) {

        if (fila.estaVazia()) {
            System.out.println("Fila vazia!");
            return;
        }

        System.out.println("Atendendo paciente...");
        System.out.println(fila.desenfileirar());
    }

    public static void explicarClassificacoes() {

        System.out.println("\n===== CLASSIFICAÇÃO DE RISCO =====");

        System.out.println("Vermelho: Emergência");
        System.out.println("Atendimento imediato.");
        System.out.println("Ex: parada cardíaca, inconsciência, falta de ar grave.\n");

        System.out.println("Laranja: Muito urgente");
        System.out.println("Atendimento em até 10 minutos.");
        System.out.println("Ex: dor intensa, dificuldade respiratória.\n");

        System.out.println("Amarelo: Urgente");
        System.out.println("Atendimento em até 60 minutos.");
        System.out.println("Ex: febre alta, dor moderada.\n");

        System.out.println("Verde: Pouco urgente");
        System.out.println("Atendimento em até 120 minutos.");
        System.out.println("Ex: sintomas leves.\n");

        System.out.println("Azul: Não urgente");
        System.out.println("Atendimento em até 240 minutos.");
        System.out.println("Ex: casos simples.\n");

        System.out.println("===== PRIORIDADE SOCIAL =====");
        System.out.println("Criança de colo");
        System.out.println("Gestante");
        System.out.println("Idoso");
        System.out.println("Deficiente");
        System.out.println("Normal: Sem prioridade adicional");
    }
}