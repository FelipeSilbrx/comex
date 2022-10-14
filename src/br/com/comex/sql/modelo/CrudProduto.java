package br.com.comex.sql.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.comex.sql.factory.ConnectionFactory;

public class CrudProduto {
	private Connection connection;

	public CrudProduto(Connection connection) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvarProduto(Produto produto) throws SQLException {
		String sql = "INSERT INTO COMEX.PRODUTO(id, nome, descricao, preco_unitario, quantidade_estoque, categoria_id, tipo) VALUES (?, ?, ?, ?, ?, ?, ?)";

		String[] colunaParaRetornar = { "id" };

		try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
			stm.setInt(1, produto.getId());
			stm.setString(2, produto.getNome());
			stm.setString(3, produto.getDescricao());
			stm.setBigDecimal(4, produto.getPreco_unitario());
			stm.setInt(5, produto.getQtd_estoque());
			stm.setInt(6, produto.getCategoriaProduto().getId());
			stm.setString(7, "NAO_ISENTO");

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
			Produto produto = new Produto(rst.getString(2), rst.getBigDecimal(4), rst.getInt(5), rst.getInt(6));
			produtos.add(produto);
		}
		
		rst.close();
		pstm.close();
		
		return produtos;
	}
	public void exclui (int id) throws SQLException {
		String sql = "delete from comex.produto where id = ?";
		
		PreparedStatement pstm = connection.prepareStatement(sql);
		
		pstm.setInt(1, id);
		pstm.execute();
		
		pstm.close();
	}
}
