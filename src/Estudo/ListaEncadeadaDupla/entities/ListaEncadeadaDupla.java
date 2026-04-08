package Estudo.ListaEncadeadaDupla.entities;

public class ListaEncadeadaDupla<T> {

    private No<T> inicio;

    private No<T> fim;

    private int tamanho;

    public ListaEncadeadaDupla() {
        this.tamanho = 0;
        System.out.println("Lista duplamente encadeada criada com sucesso!");
    }
    // Adicionar no início:
    //  - Cria um novo nó
    //  - Se estiver vazia, esse novo nó será o início e fim
    //  - Senão, insere ele no começo da lista.
    //  - O próximo dele será o antigo início
    //  - Agora, o novo início é o novo nó
    public void adicionarInicio(T elemento) {
        // Cria um novo nó
        No<T> novoNo = new No<>(elemento);
        // Se a lista estiver vazia, define o início e fim como o novo nó
        if (this.tamanho == 0) {
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            // Senão, liga o novo nó ao antigo início (insere no começo)
            novoNo.setProximo(this.inicio);
            // Faz o antigo início apontar de volta para o novo
            this.inicio.setAnterior(novoNo);
            // Atualiza o início da lista
            this.inicio = novoNo;
        }
        // Atualiza o tamanho da lista
        this.tamanho++;

    }
    // Adicionar no fim:
    //  - Cria um novo nó para adicionar no fim da lista
    //  - Se estiver vazia, adiciona no início
    //  - Senão, o último nó agora aponta para o novo nó
    //    A <--> B.getProximo (fim) --> novoNo
    //  - O anterior do novo nó é o fim antigo
    //    A <--> B (antigo fim) <-- novoNo.getAnterior
    //  - O novo nó vira o fim atual
    //    A <--> B <--> novoNo (fim)
    //  - Incrementa o tamanho da lista
    public void adicionarFim(T elemento) {
        // Cria um novo nó
        No<T> novo = new No<>(elemento);
        // Se lista vazia
        if (this.tamanho == 0) {
            adicionarInicio(elemento);
        } else {
            // O último nó aponta para o novo
            this.fim.setProximo(novo);
            // O anterior do no nó é o antigo fim
            novo.setAnterior(this.fim);
            // Atualiza o fim da lista
            this.fim = novo;
        }
        // Atualiza o tamanho da lista
        this.tamanho++;
    }
    // Buscar um nó por posição:
    //  - Valida a posição
    //  - Cria uma variável para percorrer a lista desde o início
    //  - Percorre a lista, andando para o próximo até achar a posição
    //  - Retorna o nó encontrado
    private No<T> buscarNo(int posicao) {
        // Erro de posição inválida
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        // Cria uma variável que começa no início
        No<T> atual = this.inicio;

        // Percorre até a posição desejada
        for (int i = 0; i < posicao; i++) {
            // Anda para o próximo
            atual = atual.getProximo();
        }
        // Retorna o nó encontrado
        return atual;
    }
    // Adicionar em qualquer posição da lista:
    //  - Valida a posição
    //  - Se a posição for inicial ou a última, insere no início ou no fim da lista
    //  - Guarda o nó atual da posição desejada
    //  - Percorre toda a lista até achar essa posição
    //  - Cria novo nó para ser inserido
    //  - Liga o novo nó ao anterior e próximo da posição
    //    A (atual.getAnterior) <-- novoNó(atual) --> B (atual.GetProximo)
    //  - Liga o anterior e próximo dele ao novo nó
    //    A.getProximo --> novoNó <-- B.getAnterior
    //  - Incrementa o tamanho da lista
    public void adicionar(int posicao, T elemento) {
        // Erro de posição inválida
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        // Se a posição for a inicial, insere no início
        if (posicao == 0) {
            adicionarInicio(elemento);
        }
        // Inserção no final
        else if (posicao == this.tamanho) {
            adicionarFim(elemento);
        }
        // Inserção no meio
        else {
            // Guarda o nó atual da posição desejada e a busca na lista
            No<T> atual = buscarNo(posicao);
            // Cria um novo nó
            No<T> novo = new No<>(elemento);
            // Liga o novo ao anterior
            novo.setAnterior(atual.getAnterior());
            // Liga o novo ao próximo
            novo.setProximo(atual);
            // Ajusta o anterior para apontar para o novo
            atual.getAnterior().setProximo(novo);
            // Ajusta o atual para apontar para o novo
            atual.setAnterior(novo);
            // Atualiza o tamanho da lista
            this.tamanho++;
        }
    }
    // Remover do início: A (inicio) <--> B <--> C
    //  - Garante que a lista tenha algum conteúdo
    //  - Guarda o elemento a ser removido do início
    //  - Move o início para o nó posterior dele
    //    B (novo início) <--> C
    //  - Se ainda tiver elementos, define o anterior do novo início para nulo
    //    novoInicio.setAnterior(null). null <-- B <--> C
    //  - Decrementa a lista
    //  - Retorna o elemento removido (A)
    public T removerInicio() {
        // Verifica se está vazia
        if (this.tamanho == 0) {
            throw new RuntimeException("Lista vazia");
        }

        // Guarda o elemento a ser removido
        T removido = this.inicio.getElemento();
        // Move o início para o próximo (direita)
        this.inicio = this.inicio.getProximo();

        // Se ainda houver elementos
        if (this.inicio != null) {
            // Remove a ligação para trás (anterior)
            this.inicio.setAnterior(null);
        } else {
            // Se ficar vazia
            this.fim = null;
        }
        // Atualiza o tamanho da lista
        this.tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Remover do fim: A <--> B <--> C (fim)
    //  - Garante que a lista tenha algum conteúdo
    //  - Guarda o elemento a ser removido do fim
    //  - Move o fim para o anterior dele
    //  A <--> B (novo fim)
    //  - Se ainda houver elementos, define o próximo do novo fim como null
    //  A <--> B (novo fim) --> null
    //  - Decrementa a lista
    //  - Retorna o elemento removido (C)
    public T removerFinal() {
        // Verifica se a lista está vazia
        if (this.tamanho == 0) {
            throw new RuntimeException("Lista vazia");
        }
        // Guarda o elemento do nó a ser removido do fim
        T removido = this.fim.getElemento();
        // Move para o anterior
        this.fim = this.fim.getAnterior();

        // Se ainda houver elementos
        if (this.fim != null) {
            this.fim.setProximo(null);
        } else {
            // Se a lista ficar vazia:
            this.inicio = null;
        }
        // Atualiza o tamanho da lista
        this.tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Remover por posição: A <--> B (nó a ser removido) <--> C
    // - Se a posição for a primeira ou último, remove do início ou fim
    // - Senão, guarda o nó a ser removido e o procura pela lista
    //   atual --> percorre a lista até B
    // - Conecta o anterior dele ao próximo
    //   A (B.getAnterior) --> C (B.getProximo)
    // - Conecta o próximo dele ao anterior
    //   C (B.getProximo) <-- A (B.getAnterior)
    // - Decrementa a lista
    // - Retorna o elemento removido (B)
    public T remover(int posicao) {
        // Erro de posição inválida:
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        // Se é a posição inicial, remove o início
        if (posicao == 0) {
            return removerInicio();
        }
        // Se a posição for igual ao fim, remove o final:
        if (posicao == this.tamanho - 1) {
            return removerFinal();
        }
        // Guarda o nó a ser removido e o busca na lista
        No<T> atual = buscarNo(posicao);
        // Conecta o anterior ao próximo
        atual.getAnterior().setProximo(atual.getProximo());
        // Conecta o próximo ao anterior
        atual.getProximo().setAnterior(atual.getAnterior());
        // Guarda o nó removido
        T removido = atual.getElemento();
        // Atualiza o tamanho da lista
        this.tamanho--;
        // Retorna o elemento removido
        return removido;
    }
    // Retorna o tamanho da lista
    public int getTamanho() {
        return tamanho;
    }
    @Override
    public String toString() {

        // Se vazia
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        No<T> atual = this.inicio;

        // Percorre a lista
        while (atual != null) {
            sb.append(atual.getElemento());

            if (atual.getProximo() != null) {
                sb.append(", ");
            }

            atual = atual.getProximo();
        }

        sb.append("]");
        return sb.toString();
    }
}
