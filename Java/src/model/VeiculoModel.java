package model;

public class VeiculoModel extends Model {

	private String modelo;
	private String fabricante;
	private String placa;
	private String chassi;
	private String ano;
	
	public VeiculoModel(int id, String modelo, String fabricante, String placa,
			String chassi, String ano) {
		super();
		this.setId(id);
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.placa = placa;
		this.chassi = chassi;
		this.ano = ano;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
	
}
