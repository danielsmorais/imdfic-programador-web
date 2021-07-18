package br.ufrn.imd.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GerenciadorConexao {
	
	 private static Connection conexao;

	    /**
	        * Método estático para obtenção de conexão.
	        * 
	        * @return
	        */
	    public static Connection getConexao() {

	        if (conexao == null) {
	          String username = "root";
	          String password = "lein@d";
	          // Informa a URL do banco (siturb) e o timezone do servidor
	          String url = "jdbc:mysql://localhost/siturb?serverTimezone=UTC";
	          try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                conexao = DriverManager.getConnection(url, username, password);
	                System.out.println("Conexão realizada com sucesso!");
	          } catch (Exception e) {
	                e.printStackTrace();
	          }
	        }
	    return conexao;
	    }

}
