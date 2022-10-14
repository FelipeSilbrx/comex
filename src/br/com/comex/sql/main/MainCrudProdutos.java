package br.com.comex.sql.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.sql.modelo.Categoria;
import br.com.comex.sql.modelo.Categoria.Status;
import br.com.comex.sql.modelo.Produto;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.CrudProduto;

public class MainCrudProdutos {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		Categoria informatica = new Categoria("INFORMÁTICA", Status.ATIVA);
		Categoria livros = new Categoria("LIVROS", Status.ATIVA);
		Categoria moveis = new Categoria("MOVEIS", Status.ATIVA);

		Produto produto1 = new Produto("Notebook Samsung", new BigDecimal(3523), 1, informatica.getId());
		Produto produto2 = new Produto("Sofá 3 lugares", new BigDecimal(2500.00), 1, moveis.getId());
		Produto produto3 = new Produto("Clean Architecture", new BigDecimal(102.9), 2, livros.getId());

		CrudProduto crudProduto = new CrudProduto(connection);
		crudProduto.salvarProduto(produto1);
		crudProduto.salvarProduto(produto2);
		crudProduto.salvarProduto(produto3);
		crudProduto.listarProduto();
	}

}
