package banco;

import java.util.HashMap;

import model.VeiculoModel;

public class BancoMentira {

	private static int ultimoId;
	
	public static HashMap<Integer, VeiculoModel> veiculoModelRepositorio = new HashMap<Integer, VeiculoModel>();
	
	public static boolean salvarVeiculo(VeiculoModel veiculoModel){
		//Verifica se esse veiculo já foi salvo
		//Caso o id seja igual a zero, seta o id para o próximo id disponível
		if(veiculoModel.getId() == 0){
			veiculoModel.setId(ultimoId++);
		}
			
		veiculoModelRepositorio.put(veiculoModel.getId(), veiculoModel);
		
		return true;
	}
	
}
