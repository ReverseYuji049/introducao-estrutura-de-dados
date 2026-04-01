package Pratica.entities;

/**
 * Interface que define operações avançadas para manipulação
 * de estruturas de lista baseadas em String.
 *
 * As implementações podem ser feitas utilizando vetor fixo
 * (lista simples) ou lista encadeada (lista dinâmica),
 * respeitando o mesmo contrato de métodos.
 */
public interface ListaOperacoes {

    /**
     * Remove TODAS as ocorrências de um determinado elemento da lista.
     *
     * Exemplo:
     * Lista: ["Ana", "Carlos", "Ana", "Pedro"]
     * removerTodas("Ana")
     * Resultado: ["Carlos", "Pedro"]
     *
     * @param elemento Elemento que deverá ter todas as ocorrências removidas.
     * @return Quantidade total de elementos removidos.
     */
    int removerTodas(String elemento);

    /**
     * Retorna a quantidade total de elementos atualmente armazenados na lista.
     *
     * Esse método deve considerar apenas os elementos válidos,
     * ignorando posições vazias no caso da lista baseada em vetor.
     *
     * @return Número de elementos presentes na lista.
     */
    int contar();

    /**
     * Adiciona múltiplos elementos à lista.
     *
     * entidades.No caso da lista baseada em vetor, deve respeitar o limite
     * de capacidade. Caso não haja espaço suficiente, apenas os
     * elementos possíveis deverão ser adicionados.
     *
     * @param elementos Vetor de Strings contendo os elementos a serem adicionados.
     * @return Quantidade de elementos que foram realmente adicionados.
     */
    int adicionarVarios(String[] elementos);

    /**
     * Retorna o elemento armazenado em uma determinada posição da lista, no caso de uma lista dinâmica, simule um índice.
     *
     * Caso o índice seja inválido (menor que zero ou maior/igual ao tamanho),
     * a implementação pode lançar uma exceção ou retornar null,
     * conforme padrão definido no projeto.
     *
     * @param indice Posição desejada.
     * @return Elemento localizado na posição informada.
     */
    String obter(int indice);

    /**
     * Insere um elemento em uma posição específica da lista.
     *
     * entidades.No caso de lista baseada em vetor, os elementos à direita devem
     * ser deslocados. Na lista dinâmica, deve-se ajustar corretamente
     * os encadeamentos entre os nós.
     *
     * @param indice Posição onde o elemento será inserido.
     * @param elemento Elemento a ser inserido.
     * @return true se a inserção foi realizada com sucesso, false caso contrário.
     */
    boolean inserir(int indice, String elemento);

    /**
     * Remove o elemento localizado em uma posição específica da lista.
     *
     * entidades.No vetor, os elementos à direita devem ser deslocados para
     * preencher o espaço. Na lista encadeada, deve-se ajustar os
     * ponteiros entre os nós.
     *
     * @param indice Posição do elemento a ser removido.
     * @return Elemento removido ou null caso o índice seja inválido.
     */
    String removerPorIndice(int indice);

    /**
     * Remove todos os elementos da lista, deixando-a vazia.
     *
     * entidades.No caso da lista baseada em vetor, apenas o tamanho lógico
     * deve ser resetado. Na lista dinâmica, os nós devem ser
     * desconectados para permitir a coleta de lixo.
     */
    void limpar();


    /**
     * Retorna o índice da última ocorrência de um elemento na lista.
     *
     * @param elemento Elemento a ser buscado.
     * @return Índice da última ocorrência ou -1 caso não exista.
     */
    int ultimoIndiceDe(String elemento);

    /**
     * Conta quantas vezes um determinado elemento aparece na lista.
     *
     * @param elemento Elemento a ser contado.
     * @return Número de ocorrências do elemento.
     */
    int contarOcorrencias(String elemento);

    /**
     * Substitui todas as ocorrências de um elemento antigo por um novo elemento.
     *
     * Exemplo:
     * Lista: ["Ana", "Carlos", "Ana"]
     * substituir("Ana", "Maria")
     * Resultado: ["Maria", "Carlos", "Maria"]
     *
     * @param antigo Elemento que será substituído.
     * @param novo Novo valor que substituirá o antigo.
     * @return Quantidade total de substituições realizadas.
     */
    int substituir(String antigo, String novo);
}