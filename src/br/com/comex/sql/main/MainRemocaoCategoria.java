package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.sql.factory.ConnectionFactory;

public class MainRemocaoCategoria {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		Statement stm = connection.createStatement();
		
		stm.execute("DELETE FROM COMEX.CATEGORIA WHERE STATUS = 'INATIVA'" );
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);		
		
		
	}
}
