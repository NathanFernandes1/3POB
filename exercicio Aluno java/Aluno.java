package br.com.escola20241;

public class Aluno {
	private String nome;
	private String cpf;
	private String matricula;
	private String email;
	
	
	public Aluno(String nome, String cpf, String matricula, String email) {
		super();
		/*this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.email = email;*/
		
		setNome(nome);
		setCpf(cpf);
		setMatricula(matricula);
		setEmail(email);
	}
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
