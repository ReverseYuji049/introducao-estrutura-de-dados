package Aula5.application;

import Aula5.entities.FilaDinamica;

public class Programa {
    static void main() {

        FilaDinamica filaDinamica = new FilaDinamica();

        filaDinamica.enfileirar("Arroz");
        filaDinamica.enfileirar("Feijão");
        filaDinamica.enfileirar("Batata");
        filaDinamica.enfileirar("Carne");
        filaDinamica.exibir();
        filaDinamica.desenfileirar();
        filaDinamica.desenfileirar();
        filaDinamica.exibir();
    }
}
