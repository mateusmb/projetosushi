package br.edu.ifc.blumenau.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifc.blumenau.DTO.ClienteDTO;
import br.edu.ifc.blumenau.util.MySQLConnection;

public class ClienteDAO {

	public void inserir(ClienteDTO cliente) throws SQLException {
		
		String sql = "insert into cliente (nome, cpf, endereco, numero, complemento, bairro, cidade, estado, cep, telefone, usuario, senha, tipo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conexao = MySQLConnection.gerarConexao();
		PreparedStatement statement = MySQLConnection.gerarPreparedStatement(conexao, sql);
		
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf());
		statement.setString(3, cliente.getEndereco());
		statement.setString(4, cliente.getNumero());
		statement.setString(5, cliente.getComplemento());
		statement.setString(6, cliente.getBairro());
                statement.setString(7, cliente.getCidade());
		statement.setString(8, cliente.getEstado());
		statement.setString(9, cliente.getCep());
		statement.setString(10, cliente.getTelefone());
		statement.setString(11, cliente.getUsuario());
		statement.setString(12, cliente.getSenha());
		statement.setBoolean(13, cliente.isTipo());
		
		statement.executeUpdate();
		
		MySQLConnection.fecharStatement(statement);
		MySQLConnection.fecharConexao(conexao);
		
	}
	
	public void alterar(ClienteDTO cliente) throws SQLException {
		
		String sql = "update cliente set nome =  ?, cpf =  ?, endereco =  ?, numero =  ?, complemento = ?, bairro =  ?, estado = ?, cep = ?, telefone = ?, usuario = ?, senha = ?, tipo =  ? where id = ?";
		
		Connection conexao = MySQLConnection.gerarConexao();
		PreparedStatement statement = MySQLConnection.gerarPreparedStatement(conexao, sql);
		
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf());
		statement.setString(3, cliente.getEndereco());
		statement.setString(4, cliente.getNumero());
		statement.setString(5, cliente.getComplemento());
		statement.setString(6, cliente.getBairro());
		statement.setString(7, cliente.getEstado());
		statement.setString(8, cliente.getCep());
		statement.setString(9, cliente.getTelefone());
		statement.setString(10, cliente.getUsuario());
		statement.setString(11, cliente.getSenha());
		statement.setBoolean(12, cliente.isTipo());
		statement.setInt(13, cliente.getId());
		
		statement.executeUpdate(sql);
		
		MySQLConnection.fecharStatement(statement);
		MySQLConnection.fecharConexao(conexao);
		
	}
	
	public List<ClienteDTO> listar() throws SQLException {
		
		String sql = "select * from cliente";
		
		Connection conexao = MySQLConnection.gerarConexao();
		PreparedStatement statement = MySQLConnection.gerarPreparedStatement(conexao, sql);
		ResultSet resultSet = statement.executeQuery();
		
		ClienteDTO cliente = null;
		
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		
		while(resultSet.next()) {
			
			cliente = new ClienteDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), 
					resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),	resultSet.getString(10), resultSet.getString(11),  resultSet.getString(12), resultSet.getBoolean(13));
			
			clientes.add(cliente);
			
		}
		
		MySQLConnection.fecharResultSet(resultSet);
		MySQLConnection.fecharStatement(statement);
		MySQLConnection.fecharConexao(conexao);
		
		return clientes;
		
	}
	
	public ClienteDTO buscar(int id) throws SQLException {
		
		String sql = "select * from cliente where id = ?";
		
		Connection conexao = MySQLConnection.gerarConexao();
		PreparedStatement statement = MySQLConnection.gerarPreparedStatement(conexao, sql);
		
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		ClienteDTO cliente = null;
				
		while(resultSet.next()) {
			
			cliente = new ClienteDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), 
					resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),	resultSet.getString(10), resultSet.getString(11),  resultSet.getString(12), resultSet.getBoolean(13));
						
		}
		
		MySQLConnection.fecharResultSet(resultSet);
		MySQLConnection.fecharStatement(statement);
		MySQLConnection.fecharConexao(conexao);

		return cliente;
		
	}
	
	public void excluir(ClienteDTO cliente) throws SQLException {
		
		String sql = "delete from cliente where id = ?";
		
		Connection conexao = MySQLConnection.gerarConexao();
		PreparedStatement statement = MySQLConnection.gerarPreparedStatement(conexao, sql);

		statement.setInt(1, cliente.getId());
		
		statement.execute(sql);
		
		MySQLConnection.fecharStatement(statement);
		MySQLConnection.fecharConexao(conexao);
		
	}
	
}