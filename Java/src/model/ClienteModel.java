package model;

public class ClienteModel extends Model {

	private String nome;
	private String sobrenome;
	private String idade;
	private String numeroCNH;
	private String cpf;
	
	public ClienteModel(int id, String nome, String sobrenome, String idade,
			String numeroCNH, String cpf) {
		super(id);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.numeroCNH = numeroCNH;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
