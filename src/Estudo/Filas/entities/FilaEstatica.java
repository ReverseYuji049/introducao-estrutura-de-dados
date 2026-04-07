package Estudo.Filas.entities;

// Avisa ao compilador que a warning está controlado.
@SuppressWarnings("unchecked")
public class FilaEstatica <T> {
    // Fila do tipo genérico
    private T[] elementos;
    // Tamanho da fila
    private int tamanho;

    public FilaEstatica(int capacidade) {
        // Cria novo elemento na fila
        this.elementos = (T[]) new Object[capacidade];
        // Define o tamanho inicial como vazio
        this.tamanho = 0;
        System.out.println("Fila estática criada com sucesso!");
    }
    protected T getElemento(int i) {
        return elementos[i];
    }
    protected void setElemento(int i, T valor) {
        elementos[i] = valor;
    }
    // Enfileirar:
    //  - Insere o novo elemento ao final da fila
    public void enfileirar(T elemento) {
        // Aumenta a capacidade da fila se necessário
        aumentarCapacidade();
        // Garante que haja espaço antes de inserir
        if (this.tamanho < this.elementos.length) {
            // Adiciona o novo elemento ao final da fila
            this.elementos[tamanho] = elemento;
            System.out.println("O elemento " + elemento + " foi inserido na fila.");
            // Atualiza o tamanho da fila
            tamanho++;
        }
    }
    // Enfileirar em posição específica (usado pela fila prioritária)
    public void enfileirarPosicao(int posicao, T elemento) {
        // Erro de posição inválida
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        // Aumenta a capacidade da fila se necessário
        aumentarCapacidade();
        // Desloca elementos para a direita
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        // Insere o elemento na posição
        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    // Aumenta a capacidade da fila
    protected void aumentarCapacidade() {
        // Se o tamanho da pilha for igual ao do array de elementos:
        if (this.tamanho == this.elementos.length){
            // Novo array de elementos com o dobro do tamanho
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            // Copia os elementos
            for (int i = 0; i < this.elementos.length; i++){
                elementosNovos[i] = this.elementos[i];
            }
            // Substitui o array original por um novo com maior capacidade
            this.elementos = elementosNovos;
        }
    }
    // Verifica se a fila está vazia:
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    // Retorna o primeiro elemento da fila sem o remover:
    public T espiar() {
        // Verifica se está vazia:
        if (estaVazia()) {
            System.out.println("A fila está vazia!");
            return null;
        }
        return this.elementos[0];
    }

    public T desenfileirar() {
        // Verifica se está vazia
        if (estaVazia()) {
            System.out.println("A fila está vazia!");
            return null;
        }
        // Guarda o elemento a ser removido
        T removido = this.elementos[0];
        // Desloca os elementos para a esquerda
        for (int i = 0; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        // Remove o elemento
        this.elementos[this.tamanho - 1] = null;
        System.out.println("O elemento foi removido!");
        // Atualiza o tamanho da fila
        this.tamanho--;

        return removido;
    }

    // Retorna o tamanho da fila:
    public int tamanho() {
        return this.tamanho;
    }
    // Imprime a fila:
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }
}
