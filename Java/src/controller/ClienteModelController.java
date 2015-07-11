package controller;

import banco.BancoMentira;
import model.ClienteModel;
import model.VeiculoModel;

public class ClienteModelController implements ModelController {

	public boolean cadastrar(int id, String nome, String sobrenome, String idade, 
			String numeroCNH, String cpf ){
		
		//Validar os campos
		//TODO acrescentar os outros atributos na validação abaixo
		if((id != 0) && (nome == null) && (numeroCNH == null) && (numeroCNH == null)){
			return false;
		}else{
			ClienteModel clienteModel = new ClienteModel(id, nome, sobrenome, idade, numeroCNH, cpf);
			if(!BancoMentira.clienteModelRepositorio.containsKey(id)){
				// Inserir no banco local
				BancoMentira.clienteModelRepositorio.put(clienteModel.getId(), clienteModel);
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean remover(int id){
		if(id == 0){
			return false;
		}else{
			if(BancoMentira.clienteModelRepositorio.containsKey(id)){
				BancoMentira.clienteModelRepositorio.remove(id);
				return true;
			}else{
				return false;
			}
		}
	}
	

	public ClienteModel ler(int id){
		if(id == 0){
			return null;
		}else{
			ClienteModel clienteModel  = BancoMentira.clienteModelRepositorio.get(id);
			return clienteModel;
		}
	}

	public boolean editar(int id, String nome, String sobrenome, String idade,
			String numeroCNH, String cpf) {
		// TODO Auto-generated method stub
		
		if(BancoMentira.clienteModelRepositorio.containsKey(id)){
			BancoMentira.clienteModelRepositorio.get(id).setNome(nome);
			BancoMentira.clienteModelRepositorio.get(id).setSobrenome(sobrenome);
			BancoMentira.clienteModelRepositorio.get(id).setIdade(idade);
			BancoMentira.clienteModelRepositorio.get(id).setNumeroCNH(numeroCNH);
			BancoMentira.clienteModelRepositorio.get(id).setCpf(cpf);
			
			return true;
			
		}else{
			return false;
		}
	}
	
}
