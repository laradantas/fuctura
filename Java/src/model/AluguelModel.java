package model;

public class AluguelModel extends Model {

	private int idCliente;
	private int idVeiculo;
	private double valorAluguel;
	private String dataInicio;
	private String dataDevolucao;
	
	public AluguelModel(int id, int idCliente, int idVeiculo, double valorAluguel,
			String dataInicio, String dataDevolucao) {
		super(id);
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		this.valorAluguel = valorAluguel;
		this.dataInicio = dataInicio;
		this.dataDevolucao = dataDevolucao;
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
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
}
