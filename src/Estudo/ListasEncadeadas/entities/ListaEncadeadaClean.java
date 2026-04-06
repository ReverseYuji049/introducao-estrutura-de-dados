package Estudo.ListasEncadeadas.entities;

public class ListaEncadeadaClean<T> {

    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;
    private final int NAO_ENCONTRADO = -1;
    private final String NAO_EXISTE = "Posição não existe";
    private final String LISTA_VAZIA = "A lista dinâmica está vazia!";

    public ListaEncadeadaClean() {
        System.out.println("Lista encadeada criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    // Inserindo elemento no final:
    public void adicionarUltimo(T elemento) {

        No<T> celula = new No<T>(elemento);

        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }
    // Inserindo no início da lista:
    public void adicionarInicio(T elemento) {
        if (this.tamanho == 0) {
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.ultimo = novoNo;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
        }
        this.tamanho++;
    }

    // Inserindo em qualquer lugar da lista:
    public void adicionar(int posicao, T elemento) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        if (posicao == 0) {
            adicionarInicio(elemento);
        } else if (posicao == this.tamanho) {
            this.adicionarUltimo(elemento);
        } else {
            No<T> noAnterior = this.buscaNo(posicao);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<>(elemento, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
    }

    // Remover o início da lista:
    public T removerInicio() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        T removido = this.inicio.getElemento();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;
        if (this.tamanho == 0) {
            this.ultimo = null;
        }
        return removido;
    }
    // Remover o final da lista:
    public T removerFinal() {
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        if (this.tamanho == 1) {
            return this.removerInicio();
        }
        No<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        T removido = penultimoNo.getProximo().getElemento();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;
        this.tamanho--;

        return removido;
    }

    // Verificar se existe:
    public boolean posicaoInexistente(int posicao) {
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    // Remover por qualquer posição:
    public T remover(int posicao) {
        if (this.posicaoInexistente(posicao)) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        if (posicao == 0) {
            return this.removerInicio();
        }
        if (posicao == this.tamanho - 1) {
            return this.removerFinal();
        }

        No<T> noAnterior = this.buscaNo(posicao - 1);
        No<T> noAtual = noAnterior.getProximo();
        No<T> proximoNo = noAtual.getProximo();
        noAnterior.setProximo(proximoNo);
        noAtual.setProximo(null);
        this.tamanho--;

        return noAtual.getElemento();
    }

    // Retorna o tamanho da lista encadeada (controle da lista):
    public int getTamanho(){
        return this.tamanho;
    }

    // Limpar a lista:
    public void limpar() {
        for (No<T> atual = this.inicio; atual != null;) {
            No<T> auxProximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = auxProximo;
        }
    }

    // Busca por posição:
    private No<T> buscaNo(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        No<T> noAtual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }
    // Busca do nó:
    public T buscaPosicao(int posicao) {
        return this.buscaNo(posicao).getElemento();
    }

    // Busca por elemento:
    public int buscaElemento(T elemento) {
        No<T> noAtual = this.inicio;
        int posicao = 0;

        while (noAtual != null) {
            if (noAtual.getElemento().equals(elemento)) {
                return posicao;
            }
            posicao++;
            noAtual = noAtual.getProximo();
        }
        return NAO_ENCONTRADO;
    }


    // Percorrer a lista:
    @Override
    public String toString() {

        if(this.tamanho == 0) {
            return("[]" + "\n" +
                    "\"A lista dinâmica está vazia!\"");
        }
        StringBuilder builder = new StringBuilder("[");
        No<T> atual = this.inicio;

        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        return builder.toString();


    }
}
