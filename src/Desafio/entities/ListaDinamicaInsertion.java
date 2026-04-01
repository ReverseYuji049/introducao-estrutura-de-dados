package Desafio.entities;

public class ListaDinamicaInsertion {
    No inicio;

    public ListaDinamicaInsertion() {
        this.inicio = null;
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(int elemento) {
        if (this.inicio == null) {
            this.inicio = new No(elemento);

        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);

            while (aux.getProx() != null) {
                aux = aux.getProx();
            }

            aux.setProx(novoNo);
        }
    }
    public void exibir() {
        if (inicioVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;

            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }
    private boolean inicioVazio() {
        if (this.inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean umElemento() {
        // Se o início tiver pelo menos um elemento e o próximo estiver vazio
        return this.inicio != null && this.inicio.getProx() == null;
    }

    public void removerElemento(int elemento) {
        if (inicioVazio()) {
            System.out.println("Não existem elementos a serem removidos.");
        } else {
            if (procurarElemento(elemento)) {

                if (this.inicio.getProx() == null) {
                    this.inicio = null;

                } else if (this.inicio.getProx() != null) {

                    No aux = this.inicio;
                    while (aux != null) {
                        if (this.inicio.getConteudo() == elemento) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            this.inicio = this.inicio.getProx();
                            return;

                        } else if (aux.getProx().getConteudo() == elemento) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            aux.setProx(aux.getProx().getProx());
                            return;

                        }
                        aux = aux.getProx();
                    }
                }
            }
        }
    }
    public boolean procurarElemento(int elemento) {
        if (inicioVazio()) {
            System.out.println("Não existem elementos a serem procurados.");
        } else {
            No aux = this.inicio;
            while (aux != null) {
                if(aux.getConteudo() == elemento) {
                    System.out.println("Elemento " + elemento + " encontrado.");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento não existe na lista.");
        }
        return false;
    }

    public void insertionSort() {
        if (inicioVazio()) {
            System.out.println("A lista está vazia!");
        }
        if (umElemento()) {
            System.out.println("A lista só tem um elemento!");
        } else {
            No atual = inicio; //ponteiro que percorre a lista dinâmica
            No ordenado = null; //lista ordenada inicia vazia

            while (atual != null) {
                No proximo = atual.getProx(); //guarda o próximo nó
                if (ordenado == null || atual.getConteudo() < ordenado.getConteudo()) {
                    //se o nó ordenado estiver vazio OU o elemento do ordenado for maior que o do atual
                    atual.setProx(ordenado); //o atual aponta pro antigo começo
                    ordenado = atual; //atualiza o início da lista
                } else {
                    No aux = ordenado;
                    //enquanto o próximo do nó ordenado não for nulo E
                    //enquanto o elemento do próximo do auxiliar for menor que o elemento do nó atual
                    while (aux.getProx() != null && aux.getProx().getConteudo() < atual.getConteudo()) {
                        aux = aux.getProx(); //auxiliar vira o próximo dele
                    }
                    atual.setProx(aux.getProx()); //o atual aponta para o próximo do auxiliar
                    aux.setProx(atual); //o auxiliar aponta para o atual
                }
                atual = proximo; //avança o atual
            }
            this.inicio = ordenado; //atualiza o início original para a lista ordenada
        }
    }
}
