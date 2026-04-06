package Estudo.Pilhas.application;

import Estudo.Pilhas.entities.PilhaDinamica;

public class ProgramaPilhaDinamica {
    static void main() {
        testeEmpilhar();
        testeDesempilhar();
        pilhaVazia();
    }
    public static void testeEmpilhar() {
        System.out.println("\n==== EMPILHAR ====");
        PilhaDinamica<Integer> pilha1 = new PilhaDinamica<>();

        pilha1.empilhar(1);
        pilha1.empilhar(2);
        pilha1.empilhar(3);
        pilha1.empilhar(4);
        pilha1.empilhar(5);

        System.out.println("Tamanho da pilha: " + pilha1.tamanho());
        // Tamanho da pilha: 5
        System.out.println("Topo: " + pilha1.topo());
        // Topo: 5
        System.out.println("Pilha com números: " + pilha1);
        // Pilha com números: Topo -> 5 | 4 | 3 | 2 | 1 <- Base
        pilha1.empilhar(6);
        System.out.println("Tamanho da pilha: " + pilha1.tamanho());
        //Pilha com números: Topo -> 6 | 5 | 4 | 3 | 2 | 1 <- Base
        System.out.println("Pilha com números: " + pilha1);
        System.out.println();

        PilhaDinamica<String> pilha2 = new PilhaDinamica<>();

        pilha2.empilhar("Jujutsu Kaisen");
        pilha2.empilhar("Demon Slayer");
        pilha2.empilhar("One Piece");

        System.out.println("Topo: " + pilha2.topo());
        // Topo: One Piece
        System.out.println("Pilha com Strings: " + pilha2);
        // Pilha com Strings: Topo -> One Piece | Demon Slayer | Jujutsu Kaisen <- Base
    }
    public static void testeDesempilhar() {
        System.out.println("\n==== DESEMPILHAR ====");
        PilhaDinamica<Integer> pilha3 = new PilhaDinamica<>();

        pilha3.empilhar(1);
        pilha3.empilhar(2);
        pilha3.empilhar(3);
        pilha3.empilhar(4);
        pilha3.empilhar(5);

        System.out.println("Pilha " + pilha3);
        // Pilha Topo -> 5 | 4 | 3 | 2 | 1 <- Base

        // pilha3.desempilhar();
        System.out.println("Elemento removido: " + pilha3.desempilhar());
        System.out.println("Pilha " + pilha3);
        // Pilha Topo -> 4 | 3 | 2 | 1 <- Base
    }
    public static void pilhaVazia() {
        System.out.println("\n==== TESTE PILHA VAZIA ====");
        PilhaDinamica<Integer> pilha4 = new PilhaDinamica<>();

        System.out.println("Está vazia? " + pilha4.estaVazia());
        System.out.println("Topo: " + pilha4.topo());
        System.out.println("Desempilhar: " + pilha4.desempilhar());
    }
}
