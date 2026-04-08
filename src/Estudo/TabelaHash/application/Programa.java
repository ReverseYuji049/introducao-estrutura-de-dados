package Estudo.TabelaHash.application;

import Estudo.TabelaHash.entities.ListaTabelaHash;

public class Programa {
    static void main() {
        testeInsercao();
        testeColisao();
        testeBusca();
        testeRemocao();
        testeCasoNaoEncontrado();
    }
    public static void testeInsercao() {
        System.out.println("\n--- TESTE 1: Inserção simples ---");

        ListaTabelaHash tabela = new ListaTabelaHash(5);

        tabela.adicionarViaHash(1);
        tabela.adicionarViaHash(2);
        tabela.adicionarViaHash(3);

        tabela.exibir();
    }

    // 🔹 TESTE 2: Colisão (sondagem linear)
    public static void testeColisao() {
        System.out.println("\n--- TESTE 2: Colisão ---");

        ListaTabelaHash tabela = new ListaTabelaHash(5);

        // Todos caem na mesma posição (mod 5 = 0)
        tabela.adicionarViaHash(5);
        tabela.adicionarViaHash(10);
        tabela.adicionarViaHash(15);

        tabela.exibir();
    }

    // 🔹 TESTE 3: Busca
    public static void testeBusca() {
        System.out.println("\n--- TESTE 3: Busca ---");

        ListaTabelaHash tabela = new ListaTabelaHash(5);

        tabela.adicionarViaHash(7);
        tabela.adicionarViaHash(12); // colisão com 7

        tabela.exibir();

        tabela.buscarViaHash(7);   // deve encontrar
        tabela.buscarViaHash(12);  // deve encontrar
    }

    // 🔹 TESTE 4: Remoção
    public static void testeRemocao() {
        System.out.println("\n--- TESTE 4: Remoção ---");

        ListaTabelaHash tabela = new ListaTabelaHash(5);

        tabela.adicionarViaHash(8);
        tabela.adicionarViaHash(13); // colisão

        tabela.exibir();

        tabela.removerViaHash(8);

        System.out.println("Após remover:");
        tabela.exibir();

        // Testar se ainda encontra o outro elemento
        tabela.buscarViaHash(13);
    }

    // 🔹 TESTE 5: Elemento inexistente
    public static void testeCasoNaoEncontrado() {
        System.out.println("\n--- TESTE 5: Elemento não encontrado ---");

        ListaTabelaHash tabela = new ListaTabelaHash(5);

        tabela.adicionarViaHash(3);
        tabela.adicionarViaHash(6);

        tabela.buscarViaHash(99); // não existe
        tabela.removerViaHash(99); // não existe
    }

}
