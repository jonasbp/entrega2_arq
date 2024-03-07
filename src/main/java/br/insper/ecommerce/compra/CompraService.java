package br.insper.ecommerce.compra;

import br.insper.ecommerce.cliente.Cliente;
import br.insper.ecommerce.pagamento.MeioPagamento;
import br.insper.ecommerce.produto.Produto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CompraService {
    private ArrayList<Compra> compras = new ArrayList<>();

    public void cadastrarCompra(Item item, Cliente cliente, MeioPagamento meioPagamento) {
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setMeioPagamento(meioPagamento);
        compra.adicionarItem(item);
        compra.calculaPrecoTotal();
        compras.add(compra);
    }

    public void ListarCompra(){
        System.out.println("Lista de compras:");
        for (Compra compra : compras) {
            System.out.println("Data da compra: " + compra.getDataCompra());
            System.out.println("Preço total: " + compra.getPrecoTotal());
            System.out.println("Cliente: " + compra.getCliente().getNome());
            System.out.println("Meio de pagamento: " + compra.getMeioPagamento());
        }

    }
}
