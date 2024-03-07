package br.insper.ecommerce.produto;

import br.insper.ecommerce.cliente.Cliente;

import java.util.ArrayList;

public class ProdutoService {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProdutos(String nome,Double preco){
        if (nome.equals("") || preco.equals("")) {
            System.out.println("Produto inválido.");
        } else {
            Produto produto = new Produto(nome,preco);
            produtos.add(produto);
            System.out.println("Cliente cadastrado com sucesso.");
        }

    }

    public Produto buscaProduto(String nomeProduto){
        Produto produtoBusca = null;
        for (Produto produto : produtos) {
            if (nomeProduto.equals(produto.getNome())) {
                produtoBusca = produto;
            }
        }
        if (produtoBusca != null) {
            System.out.println("Produto encontrado");
            return produtoBusca;
        } else {
            System.out.println("Produto não encontrado");
        }
        return produtoBusca;
    }

    public void ListarProdutos(){
        System.out.println("Lista de produtos:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
        }
    }
    public void excluirProdutos(String nome){
        Produto produtoRemover = null;
        for (Produto produto : produtos) {
            if (nome.equals(produto.getNome())) {
                produtoRemover = produto;
            }
        }
        if (produtoRemover != null) {
            System.out.println("Cliente removido com sucesso");
            produtos.remove(produtoRemover);
        } else {

            System.out.println("Cliente não encontrado");
        }

    }
}
