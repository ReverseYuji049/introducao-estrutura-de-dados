package TrabalhoPilhas.entities;

public class PilhaEstaticaGenerica<T> {
    private T[] pilha;
    private int topo;
    private int capacidade;

    @SuppressWarnings("unchecked")
    public PilhaEstaticaGenerica(int capacidade) {
        this.capacidade = capacidade;
        pilha = (T[]) new Object[capacidade]; // criação do array genérico
        topo = -1;
        System.out.println("Operação realizada com sucesso! Existem " + capacidade + " posições disponíveis.");
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == capacidade - 1;
    }

    public void empilhar(T elemento) {
        if (estaCheia()) {
            System.out.println("A pilha está cheia!");
            return;
        }
        pilha[++topo] = elemento;
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null; // melhor prática com genéricos
        }
        return pilha[topo--];
    }

    public T topo() {
        if (estaVazia()) {
            return null;
        }
        return pilha[topo];
    }

    public void exibir() {
        for (int i = topo; i >= 0; i--) {
            System.out.println(pilha[i]);
        }
    }
}
