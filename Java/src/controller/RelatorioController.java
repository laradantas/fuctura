package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import banco.BancoMYSQL;

public class RelatorioController {

	public static String DESTINO_RELATORIO = "/home/breno/Desktop";
	
	public static String RELATORIO_TODOS_ALUGUEIS = "/home/breno/workspace/fuctura/Java/relatorios/relatorioAlugueis.jasper";
	public static String RELATORIO_ALUGUEL = "/home/breno/workspace/fuctura/Java/relatorios/relatorioAluguel.jasper";
	
	public static String RELATORIO_TODOS_VEICULOS = "/home/breno/workspace/fuctura/Java/relatorios/relatorioVeiculos.jasper";
	public static String RELATORIO_VEICULO = "/home/breno/workspace/fuctura/Java/relatorios/relatorioVeiculo.jasper";
	
	public RelatorioController() {
		super();
		
		try {
			BancoMYSQL.iniciarConexaoBanco();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String gerarRelatorio(String arquivoDestino, String arquivoTemplate, HashMap<String, Object> parametros) throws Exception {
		InputStream inputStream = new FileInputStream(arquivoTemplate);
		String outputDir = arquivoDestino;

		new File(outputDir);
		
		String outputURL = outputDir + arquivoDestino;
		if (inputStream == null) {
			return null;
		} else {
			Connection databaseConnection = null;
			try {
				databaseConnection = BancoMYSQL.getConnection();
				databaseConnection.getMetaData().getURL();
				JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, databaseConnection);

				JasperExportManager.exportReportToPdfFile(print, arquivoDestino);

			} catch (Exception e1) {
				e1.printStackTrace();
				return null;
			} finally {
				if (databaseConnection != null) {
					try {
						databaseConnection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			File outputfileTeste = new File(outputURL);
			if (outputfileTeste.exists()) {
				return outputURL;
			} else {
				return null;
			}
		}
	}
	
	public void gerarRelatorioTodosAlugueis(String nomeArquivo){
		
		try {

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			
			gerarRelatorio(DESTINO_RELATORIO + nomeArquivo, RELATORIO_TODOS_ALUGUEIS, parametros);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void gerarRelatorioAluguel(String nomeArquivo, String idCliente){
		
		try {

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("idCliente", idCliente);
			
			gerarRelatorio(DESTINO_RELATORIO + nomeArquivo, RELATORIO_ALUGUEL, parametros);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void gerarRelatorioTodosVeiculos(String nomeArquivo){
		
		try {

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			
			gerarRelatorio(DESTINO_RELATORIO + nomeArquivo, RELATORIO_TODOS_VEICULOS, parametros);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void gerarRelatorioVeiculo(String nomeArquivo, int idVeiculo){
		
		try {

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("id", idVeiculo);
			
			gerarRelatorio(DESTINO_RELATORIO + nomeArquivo, RELATORIO_VEICULO, parametros);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
