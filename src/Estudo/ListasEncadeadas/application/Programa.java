package Estudo.ListasEncadeadas.application;

import Estudo.ListasEncadeadas.entities.ListaEncadeada;

public class Programa {
    static void main() {
        System.out.println("======= Testes Iniciais =======");
        testesIniciais();
        System.out.println("======= Teste: Adicionar no Início =======");
        testeAdicionaInicio();
        System.out.println("======= Teste: Adicionar por Posição =======");
        testeAdicionaPosicao();
        System.out.println("======= Teste: Remover Início =======");
        testeRemoveInicio();
        System.out.println("======= Teste: Remover Final =======");
        testeRemoveFinal();
        System.out.println("======= Teste: Remover =======");
        testeRemove();
    }

    public static void testesIniciais() {
        // Teste 1
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();

        lista.adicionarUltimo(1);
        System.out.println("Tamanho da lista: " + lista.getTamanho());
        // Tamanho: 1
        System.out.println(lista);
        // Lista Encadeada [inicio: No [elemento: 1, proximo: null]]

        // Teste 2
        lista.adicionarUltimo(2);
        System.out.println(lista);

        lista.adicionarUltimo(3);
        System.out.print(lista);
        // Lista Encadeada [inicio: No [elemento: 1, proximo: null]]
        // Lista Encadeada [inicio: No [elemento: 1, proximo: No [elemento: 2, proximo: null]]]
        // Lista Encadeada [inicio: No [elemento: 1, proximo: No [elemento: 2, proximo: No [elemento: 3, proximo: null]]]]

        // Teste 3

        // Busca por elemento
        System.out.println("\nBusca por elemento: ");
        System.out.println(lista.buscaElemento(0));
        System.out.println(lista.buscaElemento(1));
        System.out.println(lista.buscaElemento(2));

        // Busca por posição
        System.out.println("\nBusca por posição: ");
        System.out.println(lista.buscaPosicao(0));
        System.out.println(lista.buscaPosicao(1));
        System.out.println(lista.buscaPosicao(2));
    }

    public static void testeAdicionaInicio() {
        ListaEncadeada<Integer> lista2 = new ListaEncadeada<>();
        lista2.adicionarInicio(1);
        lista2.adicionarInicio(2);
        lista2.adicionarInicio(3);
        System.out.println(lista2);
        // [3, 2, 1]
    }
    public static void testeAdicionaPosicao() {
        ListaEncadeada<Integer> lista3 = new ListaEncadeada<>();
        lista3.adicionarUltimo(1);
        lista3.adicionarUltimo(2);
        lista3.adicionarUltimo(4);
        lista3.adicionar(0, 0);
        lista3.adicionar(4, 5);
        lista3.adicionar(2, 3);
        System.out.println(lista3);
        // [0, 1, 2, 3, 4, 5]
    }

    public static void testeRemoveInicio() {
        ListaEncadeada<Integer> lista4 = new ListaEncadeada<>();

        // lista4.removerInicio();
        lista4.adicionarUltimo(1);
        lista4.adicionarUltimo(2);
        lista4.adicionarUltimo(4);
        System.out.println("Elemento removido: " + lista4.removerInicio());
        System.out.println("Lista: " + lista4);
        // [1, 2, 4] --> [2, 4]
        System.out.println("Elemento removido: " + lista4.removerInicio());
        System.out.println("Lista: " + lista4);
        System.out.println("Elemento removido: " + lista4.removerInicio());
        System.out.println("Lista: " + lista4);
    }
    public static void testeRemoveFinal() {
        ListaEncadeada<Integer> lista5 = new ListaEncadeada<>();

        // lista4.removerInicio();
        lista5.adicionarUltimo(1);
        lista5.adicionarUltimo(2);
        lista5.adicionarUltimo(4);

        System.out.println("Elemento removido: " + lista5.removerFinal());
        System.out.println("Lista: " + lista5);
        // [1, 2, 4] --> [1, 2]
        System.out.println("Elemento removido: " + lista5.removerFinal());
        System.out.println("Lista: " + lista5);
        System.out.println("Elemento removido: " + lista5.removerFinal());
        System.out.println("Lista: " + lista5);
    }
    public static void testeRemove() {
        ListaEncadeada<Integer> lista6 = new ListaEncadeada<>();

        lista6.adicionarUltimo(1);
        lista6.adicionarUltimo(2);
        lista6.adicionarUltimo(3);
        lista6.adicionarUltimo(4);
        lista6.adicionarUltimo(5);

        System.out.println("Elemento removido: " + lista6.remover(0));
        System.out.println("Lista: " + lista6);
        // [1, 2, 3, 4, 5] --> [2, 3, 4, 5]
        System.out.println("Elemento removido: " + lista6.remover(1));
        System.out.println("Lista: " + lista6);
        // [2, 3, 4, 5] --> [2, 4, 5]
        System.out.println("Elemento removido: " + lista6.remover(1));
        System.out.println("Lista: " + lista6);
        // [2, 4, 5] --> [2, 5]

    }
}

// Nó: 1 <-- inicio && ultimo, tamanho = 1
// Novo Nó: 2 <-- ultimo.setProximo(2) && ultimo, tamanho = 2
// Novo Nó: 3 <-- ultimo.setProximo(3) && ultimo, tamanho = 3

// 1 (Inicio) --> 2 --> 3 (Ultimo)
