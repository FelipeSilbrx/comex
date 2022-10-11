package br.com.comex.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.comex.sql.ConnectionFactory;

public class MainIsercaoCategoria {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO COMEX.CATEGORIA (nome, status) VALUES ('INFORMÁTICA', 'ATIVA')", Statement.RETURN_GENERATED_KEYS);
		stm.execute("INSERT INTO COMEX.CATEGORIA (nome, status) VALUES ('MÓVEIS', 'INATIVA')", Statement.RETURN_GENERATED_KEYS);
		stm.execute("INSERT INTO COMEX.CATEGORIA (nome, status) VALUES ('LIVROS', 'ATIVA')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("o id criado foi: " + id);
		}
		
		
	}
}
