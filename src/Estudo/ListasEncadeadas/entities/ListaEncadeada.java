package Estudo.ListasEncadeadas.entities;

// Algoritmo semelhante a LinkedList

// Lista do Tipo Genérico
public class ListaEncadeada<T> {

    // Referência do primeiro elemento
    private No<T> inicio;
    // Referência do último elemento
    private No<T> ultimo; // Percorre a lista
    // Tamanho da lista que inicia vazia
    private int tamanho = 0;
    // Variável constante para valor não encontrado
    private final int NAO_ENCONTRADO = -1;
    // Variável constante para posição que não existe
    private final String NAO_EXISTE = "Posição não existe";
    // Variável constante para lista vazia
    private final String LISTA_VAZIA = "A lista dinâmica está vazia!";

    public ListaEncadeada() {
        System.out.println("Lista encadeada criada com sucesso! Existem " + tamanho + " posições disponíveis.");
    }

    // Inserindo elemento no final:
    //  - Pegar o primeiro elemento e apontar a propriedade próximo para o novo Nó
    //  - Referenciar último elemento da lista
    public void adicionarUltimo(T elemento) {
        // Nó com elemento
        No<T> celula = new No<T>(elemento);

        // Se a lista estiver vazia:
        if (this.tamanho == 0) {
            // Aponta para a célula criada: inicio --> celula
            this.inicio = celula;
        } else {
            // Se não estiver vazia, o próximo elemento do último será a nova célula
            this.ultimo.setProximo(celula);
        }
        // Também aponta para a célula criada, em caso de só tiver um elemento: inicio && ultimo --> celula
        // Move o ponteiro do último para a célula
        this.ultimo = celula;

        // Incrementa o valor 1 para a variável
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
        // Erro de posição inválida
        if (posicao < 0 || posicao > this.tamanho) {
            // throw new IllegalArgumentException("Posição inválida.");
            throw new IllegalArgumentException(NAO_EXISTE);
        }

        // Início vazio
        if (posicao == 0) {
            adicionarInicio(elemento);
        } else if (posicao == this.tamanho) {
            // Adiciona na última posição
            this.adicionarUltimo(elemento);
        } else {
            // Inserir no meio da lista:
            No<T> noAnterior = this.buscaNo(posicao); // Referência ao elemento da posição
            No<T> proximoNo = noAnterior.getProximo(); // Próximo do nó anterior
            No<T> novoNo = new No<>(elemento, proximoNo); // Novo nó entre eles
            noAnterior.setProximo(novoNo); // O próximo do anterior virar o novo nó
            this.tamanho++;
        }
    }

    // Remover o início da lista:
    // - Pode ser boolean, void ou o tipo do elemento removido
    public T removerInicio() {
        // Erro de lista vazia
        if (this.tamanho == 0) {
            // throw new RuntimeException("A lista dinâmica está vazia!");
            throw new RuntimeException(LISTA_VAZIA);
        }
        // Referência do elemento removido
        T removido = this.inicio.getElemento();
        // Move a variável início para o próximo dele
        this.inicio = this.inicio.getProximo();
        // Diminui o tamanho da lista
        this.tamanho--;
        // Remove a referência do último
        if (this.tamanho == 0) {
            // Significa que só existe um elemento
            this.ultimo = null;
        }
        // Retorna qual elemento foi removido
        return removido;
    }
    // Remover o final da lista:
    // - Percorre até o penúltimo elemento (anterior do elemento a ser removido)
    // - tamanho - 2
    // - O próximo do penúltimo aponta para null (perde a referência do elemento removido)
    public T removerFinal() {
        // Erro de lista vazia
        if (this.tamanho == 0) {
            // throw new RuntimeException("A lista dinâmica está vazia!");
            throw new RuntimeException(LISTA_VAZIA);
        }
        // Lista com um único elemento
        if (this.tamanho == 1) {
            return this.removerInicio();
        }
        // Lista com pelos menos dois elementos

        // Referência ao penúltimo elemento
        No<T> penultimoNo = this.buscaNo(this.tamanho - 2);
        // Referência ao elemento removido
        T removido = penultimoNo.getProximo().getElemento();
        // Declara o último como null
        penultimoNo.setProximo(null);
        // Atualiza o último
        this.ultimo = penultimoNo;
        // Decrementa o tamanho
        this.tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Verificar se existe
    public boolean posicaoInexistente(int posicao) {
        return !(posicao >= 0 && posicao <= this.tamanho);
    }

    // Remover por qualquer posição:
    public T remover(int posicao) {
        // Erro de posição inválida
        if (this.posicaoInexistente(posicao)) {
           // throw new IllegalArgumentException("Posição não existe");
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        // Garante que a posição existe

        // Remove o primeiro elemento
        if (posicao == 0) {
            return this.removerInicio();
        }
        // Remove o último elemento
        if (posicao == this.tamanho - 1) {
            return this.removerFinal();
        }
        // Remove o elemento do meio

        // Nó anterior da posição que quer remover
        No<T> noAnterior = this.buscaNo(posicao - 1);
        // Nó a ser removido
        No<T> noAtual = noAnterior.getProximo();
        // Próximo do nó removido
        No<T> proximoNo = noAtual.getProximo();
        // Atualiza o nó anterior para o próximo do atual (removido)
        noAnterior.setProximo(proximoNo);
        // Aponta para null
        noAtual.setProximo(null);
        // Decrementa o tamanho
        this.tamanho--;

        // Retorna o elemento removido
        return noAtual.getElemento();
    }

    // Retorna o tamanho da lista encadeada (controle da lista)
    public int getTamanho(){
        return this.tamanho;
    }

    // Limpar a lista:
    // - Percorre a lista e atribui o valor nulo para todos os elementos
    public void limpar() {

        // Forma 1 (simples):
        // this.inicio = null;
        // this.ultimo = null;
        // this.tamanho = 0;

        // Forma 2:
        // Enquanto o atual não for vazio:
        for (No<T> atual = this.inicio; atual != null;) {
            // Incrementa/percorre a lista para limpá-la
            No<T> auxProximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = auxProximo;
        }
    }

    // Busca por posição:
    private No<T> buscaNo(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            // throw new IllegalArgumentException("Posição não existe.");
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        // Referência ao nó atual
        No<T> noAtual = this.inicio;
        // Move o ponteiro de um nó para outro
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }
        // Nó procurado
        return noAtual;
    }
    // Busca do nó:
    public T buscaPosicao(int posicao) {
        return this.buscaNo(posicao).getElemento();
    }

    // Busca por elemento:
    //  - Percorre a lista toda
    //  - Verifica se é o elemento a ser buscado
    public int buscaElemento(T elemento) {

        // Referência ao nó atual
        No<T> noAtual = this.inicio;
        int posicao = 0;

        // Enquanto o nó atual existir:
        while (noAtual != null) {
            // Se encontrou o elemento:
            if (noAtual.getElemento().equals(elemento)) {
                return posicao;
            }
            // Senão, incrementa a posição e move o noAtual
            posicao++;
            noAtual = noAtual.getProximo();
        }
        return NAO_ENCONTRADO;
    }

    // Percorrer a lista:
    //  - Referência (atual/ponteiro) que é atribuída ao inicio
    //  - Enquanto houver um próximo elemento, o obtém, movendo esse ponteiro atual
    //  - O ponteiro irá percorrer a lista até que exista um próximo elemento
    @Override
    public String toString() {

        if(this.tamanho == 0) {
            return("[]" + "\n" +
                    "\"A lista dinâmica está vazia!\"");
        }
        StringBuilder builder = new StringBuilder("[");
        // builder.append("Lista Encadeada [inicio: ").append(inicio).append("]");

        // Referência atual
        No<T> atual = this.inicio;

        // Forma 1:
        /*
         * builder.append(atual.getElemento()).append(", ");
         * Enquanto existir um próximo elemento
         * while (atual.getProximo() != null) {
         *  // Move o ponteiro atual para o próximo elemento
         *  atual = atual.getProximo();
         *  builder.append(atual.getElemento()).append(", ");
         * }
        */

        // Forma 2:
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(", ");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");

        return builder.toString();
    }
}

// ANOTAÇÕES

// Inserindo elemento no final:
//  - Pegar o primeiro elemento e apontar a propriedade próximo para o novo Nó
//  - Referenciar último elemento da lista

// Percorrer a lista:
//  - Referência (atual/ponteiro) que é atribuída ao inicio
//  - Enquanto houver um próximo elemento, o obtém, movendo esse ponteiro atual
//  - O ponteiro irá percorrer a lista até que exista um próximo elemento

