package br.com.crudProdutos;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	Scanner sc = new Scanner(System.in);
	int opcao = 0;
	
	do {
		
		System.out.println("1-Cadastrar Produto\n2-AlterarProduto\n3-Excluir Produto\n4-Listar todos os produtos\n5-Listar um produto\n0-Sair");
		opcao = sc.nextInt();
		
		switch (opcao) {
        case 1:
            cadastrarProduto(produtos);
            break;

        case 2:
            alterarProduto(produtos);
            break;

        case 3:
        	excluirProduto(produtos);
        	break;
        	
        case 4:
        	listarTodos(produtos);
        	break;
        	
        case 5:
        	listarUm(produtos);
        	break;
        	
        case 0:
        	break;

        default:
            System.out.println("Opção inválida. Tente novamente.");
            break;
    }
		
	}while (opcao!=0);

}
	
	 private static void cadastrarProduto(ArrayList<Produto> produtos) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Id do produto:");
		int idProduto = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Codigo de barras do produto:");
		String codBarras = sc.nextLine();
		
		System.out.println("Sku do produto:");
		String skuCod = sc.nextLine();
		
		System.out.println("Nome do produto:");
		String nome = sc.nextLine();
		
		System.out.println("Descricao do produto:");
		String descricao = sc.nextLine();
		
		System.out.println("Categoria do produto:");
		String categoria = sc.nextLine();
		
		System.out.println("Preco do produto:");
		double preco = sc.nextDouble();
		
		System.out.println("Peso do produto:");
		double peso = sc.nextDouble();
		
		System.out.println("Fabricante do produto:");
		String fabricante = sc.next();
		
		Produto produt = new Produto(idProduto,codBarras,skuCod,nome,descricao,categoria,preco,peso,fabricante);
	 
		produtos.add(produt);
	 }
	 
	 private static void listarTodos(ArrayList<Produto> produtos) {
		 for(Produto produt : produtos) {
			 System.out.println("Nome: " + produt.getNome());
			 System.out.println("Id: " + produt.getIdProduto());
			 System.out.println("Codigo de Barras: " + produt.getCodBarras());
			 System.out.println("Sku: " + produt.getSkuCod());
			 System.out.println("Descricao: " + produt.getDescricao());
			 System.out.println("Categoria: " + produt.getCategoria());
			 System.out.println("Preco: " + produt.getPreco());
			 System.out.println("Peso: " + produt.getPeso());
			 System.out.println("Fabricante: " + produt.getFabricante());
			 System.out.println();
			 
		 }
	 }
	 
	 private static void listarUm(ArrayList<Produto> produtos) {
		 Scanner sc = new Scanner(System.in);

	        System.out.println("Digite o ID do produto:");
	        int id = sc.nextInt();
	        
	        for(Produto produt : produtos) {
	        	
	        	if(id== produt.getIdProduto()) {
				 System.out.println("Nome: " + produt.getNome());
				 System.out.println("Id: " + produt.getIdProduto());
				 System.out.println("Codigo de Barras: " + produt.getCodBarras());
				 System.out.println("Sku: " + produt.getSkuCod());
				 System.out.println("Descricao: " + produt.getDescricao());
				 System.out.println("Categoria: " + produt.getCategoria());
				 System.out.println("Preco: " + produt.getPreco());
				 System.out.println("Peso: " + produt.getPeso());
				 System.out.println("Fabricante: " + produt.getFabricante());
				 System.out.println();
	        	}
			 }
	 }
	 
	 private static void excluirProduto(ArrayList<Produto> produtos) {
		    Scanner sc = new Scanner(System.in);

		    System.out.println("Digite o ID do produto:");
		    int id = sc.nextInt();
		    
		    Iterator<Produto> iterator = produtos.iterator();
		    while (iterator.hasNext()) {
		        Produto produto = iterator.next();
		        if (produto.getIdProduto() == id) {
		            iterator.remove(); 
		            System.out.println("Produto removido com sucesso.");
		            return; 
		        }
		    }
		    System.out.println("Produto com ID " + id + " não encontrado.");
		}

	 private static void alterarProduto(ArrayList<Produto> produtos) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Digite o ID do produto:");
	        int id = sc.nextInt();
		 for(Produto produt : produtos) {
			 
		        
	        	if(id== produt.getIdProduto()) {
	        		System.out.println("Insira novos dados:");
	        		System.out.println("Id do produto:");
	        		int idProduto = sc.nextInt();
	        		sc.nextLine();
	        		
	        		System.out.println("Codigo de barras do produto:");
	        		String codBarras = sc.nextLine();
	        		produt.setCodBarras(codBarras);
	        		
	        		System.out.println("Sku do produto:");
	        		String skuCod = sc.nextLine();
	        		produt.setSkuCod(skuCod);
	        		
	        		System.out.println("Nome do produto:");
	        		String nome = sc.nextLine();
	        		produt.setNome(nome);
	        		
	        		System.out.println("Descricao do produto:");
	        		String descricao = sc.nextLine();
	        		produt.setDescricao(descricao);
	        		
	        		System.out.println("Categoria do produto:");
	        		String categoria = sc.nextLine();
	        		produt.setCategoria(categoria);
	        		
	        		System.out.println("Preco do produto:");
	        		double preco = sc.nextDouble();
	        		produt.setPreco(preco);
	        		
	        		System.out.println("Peso do produto:");
	        		double peso = sc.nextDouble();
	        		produt.setPeso(peso);
	        		
	        		System.out.println("Fabricante do produto:");
	        		String fabricante = sc.next();
	        		produt.setFabricante(fabricante);
	        		
	        	}
			 }
	 }
}
