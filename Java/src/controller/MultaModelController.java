package controller;

import banco.BancoMentira;
import model.MultaModel;
import model.VeiculoModel;

public class MultaModelController implements ModelController {

	public boolean remover(int id){
		if(id == 0){
			return false;
		}else{
			if(BancoMentira.multaModelRepositorio.containsKey(id)){
				BancoMentira.multaModelRepositorio.remove(id);
				return true;
			}else{
				return false;
			}
		}
	}
	

	public MultaModel ler(int id){
		if(id == 0){
			return null;
		}else{
			MultaModel multaModel  = BancoMentira.multaModelRepositorio.get(id);
			return multaModel;
		}
	}

	public boolean cadastrar(int id, int idCliente, int idVeiculo, double valor, int pontuacao) {
		// TODO Auto-generated method stub
		
		//Validar os campos
		//TODO acrescentar os outros atributos na validação abaixo
		if(!BancoMentira.clienteModelRepositorio.containsKey(idCliente) || !BancoMentira.veiculoModelRepositorio.containsKey(idVeiculo)){
			return false;
		}else{
			MultaModel multaModel = new MultaModel(id, idCliente, idVeiculo, valor, pontuacao);
			if(!BancoMentira.multaModelRepositorio.containsKey(id)){
				// Inserir no banco local
				BancoMentira.multaModelRepositorio.put(multaModel.getId(), multaModel);
					return true;
				}else{
					return false;
				}
			}
		}

	public boolean editar(int id, int idCliente, int idVeiculo, double valor,
			int pontuacao) {
		// TODO Auto-generated method stub
		
		if(!BancoMentira.clienteModelRepositorio.containsKey(idCliente) || !BancoMentira.veiculoModelRepositorio.containsKey(idVeiculo)){
			return false;
		}
		
		if(BancoMentira.multaModelRepositorio.containsKey(id)){
			BancoMentira.multaModelRepositorio.get(id).setIdCliente(idCliente);
			BancoMentira.multaModelRepositorio.get(id).setIdVeiculo(idVeiculo);
			BancoMentira.multaModelRepositorio.get(id).setValor(valor);
			BancoMentira.multaModelRepositorio.get(id).setPontuacao(pontuacao);
			
			return true;
			
		}else{
			return false;
		}
		
	}
}
