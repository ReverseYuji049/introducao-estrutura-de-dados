package Estudo.ListaEstatica.application;

import Estudo.ListaEstatica.entities.ListaEstatica;

public class ProgramaListaEstatica {
    static void main() {
        testeAdicionar();
        testeRemover();
        testeListaVazia();
        testeAdicionarPosicao();
        testeBusca();
        testeRemoverPosicao();
    }

    public static void testeAdicionar() {
        System.out.println("\n==== TESTE ADICIONAR ====");
        ListaEstatica<Integer> lista = new ListaEstatica<>(6);

        lista.adicionar(1);
        System.out.println("Lista: " + lista);
        // [1]
        lista.adicionar(2);
        System.out.println("Lista: " + lista);
        // [1, 2]
        lista.adicionar(3);
        System.out.println("Tamanho: " + lista.getTamanho());
        // 3
        System.out.println("Lista: " + lista);
        // [1, 2, 3]
        lista.adicionarInicio(0);
        System.out.println("Lista após adicionar no início: " + lista);
        // [0, 1, 2, 3]
    }

    public static void testeRemover() {
        System.out.println("\n==== TESTE REMOVER ====");

        ListaEstatica<Integer> lista = new ListaEstatica<>(5);

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);

        System.out.println("Lista: " + lista);
        // [1, 2, 3]
        System.out.println("Remover início: " + lista.removerInicio());
        // 1
        System.out.println("Lista: " + lista);
        // [2, 3]
        System.out.println("Remover final: " + lista.remover());
        // 3
        System.out.println("Lista: " + lista);
        // [2]
    }

    public static void testeListaVazia() {
        System.out.println("\n==== TESTE LISTA VAZIA ====");
        ListaEstatica<Integer> lista = new ListaEstatica<>(3);

        System.out.println("Lista: " + lista);
        // []
        System.out.println("Tamanho: " + lista.getTamanho());
        // 0
    }

    public static void testeAdicionarPosicao() {
        System.out.println("\n==== TESTE ADICIONAR POSIÇÃO ====");
        ListaEstatica<Integer> lista = new ListaEstatica<>(5);

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);

        System.out.println("Lista: " + lista);
        // [1, 2, 3]
        lista.adicionarPorPosicao(1, 10);
        System.out.println("Após adicionar na posição 1: " + lista);
        // [1, 10, 2, 3]
        lista.adicionarPorPosicao(0, 5);
        System.out.println("Após adicionar no início: " + lista);
        // [5, 1, 10, 2, 3]
        lista.adicionarPorPosicao(lista.getTamanho(), 99);
        System.out.println("Após adicionar no final: " + lista);
        // [5, 1, 10, 2, 3, 99]
    }

    public static void testeBusca() {
        System.out.println("\n==== TESTE BUSCA ====");
        ListaEstatica<Integer> lista = new ListaEstatica<>(5);

        lista.adicionar(10);
        lista.adicionarInicio(20);
        lista.adicionar(30);
        System.out.println("Lista: " + lista);
        // [10, 20, 30]
        System.out.println("Elemento na posição 1: " + lista.buscaPosicao(1));
        // 20
        System.out.println("Posição do elemento 30: " + lista.buscaElemento(30));
        // 2
        System.out.println("Elemento inexistente (99): " + lista.buscaElemento(99));
        // -1
    }
    public static void testeRemoverPosicao() {
        System.out.println("\n==== TESTE REMOVER POR POSIÇÃO ====");
        ListaEstatica<Integer> lista = new ListaEstatica<>(5);

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        System.out.println("Lista: " + lista);
        // [1, 2, 3]
        System.out.println("Remover início: " + lista.removerPorPosicao(1));
        // 2
        System.out.println("Lista: " + lista);
        // [1, 3]
    }
}
