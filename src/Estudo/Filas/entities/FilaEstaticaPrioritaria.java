package Estudo.Filas.entities;

public class FilaEstaticaPrioritaria<T extends Comparable<T>> extends FilaEstatica<T> {

    public FilaEstaticaPrioritaria(int capacidade) {
        super(capacidade);
    }

    // Enfileirar com prioridade:
    //  - Percorre o elemento
    @Override
    public void enfileirar(T elemento) {
        this.aumentarCapacidade();
        int i = 0;
        // Encontra posição correta baseada na prioridade
        while (i < this.tamanho() && elemento.compareTo(this.getElemento(i)) > 0) {
            i++;
        }
//        for (i = 0; i < this.tamanho; i++) {
//            if (chave.compareTo((T) this.elementos[i]) < 0) {
//                break;
//            }
//        }
        this.enfileirarPosicao(i, elemento);
    }
    // Compara objetos
    //  - obj1 > obj2 retorna num > 0 (1)
    //  - obj1 < obj2 retorna num < 0 (-1)
    //  - obj1 == obj2 retorna 0

    @Override
    public String toString() {
        return super.toString();
    }
}
