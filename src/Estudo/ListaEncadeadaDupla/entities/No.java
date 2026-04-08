package Estudo.ListaEncadeadaDupla.entities;

public class No<T> {

    // Nó do tipo genérico
    private T elemento;

    private No<T> anterior;

    private No<T> proximo;

    public No(T elemento) {
        this.elemento = elemento; // Define o valor do nó
        this.proximo = null;      // Inicialmente não aponta para ninguém
        this.anterior = null;     // Inicialmente não aponta para ninguém
    }
    // Construtor completo (já com ligações)
    public No(T elemento, No<T> anterior, No<T> proximo) {
        this.elemento = elemento; // Define o valor
        this.anterior = anterior; // Define quem vem antes
        this.proximo = proximo;   // Define quem vem depois
    }

    // GET e SET do elemento
    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    // GET e SET do próximo
    public No<T> getProximo() {
        return proximo;
    }
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
    // GET e SET do anterior
    public No<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("No [elemento: ").append(elemento).append(", proximo: ").append(proximo).append("]");
//        return builder.toString();
//    }
}
