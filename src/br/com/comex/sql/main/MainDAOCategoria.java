package br.com.comex.sql.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOCategoria;

public class MainDAOCategoria {
	public static void main(String[] args) throws SQLException {

		Connection connection = new ConnectionFactory().getConnection();
		
		Categoria categoria1 = new Categoria("Informatica",Status.ATIVA);
		Categoria categoria2 = new Categoria("Moveis",Status.INATIVA);
		Categoria categoria3 = new Categoria("Livros",Status.ATIVA);
		DAOCategoria daoCategoria = new DAOCategoria(connection);
		daoCategoria.salvarCategoria(categoria1);
		daoCategoria.salvarCategoria(categoria2);
		daoCategoria.salvarCategoria(categoria3);
		daoCategoria.listarCategoria();
		
		//daoCategoria.listarCategoria();
	}
}

