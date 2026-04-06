package Estudo.Pilhas.entities;

// Nó do tipo genérico
public class No <T> {

    // Conteúdo de cada nó
    private T conteudo;
    // Próximo elemento
    private No<T> proximo;

    // Construtor com o conteúdo
    public No(T conteudo) {
        this.conteudo = conteudo;
    }
    // Getters and Setters
    public No<T> getProximo() {
        return proximo;
    }
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
    public T getConteudo() {
        return conteudo;
    }
    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }
}
