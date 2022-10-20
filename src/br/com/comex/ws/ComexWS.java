package br.com.comex.ws;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.comex.modelo.Categoria;
import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.sql.modelo.dao.DAOCategoria;
import br.com.comex.sql.modelo.dao.DAOCliente;
import br.com.comex.sql.modelo.dao.DAOProduto;

@WebService
public class ComexWS {
	Connection connection = new ConnectionFactory().criarConexao();
	
		DAOCategoria daoCategoria = new DAOCategoria(connection);
		DAOCliente daoCliete = new DAOCliente(connection);
		DAOProduto daoProduto = new DAOProduto(connection);

		@WebMethod(operationName = "listarCategorias")
		@WebResult(name = "categoria")
		public List<Categoria> getCategorias() throws SQLException {

			List<Categoria> categorias = daoCategoria.listarCategoria();

			return categorias;

		}
}
