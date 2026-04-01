package Aula4.entities;

public class FilaSimplesPrioritaria {
    Elemento[] fila;
    int tamanho = 0;

    public FilaSimplesPrioritaria(int tamanho) {
        this.tamanho = tamanho;
        this.fila = new Elemento[tamanho];
        System.out.println("A Fila criada com sucesso! Ela possui " + tamanho + " espaços disponíveis!");
    }

    public void enfileirar(int valor, int prioridade) {
        Elemento novoElemento = new Elemento(valor, prioridade); // cria novo objeto Elemento
        // Cada posição da fila é um objeto Elemento
        //this.fila[0] = novoElemento;
        //inserir nova priodade: novoElemento.setPrioridade();
        if(!estaCheia()) {

            for (int i = 0; i < this.tamanho; i++) {
                // Verifica qual é o maior nível de prioridade entre os elementos
                // Encontra o ponto que haverá a troca e precisa verificar se há continuidade à direita e espaço vago
                if (this.fila[i] == null) {

                } else {
                    if (fila[i].getPrioridade() < novoElemento.getPrioridade()) {
                        // Método que desloca todos os elementos a partir de i para a direita
                        if (this.fila[i + 1] == null) {
                            // Guarda o elemento na auxiliar
                            Elemento aux = this.fila[i];
                            // Troca o elemento
                            this.fila[i] = novoElemento;
                            // Move o elemento para a direita
                            this.fila[i + 1] = aux;
                        } else {
                        deslocarDireita(i, novoElemento);
                    }
                }
            }


            }
        }
    }

    private void deslocarDireita(int indice, Elemento novoElemento){

        for (int i = 0; i < this.fila.length; i++) {
            // Varredura na estrutura e encontra a primeira posição nula
            if (this.fila[i] == null) {
                // Vai da posição que encontrou o nulo e olha para trás
                for (int j = i; j > indice; j--) {
                    // Coloca o elemento anterior na posição atual
                    this.fila[j] = this.fila[j-1];
                }
                this.fila[indice] = novoElemento;
            }
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.tamanho; i++) {
            if (fila[i] == null) {
                return false;
            }
        }
        System.out.println("Lista está cheia.");
        return true;
    }
    public void exibir() {
        if (!estaVazia()) {
            for (int i = 0; i < this.tamanho; i++) {
                System.out.println(fila[i]);
            }
        }
    }
    private boolean estaVazia() {
        if (this.fila[0] != null) {
            System.out.println("A Fila está vazia.");
            return true;
        }
        return false;
    }
    public void desenfileirar() {
        if (!estaVazia()) {
            //if (fila[tamanho + 1] == null) {
            for (int i = 0; i < this.tamanho - 1; i++) {
                System.out.println("O elemento " + this.fila[0] + " foi removido!");
                this.fila[i] = this.fila[i + 1];
            }
            this.fila[this.tamanho - 1] = null;
            //}
        }
    }
}
