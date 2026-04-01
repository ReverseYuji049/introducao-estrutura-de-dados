package Desafio.entities;

public class No {
    int conteudo;
    No prox = null;

    public No(int conteudo) {
        this.conteudo = conteudo;
    }

    public int getConteudo() {
        return this.conteudo;
    }
    public void setConteudo(int conteudo) {
        this.conteudo = conteudo;
    }
    public No getProx() {
        return prox;
    }
    public void setProx(No prox) {
        this.prox = prox;
    }
}
