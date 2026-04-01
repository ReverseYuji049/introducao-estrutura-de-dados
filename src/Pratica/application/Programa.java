package Pratica.application;

import Pratica.entities.ListaDinamica;
import Pratica.entities.ListaSimples;

import java.util.Scanner;

public class Programa {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================ LISTAS ================================");
        System.out.print("Gostaria de criar uma lista simples ou dinâmica (s/d)? ");
        char escolha = sc.next().charAt(0);

        switch (escolha) {
            case 's':
                executarListaSimples(sc);
                break;
            case 'd':
                executarListaDinamica(sc);
                break;
            default:
                System.out.println("Opção inválida.");
        }
        System.out.println("Fim do Programa");
        sc.close();
    }

    static void executarListaSimples(Scanner sc) {
        System.out.print("Qual o tamanho da lista? ");
        int tamanho = sc.nextInt();
        ListaSimples lista = new ListaSimples(tamanho);
        int op;
        do {
            imprimirMenu();
            op = lerOperacao(sc);

            switch (op) {
                case 1:
                    adicionarElemento(sc, lista);
                    break;
                case 2:
                    lista.exibirElementos();
                    break;
                case 3:
                    removerElemento(sc, lista);
                    break;
                case 4:
                    buscarElemento(sc, lista);
                    break;
                case 5:
                    System.out.println("Total de elementos: " + lista.contar());
                    break;
                case 6:
                    obterElemento(sc, lista);
                    break;
                case 7:
                    removerPorIndice(sc, lista);
                    break;
                case 0:
                    System.out.println("Saindo da lista...");
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
        } while (op != 0);
    }
    static void executarListaDinamica(Scanner sc) {
        ListaDinamica lista = new ListaDinamica();
        int op;
        do {
            imprimirMenu();
            op = lerOperacao(sc);
            switch (op) {
                case 1:
                    adicionarElemento(sc, lista);
                    break;
                case 2:
                    lista.exibir();
                    break;
                case 3:
                    removerElemento(sc, lista);
                    break;
                case 4:
                    buscarElemento(sc, lista);
                    break;
                case 5:
                    System.out.println("Total de elementos: " + lista.contar());
                    break;
                case 6:
                    obterElemento(sc, lista);
                    break;
                case 7:
                    removerPorIndice(sc, lista);
                    break;
                case 0:
                    System.out.println("Saindo da lista...");
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
        } while (op != 0);
    }

    static void imprimirMenu() {
        System.out.println("\n----------- LISTA DE OPERAÇÕES -----------");
        System.out.println("1 - Adicionar elemento");
        System.out.println("2 - Exibir elementos");
        System.out.println("3 - Remover elemento");
        System.out.println("4 - Buscar elemento");
        System.out.println("5 - Contar elementos");
        System.out.println("6 - Obter elemento por índice");
        System.out.println("7 - Remover por índice");
        System.out.println("0 - Sair");
    }
    static int lerOperacao(Scanner sc) {
        System.out.print("Escolha uma operação: ");
        return sc.nextInt();
    }

    static void adicionarElemento(Scanner sc, ListaSimples lista) {
        char continuar;
        do {
            sc.nextLine();
            System.out.print("Digite o elemento: ");
            String elemento = sc.nextLine();

            lista.adicionarElemento(elemento);

            System.out.print("Deseja adicionar outro? (s/n): ");
            continuar = sc.next().charAt(0);

        } while (continuar == 's');
    }
    static void adicionarElemento(Scanner sc, ListaDinamica lista) {
        char continuar;
        do {
            sc.nextLine();
            System.out.print("Digite o elemento: ");
            String elemento = sc.nextLine();

            lista.adicionarElemento(elemento);

            System.out.print("Deseja adicionar outro? (s/n): ");
            continuar = sc.next().charAt(0);

        } while (continuar == 's');
    }
    static void removerElemento(Scanner sc, ListaSimples lista) {
        sc.nextLine();
        System.out.print("Digite o elemento a remover: ");
        String elemento = sc.nextLine();

        lista.removerElemento(elemento);
    }
    static void removerElemento(Scanner sc, ListaDinamica lista) {
        sc.nextLine();
        System.out.print("Digite o elemento a remover: ");
        String elemento = sc.nextLine();

        lista.removerElemento(elemento);
    }
    static void buscarElemento(Scanner sc, ListaSimples lista) {
        sc.nextLine();
        System.out.print("Digite o elemento a buscar: ");
        String elemento = sc.nextLine();

        lista.buscarElemento(elemento);
    }

    static void buscarElemento(Scanner sc, ListaDinamica lista) {
        sc.nextLine();
        System.out.print("Digite o elemento a buscar: ");
        String elemento = sc.nextLine();

        lista.procurarElemento(elemento);
    }

    static void obterElemento(Scanner sc, ListaSimples lista) {
        System.out.print("Digite o índice: ");
        int indice = sc.nextInt();

        System.out.println(lista.obter(indice));
    }
    static void obterElemento(Scanner sc, ListaDinamica lista) {
        System.out.print("Digite o índice: ");
        int indice = sc.nextInt();

        System.out.println(lista.obter(indice));
    }
    static void removerPorIndice(Scanner sc, ListaSimples lista) {
        System.out.print("Digite o índice para remover: ");
        int indice = sc.nextInt();

        lista.removerPorIndice(indice);
    }
    static void removerPorIndice(Scanner sc, ListaDinamica lista) {
        System.out.print("Digite o índice para remover: ");
        int indice = sc.nextInt();

        lista.removerPorIndice(indice);
    }
}

