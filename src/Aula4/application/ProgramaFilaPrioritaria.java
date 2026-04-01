package Aula4.application;

import Aula4.entities.FilaSimplesPrioritaria;

public class ProgramaFilaPrioritaria {
    static void main() {
        FilaSimplesPrioritaria fsp = new FilaSimplesPrioritaria(5);
        fsp.enfileirar(5, 0);
        fsp.enfileirar(1, 1);
        fsp.enfileirar(15, 0);
        System.out.println("----------------------");
        fsp.exibir();
    }
}
