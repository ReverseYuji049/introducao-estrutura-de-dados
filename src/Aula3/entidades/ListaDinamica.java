package Aula3.entidades;

public class ListaDinamica {
    No inicio; //representa o primeiro elemento

    public ListaDinamica() { //só cria a lista
        this.inicio = new No(null); //precisa adicionar um conteúdo na instância de No
        System.out.println("Lista dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String elemento) {
        if (this.inicio.getConteudo() == null) {
            this.inicio.setConteudo(elemento);

        } else {
            //if (this.inicio.getProx() != null)
            No aux = this.inicio; //faz a referência do início e mantém ele intacto
            No novoNo = new No(elemento); //cria um novo nó que não fazia parte da estrutura

            //o laço de repetição acontece até o Nó apontar para null
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            //chega no Nó sem apontamento/aponta para null
            aux.setProx(novoNo); //conecta o novo nó com a estrutura dinâmica existente
        }
    }
    public void exibir() {
        if (inicioVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;
//            while (aux != null && aux.getConteudo() != null) {
//                //verifica se o conteúdo do nó e se a variável auxiliar são nulos para apenas exibir os nós existentes
//                System.out.println(aux.getConteudo()); //primeiro índice
//                aux = aux.getProx();
//            }
            //System.out.println(aux.getConteudo()); //último elemento que aponta para null
            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }
    private boolean inicioVazio() {
        if (this.inicio.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }
    public void removerElemento(String elemento) {
        if (inicioVazio()) {
            System.out.println("Não existem elementos a serem removidos.");
        } else {
            if (procurarElemento(elemento)) {
                //remover primeiro o elemento isolado
                if (this.inicio.getProx() == null) {
                    this.inicio.setConteudo(null); //reinicia a lista

                    //remover primeiro o elemento conectado com mais elementos
                    //remove qualquer nó conectado
                } else if (this.inicio.getProx() != null) {
                    // else if (this.inicio.getProx() != null && this.inicio.getConteudo().equals(elemento))
                    No aux = this.inicio;
                    while (aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            this.inicio = this.inicio.getProx();
                            return;
                            //se o elemento escolhido for o primeiro, o próximo nó vira o primeiro
                        } else if (aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            aux.setProx(aux.getProx().getProx());
                            return;
                            //o elemento anterior ao elemento selecionado irá saber qual é o sucessor dele
                            //para que após a remoção, ele aponte para esse elemento sucessor, mesmo se for null
                        }
                        aux = aux.getProx();
                    }
                }
            }
        }
    }
    public boolean procurarElemento(String elemento) {
        if (inicioVazio()) {
            System.out.println("Não existem elementos a serem procurados.");
        } else {
            No aux = this.inicio;
            while (aux != null) {
                if(aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado.");
                    return true;
                }
                aux = aux.getProx();
            }
            System.out.println("Elemento não existe na lista.");
        }
        return false;
    }
}
