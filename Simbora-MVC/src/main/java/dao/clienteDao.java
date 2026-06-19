package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.conexao;
import model.Cliente;

public class ClienteDao {

    public boolean cadastrar(Cliente cliente) {
        String query = "INSERT INTO cliente (nome, email, senha, telefone) VALUES (?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = conexao.createConnectionMySQL();
            ps = c.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getSenha());
            ps.setString(4, cliente.getTelefone());
            int linhas = ps.executeUpdate();
            return linhas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Cliente> consultar() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            c = conexao.createConnectionMySQL();
            ps = c.prepareStatement(query);
            rset = ps.executeQuery();
            while (rset.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rset.getInt("id"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEmail(rset.getString("email"));
                cliente.setSenha(rset.getString("senha"));
                cliente.setTelefone(rset.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) rset.close();
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientes;
    }

    public Cliente consultarId(int id) {
        Cliente cliente = new Cliente();
        String query = "SELECT * FROM cliente WHERE id = ?";
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rset = null;
        try {
            c = conexao.createConnectionMySQL();
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rset = ps.executeQuery();
            if (rset.next()) {
                cliente.setId(rset.getInt("id"));
                cliente.setNome(rset.getString("nome"));
                cliente.setEmail(rset.getString("email"));
                cliente.setSenha(rset.getString("senha"));
                cliente.setTelefone(rset.getString("telefone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) rset.close();
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cliente;
    }

    public void atualizar(Cliente cliente) {
        String query = "UPDATE cliente SET nome = ?, email = ?, senha = ?, telefone = ? WHERE id = ?";
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = conexao.createConnectionMySQL();
            ps = c.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getSenha());
            ps.setString(4, cliente.getTelefone());
            ps.setInt(5, cliente.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletar(int id) {
        String query = "DELETE FROM cliente WHERE id = ?";
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = conexao.createConnectionMySQL();
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Cliente consultarPorEmail(String email) throws Exception {
        Cliente cliente = null;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = conexao.createConnectionMySQL();
            ps = c.prepareStatement("SELECT * FROM cliente WHERE email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setTelefone(rs.getString("telefone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cliente;
    }

    public Cliente consultarPorEmailESenha(String email, String senha) throws Exception {
        return consultarPorEmail(email);
    }
}