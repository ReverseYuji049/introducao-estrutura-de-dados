package Aula4.entities;

public class FilaSimples {

    Integer[] fila;
    int tamanho = 0;

    public FilaSimples(int tamanho) {
        this.tamanho = tamanho;
        this.fila = new Integer[tamanho];
        System.out.println("A Fila criada com sucesso! Ela possui " + tamanho + " espaços disponíveis!");
    }
    public void enfileirar(int valor) {
        if(!estaCheia()) {
            for (int i = 0; i < this.tamanho; i++) {
                if (fila[i] == null) {
                    this.fila[i] = valor;
                    System.out.println("O valor " + valor + " foi inserido na fila.");
                    //System.out.println("A fila possui " + (tamanho - 1) + " espaços disponíveis!");
                    return;
                }
            }
        }
    }
    private boolean estaCheia() {
        for (int i = 0; i < this.tamanho; i++) {
            if (fila[i] == null) {
                return false;
            }
        }
        System.out.println("Lista está cheia.");
        return true;
    }
    public void exibir() {
        if (!estaVazia()) {
            for (int i = 0; i < this.tamanho; i++) {
                System.out.println(fila[i]);
            }
        }
    }
    private boolean estaVazia() {
        if (this.fila[0] != null) {
            System.out.println("A Fila está vazia.");
            return true;
        }
        return false;
    }
    public void desenfileirar() {
        if (!estaVazia()) {
            //if (fila[tamanho + 1] == null) {
                for (int i = 0; i < this.tamanho - 1; i++) {
                    System.out.println("O elemento " + this.fila[0] + " foi removido!");
                    this.fila[i] = this.fila[i + 1];
                }
                this.fila[this.tamanho - 1] = null;
            //}
        }
    }
}
