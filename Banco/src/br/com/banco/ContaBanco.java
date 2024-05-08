package br.com.banco;


public class ContaBanco {
	private int numConta;
	private String tipo;
	private String dono;
	private double saldo;
	private boolean status;
	
	
	public ContaBanco() {
		super();
		this.saldo = 0;
		this.status = false;
	}
	
	public void abrirConta(String tipo) {
	this.setTipo(tipo);
	this.setStatus(true);
	
	//this.saldo=50;
	
	if (tipo.equals("CC")) {
	    this.saldo = 50;
	    System.out.println("Chegou");
	} else if (tipo.equals("CP")) {
	    this.saldo = 150;
	}

	}
	
	public void fecharConta() {
		if(this.getSaldo()>0) {
			//A Conta não pode ser fechada
		}
		else if(this.getSaldo()<0) {
			//A conta não pode ser fechada pois tem debito
		}
		else {
			this.setStatus(false);
			//Conta fechada
		}
	}
	
	public void depositar(double valor) {
		if(this.isStatus()) {
			this.setSaldo(this.getSaldo() + valor );
			//deposito realizado
		}
		else {
			//Conta fechada
		}
	}
	
	public void sacar(double valor) {
		if(this.isStatus()) {
			if(this.getSaldo()>=valor) {
				this.setSaldo(this.getSaldo()-valor);
				//Saque realizado
			}
			else {
				//Saldo insuficiente
			}
		}
		else {
			//Conta fechada
		}
		
	}
	
	public void pagarMensal() {
		int valor = 0;
		
		if(this.getTipo()=="CC") {
			valor = 12;
		}
		else if(this.getTipo()=="CP") {
			valor = 20;
		}
		
		if(this.isStatus()) {
			this.setSaldo(getSaldo()-valor);
			//Mensalidade paga
		}
		else {
			//Conta fechada
		}
	}

	public int getNumConta() {
		return numConta;
	}


	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDono() {
		return dono;
	}


	public void setDono(String dono) {
		this.dono = dono;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
