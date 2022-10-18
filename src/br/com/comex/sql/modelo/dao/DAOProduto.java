package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.ItemPedido;
import br.com.comex.modelo.Pedido;
import br.com.comex.modelo.Produto;
import br.com.comex.modelo.TipoDesconto;

public class DAOProduto {
	private Connection connection;

	public DAOProduto(Connection connection) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO COMEX.PRODUTO(id, nome, descricao, preco_unitario, quantidade_estoque, categoria_id, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

		String[] colunaParaRetornar = { "id" };

		try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
			stm.setInt(1, produto.getId());
			stm.setString(2, produto.getNome());
			stm.setString(3, produto.getDescricao());
			stm.setDouble(4, produto.getPrecoUnitario());
			stm.setInt(5, produto.getQtdEstoque());
			stm.setInt(6, produto.getCategoriaProduto().getId());
			stm.setString(7, String.valueOf(produto.getCategoriaProduto().getStatus()));

			stm.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		connection.close();

	}

	public List<Produto> listarProduto() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT ID, NOME, DESCRICAO, PRECO_UNITARIO, QUANTIDADE_ESTOQUE, CATEGORIA_ID, TIPO FROM comex.produto";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();

		while (rst.next()) {
			Produto produto = this.populaProduto(rst);
			produtos.add(produto);
		}

		rst.close();
		pstm.close();

		return produtos;
	}

	public void excluirProduto(int id) throws SQLException {
		String sql = "delete from comex.produto where id = ?";

		PreparedStatement pstm = connection.prepareStatement(sql);

		pstm.setInt(1, id);
		pstm.execute();

		pstm.close();
	}
	
	public void atualizaProduto(Produto produto) throws SQLException {
		String sql = "UPDATE comex.produto SET ID = ?, NOME = ?, DESCRICAO = ?, PRECO_UNITARIO = ?, QUANTIDADE_ESTOQUE = ?, CATEGORIA_ID = ?, TIPO = ? ";
		String [] colunaParaRetornar = {"id"};
		try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
			stm.setInt(1, produto.getId());
			stm.setString(2, produto.getNome());
			stm.setString(3, produto.getDescricao());
			stm.setDouble(4, produto.getPrecoUnitario());
			stm.setInt(5, produto.getQtdEstoque());
			stm.setInt(6, produto.getCategoriaProduto().getId());
			stm.setString(7, String.valueOf(produto.getCategoriaProduto().getStatus()));

			stm.execute();

			System.out.println("Produto atualizado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar produto: "+ ex);
			
		}
		connection.close();			
	}
	
	private Produto populaProduto(ResultSet registros) throws SQLException {

		Produto produto = new Produto(registros.getString("NOME"), registros.getDouble("PRECO_UNITARIO"),
				registros.getString("DESCRICAO"), registros.getInt("QUANTIDADE_estoque"),
				new Categoria(registros.getInt("CATEGORIA_ID")), registros.getString("TIPO"));

		produto.setId(registros.getInt("id"));
		return produto;
	}
}
