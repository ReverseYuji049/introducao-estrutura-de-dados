package Aula5.entities;

import Aula3.entidades.No;

public class FilaDinamica {
    No inicio;

    public FilaDinamica() {
        this.inicio = new No(null);
        System.out.println("Fila dinâmica criada com sucesso!");
    }

    public void enfileirar(String elemento) {
        if (estaVazio()) {
            this.inicio.setConteudo(elemento);
            System.out.println("Elemento " + elemento + " adicionado na Fila!");
        } else {
            No novoNo = new No(elemento);
            No aux = this.inicio;
            while(aux != null) {
                if (aux.getProx() == null) {
                    aux.setProx(novoNo); //conexão
                    System.out.println("Elemento " + elemento + " adicionado na Fila!");
                    return;
                }
                aux = aux.getProx();
            }
        }
    }
    private boolean estaVazio() {
        if (this.inicio.getConteudo() == null) {
            System.out.println("Início está vazio");
            return true;
        } else {
            return false;
        }
    }
    public void exibir() {
        if (!estaVazio()) {
            No aux = this.inicio;
            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }
    public void desenfileirar() {
        if (!estaVazio()) {
            if (this.inicio.getProx() == null) {
                System.out.println("Elemento " + this.inicio.getConteudo() + " removido da lista!");
                this.inicio.setConteudo(null);
            } else {
                System.out.println("Elemento " + this.inicio.getConteudo() + " removido da lista!");
                // o início é deslocado para a direita, e o novo elemento é removido
                this.inicio = this.inicio.getProx();
            }
        }
    }
}
