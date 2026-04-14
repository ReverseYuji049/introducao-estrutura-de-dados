package Estudo.Filas.entities.FilaEstaticaPrioritaria;

public class Paciente implements Comparable<Paciente> {

    private String nome;
    // Prioridade de cada elemento na fila
    private int prioridade;
    // Classificação por tipo social: Criança de colo, Gestante, Idoso, Deficiente
    private String tipoSocial;
    // Classificação de risco: Vermelho, Laranja, Amarelo, Verde e Azul
    private String classificacao;

    public Paciente(String nome, String classificacao, String tipoSocial) {
        this.nome = nome;
        this.classificacao = classificacao;
        this.tipoSocial = tipoSocial;
        int prioridadeRisco = definirRisco(classificacao);
        int prioridadeSocial = definirSocial(tipoSocial);
        this.prioridade = (prioridadeRisco * 10) + prioridadeSocial;
    }

    private int definirSocial(String tipoSocial) {
        return switch (classificacao) {
            case "Vermelho" -> 5;
            case "Laranja" -> 4;
            case "Amarelo" -> 3;
            case "Verde" -> 2;
            case "Azul" -> 1;
            default -> 0;
        };
    }

    // Define a prioridade do paciente baseada no tipo
    private int definirRisco(String classificacao) {
        switch (tipoSocial) {
            case "Criança com colo":
                return 4;
            case "Gestante":
                return 3;
            case "Idoso":
                return 2;
            case "Deficiente":
                return 1;
            default:
                return 0;
        }
    }
    // Compara os níveis de prioridade (baseado no tamanho do número)
    @Override
    public int compareTo(Paciente o) {
        return Integer.compare(o.prioridade, this.prioridade);
    }
    @Override
    public String toString() {
        return nome + " [" + classificacao + " | " + tipoSocial +
                " | prioridade " + prioridade + "]";
    }
}
