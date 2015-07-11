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


/**
 * @author bci Classe responsável por gerar os contratos a partir do iReports.
 */
public class RelatorioController {

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
}
