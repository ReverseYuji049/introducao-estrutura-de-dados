package Estudo.Filas.entities.FilaEstaticaPrioritaria;

public class Elemento2 {

    private int valor;
    private int prioridade;

    public Elemento2(int valor) {
        this.valor = valor;
        // Quanto maior o valor, maior a prioridade
        this.prioridade = valor;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    @Override
    public String toString() {
        return "(" + valor + " | prioridade: " + prioridade + ")";
    }
}
