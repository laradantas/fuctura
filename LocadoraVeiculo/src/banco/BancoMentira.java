package banco;

import java.util.HashMap;

import model.VeiculoModel;

public class BancoMentira {

	private static int ultimoId;
	
	public static HashMap<Integer, VeiculoModel> veiculoModelRepositorio = new HashMap<Integer, VeiculoModel>();
	
	public static boolean salvarVeiculo(VeiculoModel veiculoModel){
		
		if(!BancoMentira.veiculoModelRepositorio.containsKey(veiculoModel.getId())){	
			veiculoModelRepositorio.put(veiculoModel.getId(), veiculoModel);
			return true;
		}else{
			return false;
		}
		
		
	}
	
}
