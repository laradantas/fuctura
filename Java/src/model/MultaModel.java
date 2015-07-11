package model;

public class MultaModel extends Model {

	private int idCliente;
	private int idVeiculo;
	private double valor;
	private int pontuacao;
	
	public MultaModel(int id, int idCliente, int idVeiculo, double valor, int pontuacao) {
		super(id);
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		this.valor = valor;
		this.pontuacao = pontuacao;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
