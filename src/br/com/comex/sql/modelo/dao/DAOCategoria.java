package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Categoria.Status;
import br.com.comex.sql.factory.ConnectionFactory;

public class DAOCategoria {
	private Connection connection;

	public DAOCategoria(Connection connection) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvarCategoria(Categoria categoria) throws SQLException {
		String sql = "INSERT INTO comex.CATEGORIA(nome, status) VALUES( ?, ?)";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setString(1, categoria.getNome());
			pstm.setString(2, categoria.getStatus().name());			
			pstm.executeQuery();
			
			System.out.println("Categoria inserida com sucesso!!!");
			pstm.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro: " + ex);		
		}
	}

	public List<Categoria> listarCategoria() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT ID, NOME, STATUS FROM comex.categoria";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();

		while (rst.next()) {
			Categoria categoria = this.populaCategoria(rst);
			categorias.add(categoria);
		}
		pstm.close();
		System.out.println("\n" +categorias);
		return categorias;
	}

	public void excluirCategoria(int id) throws SQLException {
		String sql = "DELETE FROM COMEX.CATEGORIA WHERE STATUS = ?";

		PreparedStatement pstm = connection.prepareStatement(sql);

		pstm.setInt(1, id);
		pstm.executeQuery();
		pstm.close();
		
	}

	public void atualizaCategoria(Categoria categoria) throws SQLException {
		String sql = "UPDATE comex.categoria SET ID = ?, NOME = ?, STATUS = ? ";
		
		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.setInt(1, categoria.getId());
			pstm.setString(2, categoria.getNome());
			pstm.setString(3, categoria.getStatus().name());
			pstm.executeQuery();
			pstm.close();
			System.out.println("Categoria atualizada com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar categoria: " + ex);

		}
	}

	private Categoria populaCategoria(ResultSet registros) throws SQLException {

		Categoria categoria = new Categoria(registros.getString("NOME"), Status.valueOf(registros.getString("STATUS")));

		categoria.setId(registros.getInt("ID"));
		return categoria;
	}
}
