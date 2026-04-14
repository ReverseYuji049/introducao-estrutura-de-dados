package Estudo.Filas.application;

import Estudo.Filas.entities.FilaEstaticaPrioritaria.Elemento;
import Estudo.Filas.entities.FilaEstatica;
import Estudo.Filas.entities.FilaEstaticaPrioritaria.FilaEstaticaPrioritaria;

public class ProgramaFilaEstatica {
    static void main() {
        testeEnfileirar();
        testeDesenfileirar();
        testeFilaVazia();
        testeEnfileirarPosicao();
        testeFilaPrioridade();
    }

    public static void testeEnfileirar() {
        System.out.println("\n==== TESTE ENFILEIRAR ====");
        FilaEstatica<Integer> fila1 = new FilaEstatica<>(5);

        fila1.enfileirar(1);
        System.out.println("Fila: " + fila1);
        // Fila: [1]
        fila1.enfileirar(2);
        System.out.println("Fila: " + fila1);
        // Fila: [1, 2]
        fila1.enfileirar(3);
        System.out.println("Está vazio? " + fila1.estaVazia());
        // Está vazio? false
        System.out.println("Tamanho da fila: " + fila1.tamanho());
        // Tamanho da fila: 3
        System.out.println("Fila: " + fila1);
        // Fila: [1, 2, 3]
        fila1.enfileirar(4);
        System.out.println("Tamanho da fila: " + fila1.tamanho());
        // Tamanho da fila: 4
        System.out.println("Fila: " + fila1);
        // Fila: [1, 2, 3, 4]
        System.out.println("Primeiro da fila: " + fila1.espiar());
        // Primeiro da fila: 1
    }

    public static void testeDesenfileirar() {
        System.out.println("\n==== TESTE DESENFILEIRAR ====");
        FilaEstatica<Integer> fila2 = new FilaEstatica<>(5);

        fila2.enfileirar(1);
        fila2.enfileirar(2);
        fila2.enfileirar(3);
        System.out.println("Fila: " + fila2);
        // Fila: [1, 2, 3]
        System.out.println("Elemento removido: " + fila2.desenfileirar());
        // Elemento removido: 1
        System.out.println("Fila: " + fila2);
        // Fila: [2, 3]
    }
    public static void testeFilaVazia() {
        System.out.println("\n==== TESTE FILA VAZIA ====");
        FilaEstatica<Integer> fila3 = new FilaEstatica<>(3);

        System.out.println("Fila: " + fila3);
        System.out.println("Tamanho da fila: " + fila3.tamanho());
    }
    public static void testeEnfileirarPosicao() {
        System.out.println("\n==== TESTE ENFILEIRAR ====");
        FilaEstatica<Integer> fila4 = new FilaEstatica<>(5);

        fila4.enfileirar(1);
        fila4.enfileirar(2);
        fila4.enfileirar(3);
        System.out.println("Fila: " + fila4);
        System.out.println("Tamanho da fila: " + fila4.tamanho());
        fila4.enfileirarPosicao(1, 4);
        System.out.println("Fila: " + fila4);
        System.out.println("Tamanho da fila: " + fila4.tamanho());
    }
    public static void testeFilaPrioridade() {
        System.out.println("\n==== TESTE FILA PRIORITÁRIA ====");
        FilaEstaticaPrioritaria<Integer> filaPrioridade1 = new FilaEstaticaPrioritaria<>(5);
        filaPrioridade1.enfileirarPosicao(0, 10); // [10]
        filaPrioridade1.enfileirarPosicao(1, 30); // [10, 30]
        filaPrioridade1.enfileirarPosicao(1, 20); // [10, 20, 30]
        filaPrioridade1.enfileirarPosicao(0, 5);  // [5, 10, 20, 30]
        filaPrioridade1.enfileirarPosicao(4, 40); // [5, 10, 20, 30, 40]

        System.out.println("Fila de números com prioridade: " + filaPrioridade1);

        FilaEstaticaPrioritaria<Elemento> filaPrioridade = new FilaEstaticaPrioritaria<>(5);

        filaPrioridade.enfileirar(new Elemento("A", 2));
        filaPrioridade.enfileirar(new Elemento("B", 1));
        filaPrioridade.enfileirar(new Elemento("C", 3));

        System.out.println("Fila de elementos com prioridade: " + filaPrioridade);

        FilaEstaticaPrioritaria<Integer> fila = new FilaEstaticaPrioritaria<>(5);

        fila.enfileirar(30);
        fila.enfileirar(10);
        fila.enfileirar(20);
        fila.enfileirar(5);

        System.out.println("Fila ordenada: " + fila);
        // Esperado: [5, 10, 20, 30]
    }
}
