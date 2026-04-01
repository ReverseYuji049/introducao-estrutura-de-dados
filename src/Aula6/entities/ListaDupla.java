package Aula6.entities;

public class ListaDupla {
    No inicio;
    public ListaDupla() {
        this.inicio = new No(null);
        System.out.println("Lista dupla criada com sucesso!");
    }

    public void adicionarElemento(String elemento) {
        if (this.inicio.getConteudo() == null) {
            this.inicio.setConteudo(elemento);
        } else {
            No aux = this.inicio;
            No novoNo = new No(elemento);

            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
            novoNo.setAnterior(aux);
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

                    No aux = this.inicio;
                    while (aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            this.inicio = inicio.getProx();
                            this.inicio.setAnterior(null);
                            return;
                        } else if (aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            aux.setProx(aux.getProx().getProx());
                            aux.getProx().setAnterior(aux);
                            return;
                        }
                        aux = aux.getProx();
                    }
                }
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
