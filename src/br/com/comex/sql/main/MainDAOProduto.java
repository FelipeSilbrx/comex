package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;
import br.com.comex.modelo.Produto;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOProduto;

public class MainDAOProduto {
	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();

		Categoria informatica = new Categoria("INFORMÁTICA", Status.ATIVA);
		Categoria livros = new Categoria("LIVROS", Status.ATIVA);
		Categoria moveis = new Categoria("MOVEIS", Status.ATIVA);

		Produto produto1 = new Produto("Notebook Samsung", 3523, 1, informatica);
		Produto produto2 = new Produto("Sofá 3 lugares", 2500.00, 1, moveis);
		Produto produto3 = new Produto("Clean Architecture", 102.9, 2, livros);

		DAOProduto daoProduto = new DAOProduto(connection);
		daoProduto.salvarProduto(produto1);
		daoProduto.salvarProduto(produto2);
		daoProduto.salvarProduto(produto3);
		//daoProduto.listarProduto();
	}

}
