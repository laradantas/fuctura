package controller;

import banco.BancoMentira;
import model.VeiculoModel;

public class VeiculoModelController implements ModelController {

	public boolean cadastrar(String modelo, String fabricante, String placa, 
			String chassi, String ano ){
		
		
		//Validar os campos
		//TODO acrescentar os outros atributos na validação abaixo
		if((modelo == null) && (fabricante == null)){
			return false;
		}else{
			VeiculoModel veiculoModel = new VeiculoModel(modelo, fabricante, placa, chassi, ano);
			BancoMentira.salvarVeiculo(veiculoModel);
			return true;
		}
	}
	
	//TODO
	public void remover(){
		
	}
	
	//TODO
	public void editar(){
		
	}
	
	//TODO
	public void ler(){
		
	}
	
}
