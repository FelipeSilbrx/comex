package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.sql.factory.ConnectionFactory;

public class MainIsercaoCategoria {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		Statement stm = connection.createStatement();
		
		stm.execute("INSERT INTO COMEX.CATEGORIA(nome, status) VALUES ('INFORMÁTICA', 'ATIVA')", Statement.RETURN_GENERATED_KEYS);
		stm.execute("INSERT INTO COMEX.CATEGORIA (nome, status) VALUES ('MÓVEIS', 'INATIVA')", Statement.RETURN_GENERATED_KEYS);
		stm.execute("INSERT INTO COMEX.CATEGORIA (nome, status) VALUES ('LIVROS', 'ATIVA')", Statement.RETURN_GENERATED_KEYS);
		
				
	}
}
