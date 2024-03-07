package br.insper.ecommerce;

import br.insper.ecommerce.cliente.Cliente;
import br.insper.ecommerce.cliente.ClienteService;
import br.insper.ecommerce.compra.CompraService;
import br.insper.ecommerce.compra.Item;
import br.insper.ecommerce.pagamento.*;
import br.insper.ecommerce.produto.Produto;
import br.insper.ecommerce.produto.ProdutoService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        String opcao = "0";
        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        CompraService compraService = new CompraService();


        while(!opcao.equalsIgnoreCase("9")) {

            System.out.println("""
                    1 - Cadastrar Cliente
                    2 - Listar Clientes
                    3 - Excluir Cliente
                    4 - Cadastrar Produto
                    5 - Listar Produto
                    6 - Excluir Produto
                    7 - Cadastrar Compra (Meio de pagamento | Cliente | Produto)
                    8 - Listar Compra
                    9 - Sair
                    """);
            opcao = scanner.nextLine();
            if (opcao.equalsIgnoreCase("1")) {

                System.out.println("Digite o nome do cliente:");
                String nome = scanner.nextLine();
                System.out.println("Digite o CPF do cliente;");
                String cpf = scanner.nextLine();

//                Cadastra cliente
                clienteService.cadastrarClientes(nome, cpf);

            }

            if (opcao.equalsIgnoreCase("2")) {
                clienteService.ListarClientes();
            }

            if (opcao.equalsIgnoreCase("3")) {

                System.out.println("Digite o cpf do cliente para deletar:");
                String cpf = scanner.nextLine();
                clienteService.excluirClientes(cpf);
            }
            if (opcao.equalsIgnoreCase("4")) {
                // Cadastrar Produto
                System.out.println("Digite o nome do produto:");
                String nome = scanner.nextLine();
                System.out.println("Digite o preço do produto;");
                Double preco = scanner.nextDouble();
                produtoService.cadastrarProdutos(nome,preco);
            }
            if (opcao.equalsIgnoreCase("5")) {
                // Listar Produto
                produtoService.ListarProdutos();
            }
            if (opcao.equalsIgnoreCase("6")) {
                // Excluir Produto
                System.out.println("Digite o nome do produto:");
                String nome = scanner.nextLine();
                produtoService.excluirProdutos(nome);
            }
            if (opcao.equalsIgnoreCase("7")) {

                // Cadastrar Compra (Meio de pagamento | Cliente | Produto)
                LocalDateTime dataCompra = LocalDateTime.now();

                System.out.println("Digite o produto:");
                String nome = scanner.nextLine();
                Produto produto = produtoService.buscaProduto(nome);

                Item item = new Item();
                item.setProduto(produto);

                System.out.println("Digite a quantidade:");
                Integer quantidade = Integer.parseInt(scanner.nextLine());
                item.setQuantidade(quantidade);

                System.out.println("Digite o cpf do cliente:");
                String cpf = scanner.nextLine();
                Cliente cliente = clienteService.buscaCliente(cpf);

                System.out.println("Digite o meio de pagamento:");
                System.out.println("1 - Boleto");
                System.out.println("2 - Cartão de crédito");
                System.out.println("4 - Pix");
                String meioPagamento = scanner.nextLine();
                MeioPagamento meioPagamento1 = null;
                if (meioPagamento.equalsIgnoreCase("1")) {
                    Boleto boleto = new Boleto();
                    System.out.println("Digite o código do boleto:");
                    String codigoBoleto = scanner.nextLine();
                    meioPagamento1 = new Boleto(true, LocalDateTime.now(), codigoBoleto);
                }
                if (meioPagamento.equalsIgnoreCase("2")) {
                    CartaoCredito cartaoCredito = new CartaoCredito();
                    System.out.println("Digite o número do cartão:");
                    String numeroCartao = scanner.nextLine();
                    System.out.println("Digite a bandeira do cartão:");
                    String bandeiraCartao = scanner.nextLine();
                    meioPagamento1 = new CartaoCredito(true, LocalDateTime.now(), numeroCartao, bandeiraCartao);
                }
                if (meioPagamento.equalsIgnoreCase("4")) {
                    Pix pix = new Pix();
                    System.out.println("Digite a chave pix:");
                    String chavePix = scanner.nextLine();
                    System.out.println("Digite o qrCode pix:");
                    String qrCodePix = scanner.nextLine();
                    meioPagamento1 = new Pix(true, LocalDateTime.now(), chavePix, qrCodePix);
                }
                compraService.cadastrarCompra(item, cliente, meioPagamento1);

            }
            if (opcao.equalsIgnoreCase("8")) {
                // Listar Compra
                compraService.ListarCompra();
            }
            if (opcao.equalsIgnoreCase("9")) {
                // Excluir Produto
                System.out.println("Obrigado por utilizar! :)");
                break;
            }

        }


    }

}