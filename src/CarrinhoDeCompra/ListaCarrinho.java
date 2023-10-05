package CarrinhoDeCompra;

import java.util.ArrayList;
import java.util.List;

public class ListaCarrinho {
    private List<Item> carrinhoList;

    public ListaCarrinho() {
        this.carrinhoList = new ArrayList<>();
    }

    public void adicionarItemNoCarrinho(String nome, double preco, int qtd) {
        carrinhoList.add(new Item(nome, preco, qtd));
    }

    public void removerItemCarrinho(String nome) {
        //Aqui criamos um array para que seja armazendo o item a ser removido
        List<Item> itemASerRemovido = new ArrayList<>();
        //Criamos um for para remover itens repetidos ou mesmo unicos da lista

        for (Item y : carrinhoList) {
            if (y.getNome().equalsIgnoreCase(nome)) {
                itemASerRemovido.add(y);
            }
        }
        carrinhoList.removeAll(itemASerRemovido);
    }

    public double calcularValorTotal() {
        //inicializamos a variavel que vai conter o valor  total
        double valorTotal = 0d;
        /*
        fazemos um if com for para que percorra o array list do carrinho
        fazendo somatoria de tudo ate n ter mais nada
       */
        if (!carrinhoList.isEmpty()) {
            for (Item item : carrinhoList) {
                double valorItem = item.getPreco() * item.getQtd();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia");
        }

    }
    public void exibirItens(){
        int itensASeremExibidos = 0;

        if(!carrinhoList.isEmpty()){
            System.out.println(this.carrinhoList);
        }else{
            System.out.println("A lista esta vazia.");
        }
    }

    @Override
    public String toString() {
        return "ListaCarrinho{" +
                "carrinhoList=" + carrinhoList +
                '}';
    }
    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        ListaCarrinho carrinhoDeCompras = new ListaCarrinho();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItemNoCarrinho("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItemNoCarrinho("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItemNoCarrinho("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItemNoCarrinho("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removerItemCarrinho("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }
}
