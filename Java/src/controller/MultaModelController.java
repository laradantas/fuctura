package controller;

import java.sql.ResultSet;

import banco.BancoMYSQL;
import model.MultaModel;

public class MultaModelController implements ModelController {

	public boolean remover(int id){
		
		String comando = "DELETE FROM `locadora`.`multa` WHERE `id`="+id+";";
		
		try {
			BancoMYSQL.executarSQL(comando);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public MultaModel ler(int id){
		
		ResultSet retorno = null;
		MultaModel model = null;
		
		String comando = "SELECT `id`, `idCliente`, `idVeiculo`, `valor`, `pontuacao` FROM `locadora`.`multa` WHERE `id`=" + id;
		
		try {
			
			retorno = BancoMYSQL.realizarConsulta(comando);
			retorno.first();
			
			int idCliente = retorno.getInt(2);
			int idVeiculo = retorno.getInt(3);
			double valor = retorno.getDouble(4);
			int pontuacao = retorno.getInt(5);
			
			model = new MultaModel(id, idCliente, idVeiculo, valor, pontuacao);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		return model;
		
	}

	public boolean cadastrar(int id, int idCliente, int idVeiculo, double valor, int pontuacao) {

		String comando = "INSERT INTO `locadora`.`multa`(`id`, `idCliente`, `idVeiculo`, `valor`, `pontuacao`) VALUES ("
				+ id + "," 
				+ "" + idCliente + "" + ","
				+ "" + idVeiculo + "" + ","
				+ "" + valor + "" + ","
				+ "" + pontuacao + "" + ""
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

	public boolean editar(int id, int idCliente, int idVeiculo, double valor, int pontuacao) {
		
		String comando = "UPDATE `locadora`.`multa` SET "
				+ "`idCliente`=" + idCliente + ", "
				+ "`idVeiculo`=" + idVeiculo + ", "
				+ "`valor`=" + valor + ", "
				+ "`pontuacao`=" + pontuacao + " "
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
