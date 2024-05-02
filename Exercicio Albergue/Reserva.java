package br.com.albergue;

public class Reserva {
	private int idCliente;
	private int idVaga;
	private int idReserva;
	private int dtInicio;
	private int dtFim;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(int dtInicio) {
		this.dtInicio = dtInicio;
	}
	public int getDtFim() {
		return dtFim;
	}
	public void setDtFim(int dtFim) {
		this.dtFim = dtFim;
	}
}
