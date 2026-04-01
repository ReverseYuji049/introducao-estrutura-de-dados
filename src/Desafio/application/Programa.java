package Desafio.application;

import Aula3.entidades.ListaDinamica;
import Desafio.entities.ListaDinamicaInsertion;

public class Programa {
    static void main() {
        ListaDinamicaInsertion insertion = new ListaDinamicaInsertion();
        insertion.adicionarElemento(1);
        insertion.adicionarElemento(3);
        insertion.adicionarElemento(5);
        insertion.adicionarElemento(8);
        insertion.adicionarElemento(6); //atual
        insertion.exibir();
        System.out.println("=== INSERTION SORT ===");
        insertion.insertionSort();
        insertion.exibir();

        System.out.println("=====================================================");
        System.out.println("Lista em ordem decrescente.");
        ListaDinamicaInsertion insertion2 = new ListaDinamicaInsertion();
        insertion2.adicionarElemento(4);
        insertion2.adicionarElemento(3);
        insertion2.adicionarElemento(2);
        insertion2.exibir();
        System.out.println("=== INSERTION SORT ===");
        insertion2.insertionSort();
        insertion2.exibir();

        System.out.println("=====================================================");
        System.out.println("Teste: Verificação de lista vazia.");
        ListaDinamicaInsertion insertionVazio = new ListaDinamicaInsertion();
        insertionVazio.insertionSort();

        System.out.println("=====================================================");
        System.out.println("Teste: Verificação de um elemento na lista.");
        ListaDinamicaInsertion insertionElementoUnico = new ListaDinamicaInsertion();
        insertionElementoUnico.adicionarElemento(4);
        insertionElementoUnico.exibir();
        insertionElementoUnico.insertionSort();

    }
}
