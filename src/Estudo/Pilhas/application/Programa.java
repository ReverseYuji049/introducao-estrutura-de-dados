package Estudo.Pilhas.application;


import Estudo.Pilhas.entities.PilhaEstatica;

public class Programa {
    static void main() {
        testeEmpilhar();
        testeDesempilhar();
        testeCapacidade();
        testePilhaVazia();
    }

    public static void testeEmpilhar() {
        System.out.println("\n==== EMPILHAR ====");

        PilhaEstatica<Integer> pilha1 = new PilhaEstatica<>(5);
        System.out.println("Tamanho da pilha: " + pilha1.tamanho());
        pilha1.empilhar(1);
        pilha1.empilhar(2);
        pilha1.empilhar(3);
        pilha1.empilhar(4);
        pilha1.empilhar(5);

        System.out.println("Tamanho da pilha: " + pilha1.tamanho());
        System.out.println("Topo: " + pilha1.topo());
        System.out.println("Pilha com números: " + pilha1);
        pilha1.empilhar(6);
        System.out.println("Tamanho da pilha: " + pilha1.tamanho());
        System.out.println("Pilha com números: " + pilha1);

        PilhaEstatica<String> pilha2 = new PilhaEstatica<>(3);

        pilha2.empilhar("Jujutsu Kaisen");
        pilha2.empilhar("Demon Slayer");
        pilha2.empilhar("One Piece");

        System.out.println("Topo: " + pilha2.topo());
        System.out.println("Pilha com Strings: " + pilha2);
    }
    public static void testeDesempilhar() {
        System.out.println("\n==== TESTE DESEMPILHAR ====");

        PilhaEstatica<String> pilha = new PilhaEstatica<>();

        pilha.empilhar("Abacaxi");
        pilha.empilhar("Uva");
        pilha.empilhar("Morango");

        System.out.println("Antes: " + pilha);
        System.out.println("Removido: " + pilha.desempilhar());
        System.out.println("Depois: " + pilha);
    }
    public static void testeCapacidade() {
        System.out.println("\n==== TESTE CAPACIDADE DINÂMICA ====");

        PilhaEstatica<Integer> pilha = new PilhaEstatica<>(2);

        for (int i = 1; i <= 5; i++) {
            pilha.empilhar(i);
            System.out.println("Empilhou: " + i);
        }

        System.out.println("Pilha final: " + pilha);
    }
    public static void testePilhaVazia() {
        System.out.println("\n==== TESTE PILHA VAZIA ====");

        PilhaEstatica<String> pilha = new PilhaEstatica<>();

        System.out.println("Está vazia? " + pilha.estaVazia());
        System.out.println("Topo: " + pilha.topo());
        System.out.println("Desempilhar: " + pilha.desempilhar());
    }
}