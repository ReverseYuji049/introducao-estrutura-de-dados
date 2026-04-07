package Estudo.ListasEncadeadas.entities;

@SuppressWarnings("unchecked")
public class ListaEstatica<T> {
    // A lista pode ser de qualquer tipo
    protected T[] elementos;
    // Tamanho da lista
    protected int tamanho;
    private final int NAO_ENCONTRADO = -1;
    private final String NAO_EXISTE = "Posição não existe";
    private final String LISTA_VAZIA = "A lista está vazia!";

    public ListaEstatica(int capacidade) {
        // Cria um novo elemento na lista
        this.elementos = (T[]) new Object[capacidade];
        System.out.println("Lista estática criada com sucesso! Existem " + capacidade + " posições disponíveis.");
        // Define o tamanho inicial
        this.tamanho = 0;
    }
    // Aumenta a capacidade da lista:
    protected void aumentarCapacidade() {
        if (this.tamanho >= this.elementos.length) {
            // Nova lista com o dobro do tamanho
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            // Copia os elementos
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            // Substitui a lista original por um novo com maior capacidade
            this.elementos = elementosNovos;
        }
    }
    // Adiciona elemento ao final da lista:
    public void adicionar(T elemento) {
        // Aumenta a capacidade se necessário
        aumentarCapacidade();
        // Adiciona o elemento ao final
        this.elementos[this.tamanho] = elemento;
        // Atualiza o tamanho da lista
        this.tamanho++;
    }
    // Adiciona elemento no início da lista:
    public void adicionarInicio(T elemento) {
        // Aumenta a capacidade se necessário
        aumentarCapacidade();
        // Desloca os elementos para a direita
        for (int i = this.tamanho - 1; i >= 0; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        // Insere o elemento no início
        this.elementos[0] = elemento;
        // Atualiza o tamanho da lista
        this.tamanho++;
    }
    // Adiciona por posição:
    public void adicionarPorPosicao(int posicao, T elemento) {
        // Aumenta a capacidade se necessário
        aumentarCapacidade();
        // Erro de posição inválida
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        // Se a posição for 0, insere no início
        if (posicao == 0) {
            adicionarInicio(elemento);
        }
        // Se a posição for igual ao tamanho (número final), adiciona no fim
        else if (posicao == this.tamanho) {
            adicionar(elemento);
        } else {
            // Desloca os elementos na esquerda
            for (int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i + 1] = this.elementos[i];
            }
            // Insere o elemento na posição
            this.elementos[posicao] = elemento;
            // Atualiza o tamanho da fila
            this.tamanho++;
        }
    }
    // Remove o elemento do final da lista:
    public T remover() {
        // Erro de lista vazia
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        // Guarda o elemento do final da lista
        T removido = this.elementos[this.tamanho - 1];
        // Remove o elemento
        this.elementos[this.tamanho - 1] = null;
        // Atualiza o tamanho da lista
        this.tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Remove o elemento do início da lista:
    public T removerInicio() {
        // Erro de lista vazia
        if (this.tamanho == 0) {
            throw new RuntimeException(LISTA_VAZIA);
        }
        // Guarda o elemento a ser removido do início
        T removido = this.elementos[0];
        // Desloca os elementos para a esquerda
        for (int i = 0; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        // Remove o elemento
        this.elementos[this.tamanho - 1] = null;
        // Atualiza o tamanho da lista
        this.tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Remove o elemento da lista por posição:
    public T removerPorPosicao(int posicao) {
        // Erro de posição inválida
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        // Se a posição for 0, remove o início da lista
        if (posicao == 0) {
            return removerInicio();
        }
        // Se a posição igualar o tamanho (número final), remove o final da lista
        else if (posicao == this.tamanho - 1) {
            return remover();
        }
        // Guarda o elemento a ser removido
        T removido = this.elementos[posicao];
        // Desloca os elementos para a esquerda
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        // Remove o elemento
        this.elementos[this.tamanho - 1] = null;
        // Atualiza o tamanho da lista
        this.tamanho--;
        // Retorna o elemento removido
        return removido;
    }

    // Busca um elemento na lista:
    public int buscaElemento(T elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return NAO_ENCONTRADO;
    }

    // Busca de um elemento na lista por posição:
    public T buscaPosicao(int posicao) {
        // Erro de posição inválida
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException(NAO_EXISTE);
        }
        // Retorna o elemento buscado na lista
        return this.elementos[posicao];
    }

    // Limpa a lista:
    public void limpar() {
        // Percorre a lista e a limpa
        for (int i = 0; i < this.tamanho; i++) {
            this.elementos[i] = null;
        }
        // Atualiza o tamanho da lista
        this.tamanho = 0;
    }

    // Retorna o tamanho da lista
    public int getTamanho() {
        return this.tamanho;
    }

    // Imprime a lista estática
    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]\n\"A lista está vazia!\"";
        }

        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < this.tamanho; i++) {
            builder.append(this.elementos[i]);
            if (i < this.tamanho - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }




}
