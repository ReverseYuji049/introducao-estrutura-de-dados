package Estudo.Filas.entities;

public class No<T> {
    // Nó do tipo genérico
    private T elemento;
    private No<T> proximo;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    // Construtor em que se sabe o próximo elemento
//    public No(T elemento, No<T> proximo) {
//        this.elemento = elemento;
//        this.proximo = proximo;
//    }

    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public No<T> getProximo() {
        return proximo;
    }
    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("No [elemento: ").append(elemento).append(", proximo: ").append(proximo).append("]");
        return builder.toString();
    }
}
