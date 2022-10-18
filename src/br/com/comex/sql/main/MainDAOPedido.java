package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Pedido;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOPedido;

public class MainDAOPedido {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cliente1 = new Cliente("Ana Carolina", "111.111.111-11", "81 9 88785225", "rua 123", "21", "CASA C", "Torrões", "Recife",
				"Pe");
		Cliente cliente2 = new Cliente("Elizabeth", "222.222.222-22", "81 9 87785825", "rua abc", "S/N", "CASA D", "Torre", "Recife",
				"Pe");
		Pedido pedido1 = new Pedido(spf.format(22-02-2022) ,cliente1);
		Pedido pedido2 = new Pedido(spf.format(19-10-2019) ,cliente2);
		
		DAOPedido crudPedido = new DAOPedido(connection);
		crudPedido.salvarPedido(pedido1);
		crudPedido.salvarPedido(pedido2);
		crudPedido.listarPedido();
		
	}
}
