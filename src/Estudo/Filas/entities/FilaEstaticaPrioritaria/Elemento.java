package Estudo.Filas.entities.FilaEstaticaPrioritaria;

public class Elemento implements Comparable<Elemento> {
    String nome;
    int prioridade;

    public Elemento(String nome, int prioridade){
        this.nome = nome;
        this.prioridade = prioridade;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    // Compara as prioridades dos elementos
    @Override
    public int compareTo(Elemento o) {
        return Integer.compare(this.prioridade, o.prioridade);
        //if (this.prioridade > ((Elemento)o).getPrioridade())
//        if (this.prioridade > o.getPrioridade()) {
//            return 1;
//        } else if (this.prioridade < o.getPrioridade()) {
//            return -1;
//        }
//        // Prioridade igual
//        return 0;
    }
    @Override
    public String toString() {
        return nome + "(" + prioridade + ")";
    }
}
