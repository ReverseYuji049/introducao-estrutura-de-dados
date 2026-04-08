package Estudo.ListaEncadeadaDupla.application;

import Estudo.ListaEncadeadaDupla.entities.ListaEncadeadaDupla;

public class ProgramaListaDupla {
    static void main() {
        // 🔹 Criando a lista
        ListaEncadeadaDupla<Integer> lista = new ListaEncadeadaDupla<>();

        System.out.println("\n--- TESTE 1: Lista vazia ---");
        System.out.println(lista); // []

        // 🔹 Adicionar no início
        System.out.println("\n--- TESTE 2: Adicionar no início ---");
        lista.adicionarInicio(3);
        lista.adicionarInicio(2);
        lista.adicionarInicio(1);
        System.out.println(lista); // [1, 2, 3]

        // 🔹 Adicionar no final
        System.out.println("\n--- TESTE 3: Adicionar no final ---");
        lista.adicionarFim(4);
        lista.adicionar(4, 5);
        System.out.println(lista); // [1, 2, 3, 4, 5]

        // 🔹 Adicionar no meio
        System.out.println("\n--- TESTE 4: Adicionar no meio ---");
        lista.adicionar(2, 99); // posição 2
        System.out.println(lista); // [1, 2, 99, 3, 4, 5]

        // 🔹 Remover início
        System.out.println("\n--- TESTE 5: Remover início ---");
        System.out.println("Removido: " + lista.removerInicio());
        System.out.println(lista); // [2, 99, 3, 4, 5]

        // 🔹 Remover final
        System.out.println("\n--- TESTE 6: Remover final ---");
        System.out.println("Removido: " + lista.removerFinal());
        System.out.println(lista); // [2, 99, 3, 4]

        // 🔹 Remover meio
        System.out.println("\n--- TESTE 7: Remover posição 1 ---");
        System.out.println("Removido: " + lista.remover(1));
        System.out.println(lista); // [2, 3, 4]

        // 🔹 Testar tamanho
        System.out.println("\n--- TESTE 8: Tamanho ---");
        System.out.println("Tamanho: " + lista.getTamanho());

        // 🔹 Remover tudo
        System.out.println("\n--- TESTE 9: Esvaziar lista ---");
        while (lista.getTamanho() > 0) {
            System.out.println("Removido: " + lista.removerInicio());
        }
        System.out.println(lista); // []

        // 🔹 Testar exceção
        System.out.println("\n--- TESTE 10: Teste de erro ---");
        try {
            lista.removerInicio();
        } catch (Exception e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }

        // 🔹 Teste com Strings
        System.out.println("\n--- TESTE 11: Lista de Strings ---");
        ListaEncadeadaDupla<String> listaStr = new ListaEncadeadaDupla<>();

        listaStr.adicionarFim("A");
        listaStr.adicionarFim("B");
        listaStr.adicionarFim("C");

        System.out.println(listaStr); // [A, B, C]

        listaStr.remover(1);
        System.out.println(listaStr); // [A, C]

        // 🔹 Teste de inserção complexa
        System.out.println("\n--- TESTE 12: Inserções complexas ---");
        listaStr.adicionarInicio("X");
        listaStr.adicionar(2, "Y");
        listaStr.adicionarFim("Z");

        System.out.println(listaStr); // [X, A, Y, C, Z]

        System.out.println("\n--- FIM DOS TESTES ---");
    }
}
