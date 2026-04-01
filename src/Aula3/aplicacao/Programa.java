package Aula3.aplicacao;

import Aula3.entidades.ListaDinamica;

public class Programa {
    static void main() {
        ListaDinamica listaDinamica = new ListaDinamica();
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Batata");
        listaDinamica.adicionarElemento("Alho");
        listaDinamica.adicionarElemento("Cebola");
        listaDinamica.removerElemento("Banana");
        listaDinamica.removerElemento("Arroz");
        listaDinamica.exibir();
    }
}
