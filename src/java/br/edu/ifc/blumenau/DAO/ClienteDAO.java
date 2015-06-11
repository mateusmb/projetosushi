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

    public ArrayList<ClienteDTO> listar() throws SQLException {

        String sql = "select * from cliente";

        Connection conexao = MySQLConnection.gerarConexao();
        PreparedStatement statement = MySQLConnection.gerarPreparedStatement(conexao, sql);
        ResultSet resultSet = statement.executeQuery();

        ClienteDTO cliente = null;

        ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();

        while (resultSet.next()) {

            cliente = new ClienteDTO(resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("cpf"),
                    resultSet.getString("endereco"),
                    resultSet.getString("numero"),
                    resultSet.getString("complemento"),
                    resultSet.getString("bairro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("estado"),
                    resultSet.getString("cep"),
                    resultSet.getString("telefone"),
                    resultSet.getString("usuario"),
                    resultSet.getString("senha"),
                    resultSet.getBoolean("tipo"));

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

        while (resultSet.next()) {

            cliente = new ClienteDTO(resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("cpf"),
                    resultSet.getString("endereco"),
                    resultSet.getString("numero"),
                    resultSet.getString("complemento"),
                    resultSet.getString("bairro"),
                    resultSet.getString("cidade"),
                    resultSet.getString("estado"),
                    resultSet.getString("cep"),
                    resultSet.getString("telefone"),
                    resultSet.getString("usuario"),
                    resultSet.getString("senha"),
                    resultSet.getBoolean("tipo"));

        }
        MySQLConnection.fecharResultSet(resultSet);
        MySQLConnection.fecharStatement(statement);
        MySQLConnection.fecharConexao(conexao);

        return cliente;

    }

    public void excluir(int id) throws SQLException {
        String sql = "delete from cliente where id = ?";
        Connection conexao = MySQLConnection.gerarConexao();
        PreparedStatement statement = MySQLConnection.gerarPreparedStatement(conexao, sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        MySQLConnection.fecharStatement(statement);
        MySQLConnection.fecharConexao(conexao);
    }

}
