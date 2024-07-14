package br.edu.faeterj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Processamento {

    public Processamento() throws SQLException {
        // Construtor vazio
    }

    public void InsertBanco(ArrayList<Cliente> clientes) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.createConnection();

        String sql = "INSERT INTO clientes (nome, cpf, email, endereco, cep) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        for (Cliente cliente : clientes) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getCep());
            ps.addBatch();
        }

        ps.executeBatch();
        ps.close();
        conn.close();
    }

    public ArrayList<Cliente> GetClientes() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.createConnection();

        String sql = "SELECT * FROM clientes";
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        ArrayList<Cliente> lCliente = new ArrayList<>();
        while (resultSet.next()) {
            Cliente cliente = new Cliente(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("email"), resultSet.getString("endereco"), resultSet.getString("cep"));
            lCliente.add(cliente);
        }

        resultSet.close();
        stmt.close();
        conn.close();

        return lCliente;
    }

    public Cliente GetClienteById(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.createConnection();

        String sql = "SELECT * FROM clientes WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();

        Cliente cliente = null;
        if (resultSet.next()) {
            cliente = new Cliente(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("email"), resultSet.getString("endereco"), resultSet.getString("cep"));
        }

        resultSet.close();
        ps.close();
        conn.close();

        return cliente;
    }

    public void UpdateCliente(Cliente cliente) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.createConnection();

        String sql = "UPDATE clientes SET nome = ?, cpf = ?, email = ?, endereco = ?, cep = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getEndereco());
        ps.setString(5, cliente.getCep());
        ps.setInt(6, cliente.getId());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public void DeleteCliente(int id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        ConnectionFactory cf = new ConnectionFactory();
        Connection conn = cf.createConnection();

        String sql = "DELETE FROM clientes WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    public ArrayList<Cliente> lerClientesDeArquivo(String arquivo) throws IOException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] values = linha.split(";");
            if (values.length == 5) {
                Cliente cliente = new Cliente();
                cliente.setNome(values[0]);
                cliente.setCpf(values[1]);
                cliente.setEmail(values[2]);
                cliente.setEndereco(values[3]);
                cliente.setCep(values[4]);
                clientes.add(cliente);
            }
        }
        br.close();
        return clientes;
    }
}
