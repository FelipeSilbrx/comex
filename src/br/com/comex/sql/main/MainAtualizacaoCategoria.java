package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.sql.factory.ConnectionFactory;

public class MainAtualizacaoCategoria {
 public static void main(String[] args) throws SQLException {
	 ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		Statement stm = connection.createStatement();
		
		stm.execute("UPDATE COMEX.CATEGORIA SET nome = 'LIVRO TÉCNICOS' WHERE id = 94");
				
}
}
