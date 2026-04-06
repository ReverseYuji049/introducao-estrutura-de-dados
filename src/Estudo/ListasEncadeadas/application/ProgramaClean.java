package Estudo.ListasEncadeadas.application;

import Estudo.ListasEncadeadas.entities.ListaEncadeada;
import Estudo.ListasEncadeadas.entities.ListaEncadeadaClean;

public class ProgramaClean {
    static void main() {
        System.out.println("======= Testes Iniciais =======");
        teste1();
        System.out.println("======= Teste: Adicionar no Início =======");
        testeAdicionaInicio();
        System.out.println("======= Teste: Adicionar por Posição =======");
        testeAdicionaPosicao();
        System.out.println("======= Teste: Remover Início =======");
        testeRemoveInicio();
        System.out.println("======= Teste: Remover Final =======");
        testeRemoveFinal();
        System.out.println("======= Teste: Remover =======");
        testeRemove();
    }
    public static void teste1() {
        ListaEncadeadaClean<Integer> lista = new ListaEncadeadaClean<>();
        System.out.println("Tamanho da lista: " + lista.getTamanho());

        lista.adicionarUltimo(1);
        lista.adicionarUltimo(2);
        lista.adicionarUltimo(3);
        System.out.println(lista);

    }
    public static void testeAdicionaInicio() {
        ListaEncadeadaClean<Integer> lista2 = new ListaEncadeadaClean<>();
        lista2.adicionarInicio(1);
        lista2.adicionarInicio(2);
        lista2.adicionarInicio(3);
        System.out.println(lista2);
    }
    public static void testeAdicionaPosicao() {
        ListaEncadeadaClean<Integer> lista3 = new ListaEncadeadaClean<>();
        lista3.adicionarUltimo(1);
        lista3.adicionarUltimo(2);
        lista3.adicionarUltimo(4);
        lista3.adicionar(0, 0);
        lista3.adicionar(4, 5);
        lista3.adicionar(2, 3);
        System.out.println(lista3);
    }

    public static void testeRemoveInicio() {
        ListaEncadeadaClean<Integer> lista4 = new ListaEncadeadaClean<>();

        lista4.adicionarUltimo(1);
        lista4.adicionarUltimo(2);
        lista4.adicionarUltimo(4);
        System.out.println("Elemento removido: " + lista4.removerInicio());
        System.out.println("Lista: " + lista4);
        System.out.println("Elemento removido: " + lista4.removerInicio());
        System.out.println("Lista: " + lista4);
        System.out.println("Elemento removido: " + lista4.removerInicio());
        System.out.println("Lista: " + lista4);
    }
    public static void testeRemoveFinal() {
        ListaEncadeadaClean<Integer> lista5 = new ListaEncadeadaClean<>();

        lista5.adicionarUltimo(1);
        lista5.adicionarUltimo(2);
        lista5.adicionarUltimo(4);

        System.out.println("Elemento removido: " + lista5.removerFinal());
        System.out.println("Lista: " + lista5);

        System.out.println("Elemento removido: " + lista5.removerFinal());
        System.out.println("Lista: " + lista5);
        System.out.println("Elemento removido: " + lista5.removerFinal());
        System.out.println("Lista: " + lista5);
    }
    public static void testeRemove() {
        ListaEncadeadaClean<Integer> lista6 = new ListaEncadeadaClean<>();

        lista6.adicionarUltimo(1);
        lista6.adicionarUltimo(2);
        lista6.adicionarUltimo(3);
        lista6.adicionarUltimo(4);
        lista6.adicionarUltimo(5);

        System.out.println("Elemento removido: " + lista6.remover(0));
        System.out.println("Lista: " + lista6);
        System.out.println("Elemento removido: " + lista6.remover(1));
        System.out.println("Lista: " + lista6);
        System.out.println("Elemento removido: " + lista6.remover(1));
        System.out.println("Lista: " + lista6);
    }
}
