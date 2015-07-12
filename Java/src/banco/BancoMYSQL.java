package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import controller.RelatorioController;

public class BancoMYSQL {

	private static Connection connection;
	
	public static void iniciarConexaoBanco() throws Exception {
		if(connection == null){
			// Carrega o Driver do banco
		    Class.forName("com.mysql.jdbc.Driver");
		    connection = getConnection();
	    }
	}
	
	public static Connection getConnection() throws SQLException{
	    // Pega a conexao do banco
	    return DriverManager.getConnection("jdbc:mysql://localhost/phpmyadmin?" + "user=root&password=");
	}

	public static ResultSet realizarConsulta(String consulta) throws Exception {
		
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;

		iniciarConexaoBanco();
		connect = getConnection();
		
		// Cria um statement que sera utilizado na consulta
		statement = connect.createStatement();
		
		// Realiza a consulta
		resultSet = statement.executeQuery(consulta);
		
		return resultSet;
		
	}
	
	public static boolean executarSQL(String consulta) throws Exception {
		
		Connection connect = null;
		Statement statement = null;
		boolean resultadoOK = false;
		
		iniciarConexaoBanco();
		connect = getConnection();
		
		// Cria um statement que sera utilizado na consulta
		statement = connect.createStatement();
		
		// Realiza a consulta
		resultadoOK = statement.execute(consulta);
		
		statement.execute("COMMIT;");
		
		return resultadoOK;
		
	}
	
	public static void main(String[] args) {
		try {

			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("parametroId", 1);
			
			new RelatorioController().gerarRelatorio("/home/breno/Desktop/Relatorio", "/home/breno/workspace/fuctura/Java/relatorios/relatorioMultas.jasper", parametros);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
