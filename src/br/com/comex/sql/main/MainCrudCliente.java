package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.Cliente;
import br.com.comex.sql.modelo.CrudCliente;

public class MainCrudCliente {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		Cliente cliente1 = new Cliente("Anna Carolina", "111.111.111-11", "(81) 9 8878-5225", "rua 123", "21", "CASA C", "Torrões", "Recife",
				"PE");
		
		CrudCliente crudCliente = new CrudCliente(connection);
		crudCliente.salvarCliente(cliente1);
		crudCliente.listarCliente();
		//crudCliente.excluiCliente(1);
	}
}
