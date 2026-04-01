package Aula4.application;

import Aula4.entities.FilaSimples;

public class Programa {
    static void main() {
        FilaSimples filaSimples = new FilaSimples(5);

        filaSimples.enfileirar(1);
        filaSimples.enfileirar(2);
        filaSimples.enfileirar(3);
        filaSimples.enfileirar(4);
        filaSimples.desenfileirar();
        filaSimples.exibir();

    }
}
