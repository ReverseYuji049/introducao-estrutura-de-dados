package Aula6.entities;

public class No {
    String conteudo;
    No anterior;
    No prox;

    public No(String conteudo) {
        this.conteudo = conteudo;
        this.anterior = null;
        this.prox = null;
    }

    public String getConteudo() {
        return this.conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public No getAnterior() {
        return anterior;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public No getProx() {
        return prox;
    }
    public void setProx(No prox) {
        this.prox = prox;
    }
}
