package Aula6.application;

import Aula6.entities.ListaDupla;

public class Program {
    static void main() {
        ListaDupla listaDupla = new ListaDupla();
        listaDupla.adicionarElemento("Arroz");
        listaDupla.adicionarElemento("Feijão");
        listaDupla.adicionarElemento("Chuchu");
        listaDupla.adicionarElemento("Carne");
        listaDupla.removerElemento("Arroz");
    }
}
