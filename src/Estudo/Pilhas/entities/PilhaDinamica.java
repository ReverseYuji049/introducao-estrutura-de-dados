package Estudo.Pilhas.entities;

public class PilhaDinamica<T> {

    // Guarda o topo da pilha
    private No<T> topo;
    // Define o tamanho da pilha
    private int tamanho;

    public PilhaDinamica() {
        // A pilha inicia vazia
        this.topo = null;
        this.tamanho = 0;
        System.out.println("Pilha dinâmica criada com sucesso!");
    }

    // Verifica se a pilha está vazia:
    public boolean estaVazia(){
        return topo == null;
    }
    // Empilhar (push):
    // - Topo --> null
    // - É preciso instanciar um novo nó (elemento)
    public void empilhar(T elemento) {

        // Cria um novo nó
        No<T> novoNo = new No<T>(elemento);
        // O próximo dele se torna o topo
        novoNo.setProximo(topo);
        // Atualiza o topo
        topo = novoNo;
        // Atualiza o tamanho
        tamanho++;
    }
    // Desempilhar (pop):
    //  - Retira o topo
    //  - topoAntigo --> novoTopo --> Nó
    //  - novoTopo --> nó
    public T desempilhar() {
        // Verificação de pilha vazia
        if (estaVazia()) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        // Guarda o topo da pilha
        T removido = topo.getConteudo();
        // Atualiza o topo e remove o antigo
        topo = topo.getProximo();
        // Atualiza o tamanho da pilha
        tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Topo da pilha:
    public T topo() {
        // Verificação de pilha vazia
        if (estaVazia()) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        return topo.getConteudo();
    }

    public int tamanho() {
        return this.tamanho;
    }
    @Override
    public String toString() {
        // Verifica se a pilha está vazia
        if (estaVazia()) {
            return "A pilha está vazia!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Topo -> ");

        No<T> atual = topo;

        while (atual != null) {
            sb.append(atual.getConteudo());

            if (atual.getProximo() != null) {
                sb.append(" | ");
            }

            atual = atual.getProximo();
        }

        sb.append(" <- Base");

        return sb.toString();
    }
    // Exibição da pilha
//    public void exibir() {
//        if (estaVazia()) {
//            System.out.println("A pilha está vazia!");
//        }
//        No<T> aux = this.topo;
//
//        while (aux != null) {
//            System.out.println(aux.getConteudo());
//            aux = aux.getProximo();
//        }
//    }
}
