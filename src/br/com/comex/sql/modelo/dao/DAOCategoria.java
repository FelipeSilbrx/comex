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
		String sql = "INSERT INTO COMEX.CATEGORIA(id, nome, status) VALUES(?, ?, ?)";
	String [] colunaParaRetornar = {"id"};
	try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
		stm.setString(1, categoria.getNome());
		stm.setString(2, categoria.getStatus().name());
	} catch (Exception ex) {
		ex.printStackTrace();
		System.out.println("ROLLBACK EXECUTADO");
		connection.rollback();
	}
	connection.close();			
	}
	
	public List<Categoria> listarCategoria() throws SQLException{
		List<Categoria> categorias = new ArrayList<>();
		String sql = "SELECT ID, NOME, STATUS FROM comex.categoria";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		
		while (rst.next()) {
			Categoria categoria = this.populaCategoria(rst);
			categorias.add(categoria);
		}
		return categorias;
	}
	
	public void excluirCategoria(int id) throws SQLException {
		String sql = "DELETE FROM COMEX.CATEGORIA WHERE STATUS = ?";

		PreparedStatement pstm = connection.prepareStatement(sql);

		pstm.setInt(1, id);
		pstm.execute();

		pstm.close();
	}
	
	public void atualizaCategoria(Categoria categoria) throws SQLException {
		String sql = "UPDATE comex.categoria SET ID = ?, NOME = ?, STATUS = ? ";
		String [] colunaParaRetornar = {"id"};
		try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
			stm.setString(1, categoria.getNome());
			stm.setString(2, categoria.getStatus().name());
			
			System.out.println("Categoria atualizada com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar categoria: "+ ex);
			
		}
		connection.close();			
	}
	
	private Categoria populaCategoria(ResultSet registros) throws SQLException {

		Categoria categoria = new Categoria(registros.getString("NOME"),
				Status.valueOf(registros.getString("STATUS")));
		
		categoria.setId(registros.getInt("ID"));
		return categoria;
	}
}
