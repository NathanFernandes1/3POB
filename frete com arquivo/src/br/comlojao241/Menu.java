package br.comlojao241;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    private ArrayList<ItensCarrinho> itens = new ArrayList<>();
    private ArrayList<Frete> fretes = new ArrayList<>();

    public void Processamento() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);

        Produto prod = new Produto("shampoo", "456789","sdfrg456","p/ cabelo",12.34, 0.500);
        produtos.add(prod);
        prod = new Produto("condicionador", "55555","ajj555","p/ cabelo",12.45, 0.500);
        produtos.add(prod);

        carrinho.setId(1);

        ItensCarrinho item = new ItensCarrinho(1,1, "456789",12.34, 2);
        itens.add(item);
        item = new ItensCarrinho(2,1, "55555",12.45, 3);
        itens.add(item);

        // Tente ler os fretes do arquivo
        lerFretesDoArquivo("fretes.txt");

        do {
            System.out.println("Digite a opção:");
            System.out.println("1- Incluir Produto: ");
            System.out.println("2- Alterar Produto: ");
            System.out.println("3- Excluir Produto: ");
            System.out.println("4- Listar Produtos: ");
            System.out.println("5- Buscar Produto: ");
            System.out.println("6- Calcular Frete: ");
            System.out.println("7- Exibir Fretes do Arquivo: ");
            System.out.println("8- Sair ");

            opcao = sc.nextInt();

            System.out.println("Opção é: " + opcao);

            switch(opcao) {
                case 1:
                    // Implementar IncluirProduto();
                    break;
                case 2:
                    // Implementar AlterarProduto();
                    break;
                case 3:
                    // Implementar ExcluirProduto();
                    break;
                case 4:
                    // Implementar ListarProduto();
                    break;
                case 5:
                    // Implementar BuscarProduto();
                    break;
                case 6:
                    CalcularFrete();
                    break;
                case 7:
                    exibirFretesDoArquivo("fretes.txt");
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
            }
        } while (opcao != 8);
    }

    private void lerFretesDoArquivo(String nomeArquivo) {
        System.out.println("Tentando ler o arquivo de fretes: " + nomeArquivo);
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
               // System.out.println("Linha lida: " + linha);
                String[] dados = linha.split(",");
                if (dados.length != 4) {
                    System.err.println("Linha inválida: " + linha);
                    continue;
                }
                try {
                    int id = Integer.parseInt(dados[0].trim());
                    int cepInicial = Integer.parseInt(dados[1].trim());
                    int cepFinal = Integer.parseInt(dados[2].trim());
                    double valorPorKilo = Double.parseDouble(dados[3].trim());
                    
                    //System.out.println("id: " + id+"cepInicial: "+cepInicial);
                    // Criar um objeto Frete e adicionar à lista
                    Frete frete = new Frete(id, cepInicial, cepFinal, valorPorKilo);
                    fretes.add(frete);
                    System.out.println("Frete adicionado: " + frete.getId()+","+ frete.getCepInicial()+","+frete.getCepFinal()+","+frete.getValorPorKilo());
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter dados da linha: " + linha);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de fretes: " + e.getMessage());
        }
    }

    private void exibirFretesDoArquivo(String nomeArquivo) {
        System.out.println("Exibindo dados do arquivo de fretes: " + nomeArquivo);
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de fretes: " + e.getMessage());
        }
    }

    public void CalcularFrete() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o cep da entrega: ");
        int cepEntrega = sc.nextInt();

        double pesoTotal = 0.0;
        for (ItensCarrinho item : itens) {
            Produto produto = encontrarProdutoPorUpc(item.getUpc());
            if (produto != null) {
                pesoTotal += produto.getPeso() * item.getQtde();
            }
        }
        carrinho.setPesoTotal(pesoTotal);

        Frete freteEncontrado = encontrarFretePorCep(cepEntrega);
        if (freteEncontrado != null) {
            double valorFrete = pesoTotal * freteEncontrado.getValorPorKilo();
            System.out.printf("O valor do frete é: R$ %.2f%n", valorFrete);
        } else {
            System.out.println("Frete não disponível para o CEP informado.");
        }
    }

    private Produto encontrarProdutoPorUpc(String upc) {
        for (Produto produto : produtos) {
            if (produto.getUpc().equals(upc)) {
                return produto;
            }
        }
        return null;
    }

    private Frete encontrarFretePorCep(int cep) {
        for (Frete frete : fretes) {
            if (cep >= frete.getCepInicial() && cep <= frete.getCepFinal()) {
                return frete;
            }
        }
        return null;
    }
}
