package br.com.crudProdutos;

public class Produto {
	private int idProduto;
	private String codBarras;
	private String skuCod;
	private String nome;
	private String descricao;
	private String categoria;
	private double preco;
	private double peso;
	private String fabricante;
	
	
	public Produto(int idProduto, String codBarras,String skuCod,String nome,String descricao,String categoria,double preco,double peso,String fabricante){
		this.idProduto = idProduto;
		this.codBarras =codBarras;
		this.skuCod = skuCod;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.preco = preco;
		this.peso = peso;
		this.fabricante = fabricante;	
	}


	public int getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}


	public String getCodBarras() {
		return codBarras;
	}


	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}


	public String getSkuCod() {
		return skuCod;
	}


	public void setSkuCod(String skuCod) {
		this.skuCod = skuCod;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) {
		this.peso = peso;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	
}
