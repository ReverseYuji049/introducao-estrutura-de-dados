package Pratica.entities;

public class ListaDinamica implements ListaOperacoes {
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista dinâmica criada com sucesso!");
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
        }
    }
    public void exibir() {
        if (inicioVazio()) {
            System.out.println("Não existem elementos na lista dinâmica.");
        } else {
            No aux = this.inicio;

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

                if (this.inicio.getProx() == null) {
                    this.inicio.setConteudo(null);

                } else if (this.inicio.getProx() != null) {

                    No aux = this.inicio;
                    while (aux != null) {
                        if (this.inicio.getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            this.inicio = this.inicio.getProx();
                            return;

                        } else if (aux.getProx().getConteudo().equals(elemento)) {
                            System.out.println("Elemento " + elemento + " removido! ");
                            aux.setProx(aux.getProx().getProx());
                            return;

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

    //Júlio
    @Override
    public int removerTodas(String elemento) {
        return 0;
    }

    //Yuji
    @Override
    public int contar() {
        int quantidade = 0;
        if (inicioVazio()) {
            System.out.println("A lista possui 0 elementos.");
        } else {
            No aux = this.inicio;
            while(aux != null) {
                quantidade++;
                aux = aux.getProx();
            }
            System.out.println("A lista possui " + quantidade + " elementos.");
        }
        return quantidade;
    }

    //Guilherme
    @Override
    public int adicionarVarios(String[] elementos) {
        return 0;
    }

    //Yuji
    @Override
    public String obter(int indice) {
        if (indice < 0) {
            System.out.println("Índice inválido.");
            return null;
        } else {
            No aux = this.inicio;
            for (int i = 0; i < indice; i++) {
                aux = aux.getProx();
            }
            return "O elemento '" + aux.getConteudo() + "' está no índice " + indice + ".";
        }
    }

    //Eduardo
    @Override
    public boolean inserir(int indice, String elemento) {
        return false;
    }

    //Yuji
    @Override
    public String removerPorIndice(int indice) {
        if (inicioVazio()) {
            return "Não há elementos a serem removidos";
        } else {
            if (indice < 0) {
                System.out.println("Índice inválido.");
                return null;
            } else {
                String removido = "";
                if (indice == 0) {
                    removido = this.inicio.getConteudo();
                    this.inicio = this.inicio.getProx();
                    return removido;
                } else {
                    No aux = this.inicio;
                    for (int i = 0; i < indice - 1; i++) {
                        aux = aux.getProx();
                        removido = aux.getProx().getConteudo();
                        aux.setProx(aux.getProx().getProx());
                    }
                    return removido;
                }
            }
        }
    }

    //Eduardo
    @Override
    public void limpar() {

    }

    //Guilherme
    @Override
    public int ultimoIndiceDe(String elemento) {
        return 0;
    }

    //Júlio
    @Override
    public int contarOcorrencias(String elemento) {
        return 0;
    }

    //Eduardo
    @Override
    public int substituir(String antigo, String novo) {
        return 0;
    }
}
