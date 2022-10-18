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
import br.com.comex.modelo.Produto;

public class DAOPedido {
	private Connection connection;

	public DAOPedido(Connection connection) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvarPedido(Pedido pedido) throws SQLException {
		String sql = "INSERT INTO COMEX.PEDIDO(id, data, cliente_id) VALUES (?, ?, ?)";
		String[] colunaParaRetornar = { "id" };

		try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
			stm.setInt(1, pedido.getId());
			stm.setString(2, pedido.getData());
			stm.setInt(3, pedido.getCliente().getId());

			stm.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			connection.rollback();
		}
		connection.close();

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
		pstm.execute();

		pstm.close();
	}
	
	public void atualizaPedido(Pedido pedido) throws SQLException {
		String sql = "UPDATE comex.pedido SET ID = ?, DATA = ? , ID_CLIENTE = ?";
		String [] colunaParaRetornar = {"id"};
		try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
			stm.setInt(1, pedido.getId());
			stm.setString(2, pedido.getData());
			stm.setInt(3, pedido.getCliente().getId());

			stm.execute();

			System.out.println("Pedido atualizado com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar pedido: "+ ex);
			
		}
		connection.close();			
	}
	
	private Pedido populaPedido(ResultSet registros) throws SQLException {

		Pedido pedido = new Pedido(registros.getString("DATA"), new Cliente(registros.getInt("CLIENTE_ID")));

		pedido.setId(registros.getInt("ID"));
		return pedido;
	}
}
