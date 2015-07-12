package controller;

import java.sql.ResultSet;

import model.AluguelModel;
import banco.BancoMYSQL;

public class AluguelModelController implements ModelController {

	public boolean remover(int id){
		
		String comando = "DELETE FROM `locadora`.`aluguel` WHERE `id`="+id+";";
		
		try {
			BancoMYSQL.executarSQL(comando);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public AluguelModel ler(int id){
		
		ResultSet retorno = null;
		AluguelModel model = null;
		
		String comando = "SELECT `id`, `idCliente`, `idVeiculo`, `valorAluguel`, `dataInicio`, `dataDevolucao` FROM `locadora`.`aluguel` WHERE `id`=" + id;
		
		try {
			
			retorno = BancoMYSQL.realizarConsulta(comando);
			retorno.first();
			
			int idCliente = retorno.getInt(2);
			int idVeiculo = retorno.getInt(3);
			double valorAluguel = retorno.getDouble(4);
			String dataInicio = retorno.getString(5);
			String dataDevolucao = retorno.getString(6);
			
			model = new AluguelModel(id, idCliente, idVeiculo, valorAluguel, dataInicio, dataDevolucao);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		return model;
		
	}

	public boolean cadastrar(int id, int idCliente, int idVeiculo, double valorAluguel, String dataInicio, String dataDevolucao) {

		String comando = "INSERT INTO `locadora`.`aluguel`(`id`, `idCliente`, `idVeiculo`, `valorAluguel`, `dataInicio`, `dataDevolucao`) VALUES ("
				+ id + "," 
				+ "" + idCliente + "" + ","
				+ "" + idVeiculo + "" + ","
				+ "" + valorAluguel + "" + ","
				+ "'" + dataInicio + "'" + ","
				+ "'" + dataDevolucao + "'" + ""
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


	public boolean editar(int id, int idCliente, int idVeiculo,	double valorAluguel, String dataInicio, String dataDevolucao) {
		
		String comando = "UPDATE `locadora`.`aluguel` SET "
				+ "`idCliente`=" + idCliente + ", "
				+ "`idVeiculo`=" + idVeiculo + ", "
				+ "`valorAluguel`=" + valorAluguel + ", "
				+ "`dataInicio`='" + dataInicio + "', "
				+ "`dataDevolucao`='" + dataDevolucao + "' "
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
	
}
