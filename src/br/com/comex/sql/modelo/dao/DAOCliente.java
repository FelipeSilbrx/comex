package br.com.comex.sql.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.comex.sql.factory.ConnectionFactory;
import br.com.comex.modelo.Categoria;
import br.com.comex.modelo.Cliente;
import br.com.comex.modelo.Pedido;

public class DAOCliente {
	private Connection connection;

	public DAOCliente(Connection connection) throws SQLException {
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
		String sql = "SELECT ID, NOME, CPF, TELEFONE, RUA, NUMERO"
				+ ", COMPLEMENTO, BAIRRO, CIDADE, UF FROM comex.cliente";
		PreparedStatement pstm = connection.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		while (rst.next()) {
			Cliente cliente = this.populaCliente(rst);
			clientes.add(cliente);
		}
		rst.close();
		pstm.close();
		return clientes;
	}
	public void excluirCliente (int id) throws SQLException {
		String sql = "DELETE FROM comex.cliente WHERE id = ?";
		
		PreparedStatement pstm = connection.prepareStatement(sql);
		
		pstm.setInt(1, id);
		pstm.execute();		
		pstm.close();
	}
	
	public void atualizaCliente(Cliente cliente) throws SQLException {
		String sql = "UPDATE comex.cliente SET ID = ?, NOME = ?, CPF = ? , TELEFONE = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, UF = ? ";
		String [] colunaParaRetornar = {"id"};
		try (PreparedStatement stm = connection.prepareStatement(sql, colunaParaRetornar)) {
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
			
			System.out.println("Cliente atualizad com sucesso");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao atualizar cliente: "+ ex);
			
		}
		connection.close();			
	}
	
	private Cliente populaCliente(ResultSet registros) throws SQLException {

		Cliente cliente = new Cliente(registros.getString("NOME"),
				registros.getString("CPF"),
				registros.getString("TELEFONE"),
				registros.getString("RUA"),
				registros.getString("NUMERO"),
				registros.getString("COMPLEMENTO"),
				registros.getString("BAIRRO"),
				registros.getString("CIDADE"),
				registros.getString("UF"));
		
		cliente.setId(registros.getInt("ID"));
		return cliente;
	}
}
