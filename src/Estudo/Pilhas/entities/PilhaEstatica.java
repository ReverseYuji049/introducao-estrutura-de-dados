package Estudo.Pilhas.entities;

// Pilha do tipo genérico
public class PilhaEstatica<T> {

    // A pilha pode ser de qualquer tipo
    protected T[] elementos;
    // Tamanho da pilha
    protected int tamanho;

    // Cria a capacidade inicial:
    @SuppressWarnings("unchecked")
    public PilhaEstatica(int capacidade) {
        // Cria elemento na pilha
        this.elementos = (T[]) new Object[capacidade];
        // Pilha inicia vazia
        this.tamanho = 0;
        System.out.println("Pilha estática criada com sucesso! Capacidade: " + capacidade);
    }

    // Define a capacidade da pilha:
    public PilhaEstatica() {
        this(10);
    }

    // Verifica se a pilha está vazia:
    public boolean estaVazia(){
        return this.tamanho == 0;
    }
    // Empilhar (push):
    //  - Last in, first out
    //  - Adiciona ao final (topo) da pilha
    public void empilhar(T elemento) {
        // Aumenta a capacidade da pilha se necessário
        this.aumentaCapacidade();
        // Garante que há espaço antes de inserir:
        if (this.tamanho < this.elementos.length){
            // Adiciona um elemento no topo
            this.elementos[this.tamanho] = elemento;
            // Incrementa o tamanho da pilha
            this.tamanho++;
        }
    }
    // Empilhar por posição (comportamento de lista):
    //  - Move elementos para abrir espaço
//    protected boolean empilharPosicao(int posicao, T elemento){
//        // Erro de posição inválida
//        if (posicao < 0 || posicao > tamanho){
//            throw new IllegalArgumentException("Posição inválida");
//        }
//        // Aumenta a capacidade se necessário
//        this.aumentaCapacidade();
//
//        // Desloca os elementos para a direita
//        for (int i = this.tamanho - 1; i >= posicao; i--){
//            // Abre espaço na posição
//            this.elementos[i+1] = this.elementos[i];
//        }
//        // Adiciona o elemento na posição
//        this.elementos[posicao] = elemento;
//        //Incrementa o tamanho da pilha
//        this.tamanho++;
//
//        return true;
//    }

    // Retorna o último elemento:
    public T topo() {
        // Se a pilha estiver vazia:
        if (this.estaVazia()){
            return null;
        }
        // Retorna o elemento do topo sem removê-lo
        return this.elementos[tamanho-1];
    }
    // Desempilhar (pop):
    public T desempilhar() {
        // Verifica se a pilha está vazia
        if (estaVazia()) {
            return null;
        }
        // Guarda o topo
        T elemento = this.elementos[tamanho - 1];
        // Remove a referência (ajuda o Garbage Collector)
        this.elementos[tamanho - 1] = null;
        // Decrementa o tamanho da pilha
        tamanho--;
        // Retorna o elemento removido
        return elemento;
    }

//    // Remover elemento por posição:
//    public void remover(int posicao){
//        // Erro de posição inválida
//        if (!(posicao >= 0 && posicao < tamanho)){
//            throw new IllegalArgumentException("Posição inválida");
//        }
//        // Desloca os elementos para a esquerda
//        for (int i = posicao; i < tamanho - 1; i++){
//            // Move os elementos
//            elementos[i] = elementos[i+1];
//        }
//        // Decrementa o tamanho da pilha
//        tamanho--;
//    }

    // Aumenta a capacidade da pilha quando necessário
    @SuppressWarnings("unchecked")
    private void aumentaCapacidade(){
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
    // Retorna o tamanho da lista
    public int tamanho(){
        return this.tamanho;
    }

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
