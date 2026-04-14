package Estudo.Filas.entities.FilaEstaticaPrioritaria;

import Estudo.Filas.entities.FilaEstatica;

public class FilaPrioritaria extends FilaEstatica<Elemento2> {

    public FilaPrioritaria(int capacidade) {
        super(capacidade);
        System.out.println("Fila estática prioritária criada com sucesso!");
    }

    public void enfileirar(int valor) {

        // Cria novo elemento na fila
        Elemento2 novoElemento = new Elemento2(valor);

        // Variável que percorre a fila
        int atual = 0;

        // Encontra a posição correta para inserir o novo elemento:
        //  - Enquanto houver elementos na fila
        //  - Enquanto a prioridade do elemento atual for maior ou igual ao do novo elemento
        //  - Percorre a fila para a direita
        //  - Garante que os elementos com prioridade maior fiquem na frente
        //  - Mantém a fila ordenada
        //while (atual < tamanho() && novoElemento.getPrioridade() < getElemento(atual).getPrioridade()) {
        while (atual < tamanho() && getElemento(atual).getPrioridade() >= novoElemento.getPrioridade()) {
            // Percorre a fila para a direita
            atual++;
        }
        // Chama o método enfileirar por posição da superclasse
        enfileirarPosicao(atual, novoElemento);
        System.out.println("O elemento " + valor + " foi inserido com prioridade " +  novoElemento.getPrioridade() +
                " na fila.");
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
