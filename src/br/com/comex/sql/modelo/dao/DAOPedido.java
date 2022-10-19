package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Pedido;

public class DAOPedido {
	private Connection connection;

	public DAOPedido(Connection connection) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvarPedido(Pedido pedido) throws SQLException {
		String sql = "INSERT INTO COMEX.PEDIDO( data, cliente_id) VALUES ( ?, ?)";
		

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			
			pstm.setString(1, pedido.getData());
			pstm.setInt(2, pedido.getCliente().getId());
			pstm.executeQuery();
			pstm.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro: " + ex);
		}
		

	}

	public List<Pedido> listarPedido() throws SQLException {
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "SELECT ID, DATA , ID_CLIENTE FROM comex.pedido";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();

		while (rst.next()) {
			Pedido pedido = this.populaPedido(rst);
			pedidos.add(pedido);
		}
		rst.close();
		pstm.close();
		return pedidos;
	}

	public void excluirPedido(int id) throws SQLException {
		String sql = "DELETE FROM comex.pedido WHERE id = ?";

		PreparedStatement pstm = connection.prepareStatement(sql);

		pstm.setInt(1, id);
		pstm.executeQuery();
		pstm.close();
	}
	
	public void atualizaPedido(Pedido pedido) throws SQLException {
		String sql = "UPDATE comex.pedido SET  DATA = ? , ID_CLIENTE = ?, ID = ?S";
		String [] colunaParaRetornar = {"id"};
		try (PreparedStatement pstm = connection.prepareStatement(sql, colunaParaRetornar)) {
			pstm.setString(1, pedido.getData());
			pstm.setInt(2, pedido.getCliente().getId());
			pstm.setInt(3,pedido.getId());
			
			pstm.executeQuery();
			pstm.close();
			System.out.println("Pedido atualizado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar pedido: "+ ex);
			
		}			
	}
	
	private Pedido populaPedido(ResultSet registros) throws SQLException {

		Pedido pedido = new Pedido(registros.getString("DATA"), new Cliente(registros.getInt("CLIENTE_ID")));

		pedido.setId(registros.getInt("ID"));
		return pedido;
	}
}
