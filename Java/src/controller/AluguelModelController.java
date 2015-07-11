package controller;

import model.AluguelModel;
import model.VeiculoModel;
import banco.BancoMentira;

public class AluguelModelController implements ModelController {

	public boolean remover(int id){
		if(id == 0){
			return false;
		}else{
			if(BancoMentira.aluguelModelRepositorio.containsKey(id)){
				BancoMentira.aluguelModelRepositorio.remove(id);
				return true;
			}else{
				return false;
			}
		}
	}
	
	public AluguelModel ler(int id){
		if(id == 0){
			return null;
		}else{
			AluguelModel aluguelModel  = BancoMentira.aluguelModelRepositorio.get(id);
			return aluguelModel;
		}
	}

	public boolean cadastrar(int id, int idCliente, int idVeiculo,
			double valorAluguel, String dataInicio, String dataDevolucao) {
		// TODO Auto-generated method stub
		
		//Validar os campos
				//TODO acrescentar os outros atributos na validação abaixo
				if(!BancoMentira.clienteModelRepositorio.containsKey(idCliente) || !BancoMentira.veiculoModelRepositorio.containsKey(idVeiculo)){
					return false;
				}else{
					AluguelModel aluguelModel = new AluguelModel(id, idCliente, idVeiculo, valorAluguel, dataInicio, dataDevolucao);
					if(!BancoMentira.aluguelModelRepositorio.containsKey(id)){
						// Inserir no banco local
						BancoMentira.aluguelModelRepositorio.put(aluguelModel.getId(), aluguelModel);
						return true;
					}else{
						return false;
					}
				}
		
	}


	public boolean editar(int id, int idCliente, int idVeiculo,
			double valorAluguel, String dataInicio, String dataDevolucao) {
		// TODO Auto-generated method stub
		
		if(!BancoMentira.clienteModelRepositorio.containsKey(idCliente) || !BancoMentira.veiculoModelRepositorio.containsKey(idVeiculo)){
			return false;
		}
		
		if(BancoMentira.aluguelModelRepositorio.containsKey(id)){
			BancoMentira.aluguelModelRepositorio.get(id).setIdCliente(idCliente);;
			BancoMentira.aluguelModelRepositorio.get(id).setIdVeiculo(idVeiculo);
			BancoMentira.aluguelModelRepositorio.get(id).setValorAluguel(valorAluguel);
			BancoMentira.aluguelModelRepositorio.get(id).setDataInicio(dataInicio);
			BancoMentira.aluguelModelRepositorio.get(id).setDataDevolucao(dataDevolucao);
			
			return true;
			
		}else{
			return false;
		}
		
	}
	
}
