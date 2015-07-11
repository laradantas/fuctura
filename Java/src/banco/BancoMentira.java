package banco;

import java.util.HashMap;

import model.AluguelModel;
import model.ClienteModel;
import model.MultaModel;
import model.VeiculoModel;

public class BancoMentira {

	private static int ultimoId;
	
	public static HashMap<Integer, VeiculoModel> veiculoModelRepositorio = new HashMap<Integer, VeiculoModel>();
	public static HashMap<Integer, AluguelModel> aluguelModelRepositorio = new HashMap<Integer, AluguelModel>();
	public static HashMap<Integer, ClienteModel> clienteModelRepositorio = new HashMap<Integer, ClienteModel>();
	public static HashMap<Integer, MultaModel> multaModelRepositorio = new HashMap<Integer, MultaModel>();

}
