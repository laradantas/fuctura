package controller;

import java.sql.ResultSet;

import model.VeiculoModel;
import banco.BancoMYSQL;

public class VeiculoModelController implements ModelController {

	public boolean cadastrar(int id, String modelo, String fabricante, String placa, String chassi, String ano ){
		
		String comando = "INSERT INTO `locadora`.`veiculo`(`id`, `modelo`, `fabricante`, `placa`, `chassi`, `ano`) VALUES ("
				+ id + "," 
				+ "'" + modelo + "'" + ","
				+ "'" + fabricante + "'" + ","
				+ "'" + placa + "'" + ","
				+ "'" + chassi + "'" + ","
				+ "'" + ano + "'" + ""
				+ ")";
		
		boolean resultado = false;
		
		try {
			BancoMYSQL.executarSQL(comando);
			resultado = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return resultado;

	}
	
	public boolean remover(int id){
		
		String comando = "DELETE FROM `locadora`.`veiculo` WHERE `id`="+id+";";
		
		try {
			BancoMYSQL.executarSQL(comando);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	

	public boolean editar(int id, String modelo, String fabricante, String placa, String chassi, String ano){
		
			String comando = "UPDATE `locadora`.`veiculo` SET "
					+ "`modelo`='" + modelo + "', "
					+ "`fabricante`='" + fabricante + "', "
					+ "`placa`='" + placa + "', "
					+ "`chassi`='" + chassi + "', "
					+ "`ano`='" + ano + "' "
					+ " WHERE `id`=" + id + ";";
			
			boolean resultado = false;
			
			try {
				BancoMYSQL.executarSQL(comando);
				resultado = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return resultado;
			
	}
	
	
	public VeiculoModel ler(int id){
		
		ResultSet retorno = null;
		VeiculoModel model = null;
		
		String comando = "SELECT `id`, `modelo`, `fabricante`, `placa`, `chassi`, `ano` FROM `locadora`.`veiculo` WHERE `id`=" + id;
		
		try {
			
			retorno = BancoMYSQL.realizarConsulta(comando);
			retorno.first();
			
			String modelo = retorno.getString(2);
			String fabricante = retorno.getString(3);
			String placa = retorno.getString(4);
			String chassi = retorno.getString(5);
			String ano = retorno.getString(6);
			
			model = new VeiculoModel(id, modelo, fabricante, placa, chassi, ano);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		return model;
		
	}

	public boolean cadastrar(int id, String idCliente, String idVeiculo,
			String valor, String pontuacao) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
