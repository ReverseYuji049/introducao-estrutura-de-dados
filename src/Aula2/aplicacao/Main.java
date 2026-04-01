import Aula2.entidades.ListaSimples;

void main() {
    ListaSimples listaSimples = new ListaSimples(5);
    listaSimples.estaCheio();
    listaSimples.adicionarElemento("Arroz");
    listaSimples.adicionarElemento("Feijão");
    listaSimples.adicionarElemento("Sabão em Pó");
    listaSimples.adicionarElemento("Papel Higiênico");
    listaSimples.adicionarElemento("Óleo");
    listaSimples.exibirElementos();
    listaSimples.removerElemento("Batata");
    listaSimples.buscarElemento("Óleo");
    listaSimples.removerElemento("Óleo");
    listaSimples.buscarElemento("Óleo");
    listaSimples.buscarElemento("Arroz");
    listaSimples.exibirElementos();
}
