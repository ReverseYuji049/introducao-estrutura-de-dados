package Aula2.entidades;

public class ListaSimples {
    public String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
        System.out.println("Operação realizada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }
    public void adicionarElemento(String elemento) {
        if (!this.estaCheio()) {
            lista[encontrarPosicao()] = elemento;
        }
    }
    public boolean estaCheio() {
        for (int i = 0; i < lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("Não há espaço disponível na lista.");
        return true;
    }
    private int encontrarPosicao() {
        int i;
        for (i = 0; i < lista.length; i++) {
            if (this.lista[i] == null) {
                break;
            }
        }
        return i;
    }
    public void exibirElementos() {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("Lista [" + i + "] = " + this.lista[i]);
        }
    }
    public void removerElemento(String elemento) {
        boolean removido = false;
        if (!estaVazio()) {
            for (int i = 0; i < lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    this.lista[i] = null;
                    removido = true;
                }
            }
        }
        if (removido) {
            System.out.println("O elemento " + elemento + " foi removido com sucesso!");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }
    public boolean estaVazio() {
        for (int i = 0; i < lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }
    public void buscarElemento(String elemento) {
        boolean encontrado = false;
        if (!estaVazio()) {
            for (int i = 0; i < lista.length; i++) {
                if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                    encontrado = true;
                }
            }
        }
        if (encontrado) {
            System.out.println("O elemento " + elemento + " existe na lista.");
        } else {
            System.out.println("O elemento " + elemento + " não existe na lista.");
        }
    }
}
