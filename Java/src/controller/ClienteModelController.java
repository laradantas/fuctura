package controller;

import java.sql.ResultSet;

import banco.BancoMYSQL;
import model.ClienteModel;

public class ClienteModelController implements ModelController {

	public boolean cadastrar(int id, String nome, String sobrenome, String idade, String numeroCNH, String cpf ){
		
		String comando = "INSERT INTO `locadora`.`cliente`(`id`, `nome`, `sobrenome`, `idade`, `numeroCNH`, `cpf`) VALUES ("
				+ id + "," 
				+ "'" + nome + "'" + ","
				+ "'" + sobrenome + "'" + ","
				+ "'" + idade + "'" + ","
				+ "'" + numeroCNH + "'" + ","
				+ "'" + cpf + "'" + ""
				+ ")";
		
		System.out.println(comando);
		
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
		
		String comando = "DELETE FROM `locadora`.`cliente` WHERE `id`="+id+";";
		
		try {
			BancoMYSQL.executarSQL(comando);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	

	public ClienteModel ler(int id){
		
		ResultSet retorno = null;
		ClienteModel model = null;
		
		String comando = "SELECT `id`, `nome`, `sobrenome`, `idade`, `numeroCNH`, `cpf` FROM `locadora`.`cliente` WHERE `id`=" + id;
		
		try {
			
			retorno = BancoMYSQL.realizarConsulta(comando);
			retorno.first();
			
			String nome = retorno.getString(2);
			String sobrenome = retorno.getString(3);
			String idade = retorno.getString(4);
			String numeroCNH = retorno.getString(5);
			String cpf = retorno.getString(6);
			
			model = new ClienteModel(id, nome, sobrenome, idade, numeroCNH, cpf);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		
		return model;
		
	}

	public boolean editar(int id, String nome, String sobrenome, String idade, String numeroCNH, String cpf) {
		
		String comando = "UPDATE `locadora`.`cliente` SET "
				+ "`nome`='" + nome + "', "
				+ "`sobrenome`='" + sobrenome + "', "
				+ "`idade`='" + idade + "', "
				+ "`numeroCNH`='" + numeroCNH + "', "
				+ "`cpf`='" + cpf + "' "
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
