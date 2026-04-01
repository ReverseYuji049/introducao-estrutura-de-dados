package Aula3.entidades;

public class No {
    String conteudo;
    No prox = null; //apontamento

    //O conteúdo é informado pelo usuário, já o apontamento não, por isso apenas conteúdo está no construtor
    public No(String conteudo) {
        this.conteudo = conteudo;
    }
    //recebe
    public String getConteudo() {
        return this.conteudo;
    }
    //altera
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
