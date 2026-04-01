package Aula4.entities;

public class Elemento {
    int valor;
    int prioridade;

    public Elemento(int valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
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
}
