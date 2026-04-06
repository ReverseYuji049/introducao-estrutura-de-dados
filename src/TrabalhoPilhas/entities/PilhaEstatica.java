package TrabalhoPilhas.entities;

public class PilhaEstatica {
    private String[] pilha;
    private int topo;
    private int capacidade;

    public PilhaEstatica(int capacidade) {
        this.capacidade = capacidade;
        pilha = new String[capacidade]; //define a capacidade da pilha e cria uma nova pilha
        topo = -1; //índice 0 é o primeiro elemento
        System.out.println("Operação realizada com sucesso! Existem " + capacidade + " posições disponíveis.");
    }

    public boolean estaVazia() {
        return topo == -1; //topo vazio
    }

    public boolean estaCheia() {
        return topo == capacidade -1; //topo cheio
    }

    public void empilhar(String elemento) {
        if (estaCheia()) {
            System.out.println("A pilha está cheia!");
            return;
        }
        topo++; //incrementa o topo;
        pilha[topo] = elemento; //acrescenta o elemento ao topo;
    }
    public String desempilhar() {
        if (estaVazia()) {
            return "Pilha vazia!";
        }
        String removido = pilha[topo]; //remove o topo
        topo--;
        return removido;
    }

    public String topo() {
        if (estaVazia()) {
            return "Pilha vazia!";
        }
        return pilha[topo];
    }

    public void exibir() {
        for (int i = topo; i >= 0; i--) {
            System.out.println(pilha[i]);
        }
    }
}
