package br.com.comex.sql.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.sql.factory.ConnectionFactory;

public class CrudCliente {
	private Connection connection;

	public CrudCliente(Connection connection) throws SQLException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void salvarCliente(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO COMEX.CLIENTE(id, nome, cpf, telefone, rua, numero, complemento, bairro, cidade, uf)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stm = connection.prepareStatement(sql);
		stm.setInt(1, cliente.getId());
		stm.setString(2, cliente.getNome());
		stm.setString(3, cliente.getCpf());
		stm.setString(4, cliente.getTelefone());
		stm.setString(5, cliente.getRua());
		stm.setString(6, cliente.getNumero());
		stm.setString(7, cliente.getComplemento());
		stm.setString(8, cliente.getBairro());
		stm.setString(9, cliente.getCidade());
		stm.setString(10, cliente.getEstado());

		stm.execute();

		connection.close();
	}

	public List<Cliente> listarCliente() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String sql = "SELECT ID, NOME, CPF, TELEFONE, RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF FROM comex.cliente";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		while (rst.next()) {
			Cliente cliente = new Cliente(rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),
					rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10));
			clientes.add(cliente);
		}
		rst.close();
		pstm.close();
		return clientes;
	}
	public void excluiCliente (int id) throws SQLException {
		String sql = "DELETE FROM comex.cliente WHERE id = ?";
		
		PreparedStatement pstm = connection.prepareStatement(sql);
		
		pstm.setInt(1, id);
		pstm.execute();
		
		pstm.close();
	}
}
