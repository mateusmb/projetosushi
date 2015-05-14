package br.edu.ifc.blumenau.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySQLConnection {

    public static Connection gerarConexao() {

        try {

            Context initContext = new InitialContext();
            Context envContex = (Context) initContext.lookup("java:/comp/env");
            DataSource dataSource = (DataSource) envContex.lookup("jdbc/SushiDB");

            return dataSource.getConnection();

        } catch (NamingException e) {

            System.err.println("Erro ao criar a conex�o. " + e.getMessage());

        } catch (SQLException e) {

            System.err.println("Erro ao criar a conex�o. " + e.getMessage());

        }

        return null;

    }

    public static PreparedStatement gerarPreparedStatement(Connection conexao, String sql) {

        try {

            return conexao.prepareStatement(sql);

        } catch (SQLException e) {

            System.err.println("Erro ao criar o preparedStatement. " + e.getMessage());

        }

        return null;

    }

    public static ResultSet gerarResultSet(PreparedStatement statement) {

        try {

            return statement.executeQuery();

        } catch (SQLException e) {

            System.err.println("Erro ao criar o resultSet. " + e.getMessage());

        }

        return null;

    }

    public static void fecharConexao(Connection conexao) {

        if (conexao != null) {

            try {

                conexao.close();

            } catch (SQLException e) {

                System.err.println("Erro ao fechar a conex�o. " + e.getMessage());

            }

        }

    }

    public static void fecharStatement(PreparedStatement statement) {

        if (statement != null) {

            try {

                statement.close();

            } catch (SQLException e) {

                System.err.println("Erro ao fechar o statement. " + e.getMessage());

            }

        }

    }

    public static void fecharResultSet(ResultSet resultSet) {

        if (resultSet != null) {

            try {

                resultSet.close();

            } catch (SQLException e) {

                System.err.println("Erro ao fechar o resultSet. " + e.getMessage());

            }

        }

    }

}
