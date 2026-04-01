package Aula7.application;

import Aula7.entities.ListaSimplesHash;

public class Program {
    static void main() {
        ListaSimplesHash lsh = new ListaSimplesHash(7);
        lsh.adicionarViaHash(21); // 21 % 7 = 0
        lsh.adicionarViaHash(22); // 22 % 7 = 1
        lsh.adicionarViaHash(30); // 30 % 7 = 2
        lsh.adicionarViaHash(31); // 31 % 7 = 3
        lsh.adicionarViaHash(25); // 25 % 7 = 4
        lsh.adicionarViaHash(26); // 26 % 7 = 5
        lsh.adicionarViaHash(27); // 27 % 7 = 6

        System.out.println("Busca de elemento: ");
        lsh.buscarViaHash(30);
        lsh.exibirElementos();
    }
}
