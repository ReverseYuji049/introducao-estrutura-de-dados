package Pratica.entities;

public class No {
    String conteudo;
    No prox = null;


    public No(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return this.conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public No getProx() {
        return prox;
    }
    public void setProx(No prox) {
        this.prox = prox;
    }
}

