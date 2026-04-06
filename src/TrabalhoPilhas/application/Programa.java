package TrabalhoPilhas.application;

import TrabalhoPilhas.entities.PilhaDinamica;
import TrabalhoPilhas.entities.PilhaEstatica;

public class Programa {
    static void main() {
        System.out.println("================= PILHA ESTÁTICA =================");
        PilhaEstatica pilhaEstatica = new PilhaEstatica(5);
        pilhaEstatica.empilhar("Arroz");
        pilhaEstatica.empilhar("Carne");
        pilhaEstatica.empilhar("Salada");
        pilhaEstatica.empilhar("Feijão");
        pilhaEstatica.empilhar("Batata");
        pilhaEstatica.exibir();
        System.out.println("Topo: " + pilhaEstatica.topo());
        System.out.println("Elemento removido: " + pilhaEstatica.desempilhar());
        pilhaEstatica.exibir();


        System.out.println("================= PILHA DINÂMICA =================");
        PilhaDinamica pilhaDinamica = new PilhaDinamica();

        pilhaDinamica.empilhar("Arroz");
        pilhaDinamica.empilhar("Carne");
        pilhaDinamica.empilhar("Salada");
        pilhaDinamica.empilhar("Feijão");
        pilhaDinamica.exibir();
        System.out.println("Topo: " + pilhaDinamica.topo());
        System.out.println("Elemento removido: " + pilhaDinamica.desempilhar());
        pilhaDinamica.exibir();
    }
}
