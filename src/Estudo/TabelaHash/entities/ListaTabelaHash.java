package Estudo.TabelaHash.entities;

public class ListaTabelaHash {
    // Lista estática de números
    private Integer[] lista;
    // Tamanho da lista estática
    private int tamanho;

    public ListaTabelaHash(int tamanho) {
        // Cria novo objeto
        this.lista = new Integer[tamanho];
        // Define o tamanho inicial da lista como vazio
        this.tamanho = 0;
        System.out.println("Lista com Tabela Hash criada com tamanho " + tamanho + ".");
    }
    // Função Hash: x mod tamanho
    //  - 24 % 5 = 4
    public int funcaoHash(Integer elemento) {
        return elemento % this.lista.length;
    }
    // Caso a posição desejada estiver ocupada, para evitar colisões, avança para o próximo
    // - posição + 1; posição + 2; posição + 3...
    private int sondagemLinear(int posicao) {
        return (posicao + 1) % this.lista.length;
    }
    // Adicionar Via Hash:
    //  - Calcula o índice inicial
    //  - Verifica se o elemento na posição é a chave procurada
    //  - Se não for a chave e houver colisão, procura pela próxima
    //  - Insere o elemento na posição
    //  - Para ao encontrar ou se não encontrar
    public void adicionarViaHash(Integer elemento) {
        // Calcula o índice inicial
        int indice = funcaoHash(elemento);
        // Enquanto a posição estiver ocupada (colisão)
        while (this.lista[indice] != null) {
            // Avança até chegar no espaço vazio
            indice = sondagemLinear(elemento);
        }
        // Insere o elemento na posição
        this.lista[indice] = elemento;
    }
    // Buscar via Hash:
    //  - Calcula o índice inicial
    //  - Verifica se o elemento na posição é a chave procurada
    //  - Se não for a chave e houver colisão, procura pela próxima
    //  - Para ao encontrar ou se não encontrar
    public void buscarViaHash(Integer elemento) {
        // Calcula o índice inicial
        int indice = funcaoHash(elemento);
        // Enquanto houver colisão
        while (this.lista[indice] != null) {
            // Percorre a lista para achar a posição vazia
            if (this.lista[indice].equals(elemento)) {
                System.out.println("Elemento encontrado na posição: " + indice);
                return;
            }
            // Avança até chegar no espaço vazio
            indice = sondagemLinear(indice);
        }
        // Caso o elemento não exista na lista
        System.out.println("Elemento não encontrado.");
    }
    // Remover Via Hash (extra):
    //  - Calcula o índice inicial
    //  - Verifica se o elemento na posição é a chave procurada
    //  - Remove o elemento
    //  - Se não for a chave e houver colisão, procura pela próxima
    //  - Para ao encontrar ou se não encontrar
    public void removerViaHash(Integer elemento) {
        // Calcula o índice inicial
        int indice = funcaoHash(elemento);
        // Percorre a lista até achar o elemento na lista
        while (this.lista[indice] != null) {
            if (this.lista[indice].equals(elemento)) {
                // Remove o elemento da lista
                this.lista[indice] = null;
                System.out.println("Elemento removido.");
                return;
            }
            //
            indice = sondagemLinear(indice);
        }
        // Caso não encontre
        System.out.println("Elemento não encontrado para remoção.");
    }

    // Exibir
    public void exibir() {
        for (int i = 0; i < lista.length; i++) {
            System.out.println("[" + i + "] = " + lista[i]);
        }
    }
}
