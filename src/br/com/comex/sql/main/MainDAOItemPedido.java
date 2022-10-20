package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.TipoDesconto;
import br.com.comex.modelo.Categoria.Status;
import br.com.comex.sql.factory.ConnectionFactory;

public class MainDAOItemPedido {
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		
		Categoria informatica = new Categoria("INFORMÁTICA", Status.ATIVA);
		
		ItemPedido itempedido1 = new ItemPedido(new Produto(28), 3523.00, 1, );
		}
}
