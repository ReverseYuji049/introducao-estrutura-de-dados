package Estudo.Filas.application;

import Estudo.Filas.entities.FilaDinamica;

public class ProgramaFilaDinamica {
    static void main() {
        teste();
        testeEnfileirar();
        testeDesenfileirar();
        testeEspiar();
        testeFilaVazia();
    }

    public static void teste() {
        FilaDinamica<Integer> fila = new FilaDinamica<>();

        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);

        System.out.println(fila); // [1, 2, 3]

        fila.desenfileirar();

        System.out.println(fila); // [2, 3]
    }
    public static void testeEnfileirar() {
        System.out.println("\n==== TESTE ENFILEIRAR (DINÂMICA) ====");

        FilaDinamica<Integer> fila = new FilaDinamica<>();

        fila.enfileirar(1);
        System.out.println("Fila: " + fila);
        // [1]

        fila.enfileirar(2);
        System.out.println("Fila: " + fila);
        // [1, 2]

        fila.enfileirar(3);
        System.out.println("Está vazia? " + fila.estaVazia());
        // false

        System.out.println("Tamanho: " + fila.getTamanho());
        // 3

        System.out.println("Fila: " + fila);
        // [1, 2, 3]

        fila.enfileirar(4);
        System.out.println("Tamanho: " + fila.getTamanho());
        // 4

        System.out.println("Fila: " + fila);
        // [1, 2, 3, 4]
    }

    public static void testeDesenfileirar() {
        System.out.println("\n==== TESTE DESENFILEIRAR (DINÂMICA) ====");

        FilaDinamica<Integer> fila = new FilaDinamica<>();

        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);

        System.out.println("Fila: " + fila);
        // [1, 2, 3]

        System.out.println("Elemento removido: " + fila.desenfileirar());
        // 1

        System.out.println("Fila: " + fila);
        // [2, 3]

        System.out.println("Elemento removido: " + fila.desenfileirar());
        // 2

        System.out.println("Fila: " + fila);
        // [3]
    }

    public static void testeFilaVazia() {
        System.out.println("\n==== TESTE FILA VAZIA (DINÂMICA) ====");

        FilaDinamica<Integer> fila = new FilaDinamica<>();

        System.out.println("Fila: " + fila);
        // []

        System.out.println("Tamanho: " + fila.getTamanho());
        // 0

        System.out.println("Está vazia? " + fila.estaVazia());
        // true

        System.out.println("Desenfileirar: " + fila.desenfileirar());
        // null
    }

    public static void testeEspiar() {
        System.out.println("\n==== TESTE ESPIAR (DINÂMICA) ====");

        FilaDinamica<Integer> fila = new FilaDinamica<>();

        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(30);

        System.out.println("Fila: " + fila);
        // [10, 20, 30]

        System.out.println("Primeiro elemento: " + fila.espiar());
        // 10

        fila.desenfileirar();

        System.out.println("Novo primeiro: " + fila.espiar());
        // 20
    }
}
