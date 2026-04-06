package TrabalhoPilhas.entities;

public class PilhaDinamica {
    No topo; //só precisa guardar o nó do topo

    public PilhaDinamica() {
        this.topo = null; //pilha inicia vazia
        System.out.println("Pilha criada com sucesso!");
    }

    public boolean estaVazia() {
        return topo == null; //topo vazio
    }

    public void empilhar(String elemento) {

        No novo = new No(elemento); //cria o novo nó
        novo.setProx(topo); //aponta o novo nó para o topo atual
        topo = novo; //atualiza o topo da pilha
    }

    public String desempilhar() {
        if (estaVazia()) {
            return "A pilha está vazia!";
        } else {
            No removido = topo; //guarda o topo atual
            topo = topo.getProx(); //atualiza o topo pro próximo

            return removido.getConteudo(); //retorna o conteúdo removido
        }
    }

    public String topo() {
        if (estaVazia()) {
            return "A pilha está vazia!";
        } else {
            return topo.getConteudo();
        }
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("A pilha está vazia!");
            return;
        }
        No aux = this.topo;

        while (aux != null) {
            System.out.println(aux.getConteudo());
            aux = aux.getProx();
        }
    }
}
