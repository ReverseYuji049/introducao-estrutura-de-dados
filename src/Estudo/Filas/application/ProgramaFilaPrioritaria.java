package Estudo.Filas.application;

import Estudo.Filas.entities.FilaEstaticaPrioritaria.FilaPrioritaria;

public class ProgramaFilaPrioritaria {
    static void main() {
        System.out.println("==== TESTE 1: Enfileirar ====");
        testeEnfileirar();

        System.out.println("\n==== TESTE 2: Desenfileirar ====");
        testeDesenfileirar();
    }

    public static void testeEnfileirar() {
        FilaPrioritaria fila1 = new FilaPrioritaria(5);

        fila1.enfileirar(10);
        fila1.enfileirar(20);
        fila1.enfileirar(5);
        fila1.enfileirar(15);

        System.out.println(fila1);
    }

    public static void testeDesenfileirar() {
        FilaPrioritaria fila3 = new FilaPrioritaria(5);

        fila3.enfileirar(10);
        fila3.enfileirar(50);
        fila3.enfileirar(30);
        fila3.enfileirar(40);

        System.out.println("Antes de desenfileirar:");
        System.out.println(fila3);

        // Remove o elemento maior
        fila3.desenfileirar();

        System.out.println("Depois de desenfileirar:");
        System.out.println(fila3);
    }
}
