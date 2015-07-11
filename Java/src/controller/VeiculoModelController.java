package controller;

import banco.BancoMentira;
import model.VeiculoModel;

public class VeiculoModelController implements ModelController {

	public boolean cadastrar(int id, String modelo, String fabricante, String placa, 
			String chassi, String ano ){
		
		
		//Validar os campos
		//TODO acrescentar os outros atributos na validação abaixo
		if((id != 0) && (modelo == null) && (fabricante == null)){
			return false;
		}else{
			VeiculoModel veiculoModel = new VeiculoModel(id, modelo, fabricante, placa, chassi, ano);
			if(!BancoMentira.veiculoModelRepositorio.containsKey(id)){
				// Inserir no banco local
				BancoMentira.veiculoModelRepositorio.put(veiculoModel.getId(), veiculoModel);
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
			if(BancoMentira.veiculoModelRepositorio.containsKey(id)){
				BancoMentira.veiculoModelRepositorio.remove(id);
				return true;
			}else{
				return false;
			}
		}
	}
	

	public boolean editar(int id, String modelo, String fabricante, String placa, 
			String chassi, String ano ){
		
		if(BancoMentira.veiculoModelRepositorio.containsKey(id)){
			BancoMentira.veiculoModelRepositorio.get(id).setModelo(modelo);
			BancoMentira.veiculoModelRepositorio.get(id).setFabricante(fabricante);
			BancoMentira.veiculoModelRepositorio.get(id).setPlaca(placa);
			BancoMentira.veiculoModelRepositorio.get(id).setChassi(chassi);
			BancoMentira.veiculoModelRepositorio.get(id).setAno(ano);
			
			return true;
			
		}else{
			return false;
		}
		
			
	}
	
	
	public VeiculoModel ler(int id){
		if(id == 0){
			return null;
		}else{
			VeiculoModel veiculoModel  = BancoMentira.veiculoModelRepositorio.get(id);
			return veiculoModel;
		}
	}

	public boolean cadastrar(int id, String idCliente, String idVeiculo,
			String valor, String pontuacao) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
