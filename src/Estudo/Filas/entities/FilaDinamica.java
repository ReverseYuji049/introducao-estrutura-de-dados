package Estudo.Filas.entities;

//@SuppressWarnings("unchecked")
public class FilaDinamica<T> {
    // Início da fila
    private No<T> inicio;
    // Fim da fila
    private No<T> fim;
    private int tamanho;

    public FilaDinamica() {
        System.out.println("Fila dinâmica criada com sucesso!");
        // Define o tamanho inicial da fila
        this.tamanho = 0;
    }

    // Enfileirar:
    //  - Adiciona os nós ao fim da fila
    public void enfileirar(T elemento) {
        // Novo nó com elemento novo
        No<T> novoNo = new No<>(elemento);
        // Se a lista estiver vazia, adiciona esse novo nó ao início
        if (estaVazia()) {
            this.inicio = novoNo;
        }
        // Senão, adiciona o novo nó ao fim da lista
        else {
            this.fim.setProximo(novoNo);
        }
        // Define o final com o novo nó
        this.fim = novoNo;
        // Atualiza o tamanho da fila
        tamanho++;
    }
    // Retorna o tamanho da fila:
    public int getTamanho() {
        return this.tamanho;
    }

    // Verifica se está vazia:
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Desenfileirar:
    //  - First in, first out
    //  - Retira o primeiro da fila
    public T desenfileirar() {
        if (estaVazia()) {
            System.out.println("A fila está vazia!");
            return null;
        }
        // Guarda o elemento removido
        T removido = this.inicio.getElemento();
        // Remove o elemento e move o início
        this.inicio = inicio.getProximo();
        // Caso de um único elemento na fila
        if (this.inicio == null) {
            this.fim = null;
        }
        // Atualiza o tamanho da fila
        tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Retorna o primeiro elemento da fila sem o remover:
        public T espiar() {
            // Verifica se está vazia:
            if (estaVazia()) {
                System.out.println("A fila está vazia!");
                return null;
            }
            return inicio.getElemento();
        }
    // Exibe a fila dinâmica:
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        No<T> atual = inicio;

        while (atual != null) {
            s.append(atual.getElemento());
            if (atual.getProximo() != null) {
                s.append(", ");
            }
            atual = atual.getProximo();
        }

        s.append("]");
        return s.toString();
    }
}
