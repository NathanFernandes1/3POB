package br.com.albergue;

public class Vaga {
	private int idVaga;
	private int idQuarto;
	private String status;
	private String posicao;
	private String tipo;
	
	
	public Vaga (int idVaga, int idQuarto, String status, String posicao, String tipo) {
		super();
		this.idVaga = idVaga;
		this.idQuarto = idQuarto;
		this.status = status;
		this.posicao = posicao;
	}
	
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public int getIdQuarto() {
		return idQuarto;
	}
	
	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
}
