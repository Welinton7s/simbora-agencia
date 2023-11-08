package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.conexão;
import model.cliente;

public class clienteDao {

	//CADASTRAR
	public boolean cadastrar(cliente cliente) throws Exception {
		String query = "insert into cliente (nome,email,senha,telefone) values (?,?,?,?)";
		PreparedStatement ps = null;
		Connection c = null;

		try {
			c = conexão.createConnectionMySQL();
			ps = c.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getSenha());
			ps.setString(4, cliente.getTelefone());

			boolean result = ps.execute();

			if (result == true) {
				System.out.println("Cliente cadastrado com sucesso");
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//CONSULTAR
	public List<cliente> consultar() {
		List<cliente> cliente = new ArrayList<cliente>();
		String query = "select * from cliente";
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rset = null;
		
		try {
			c =  conexão.createConnectionMySQL();
			ps = c.prepareStatement(query);
			rset = ps.executeQuery();
			
			while (rset.next()) {
				cliente Cliente = new cliente();
				
				Cliente.setId(rset.getInt("id"));
				Cliente.setNome(rset.getString("nome"));
				Cliente.setEmail(rset.getString("email"));
				Cliente.setSenha(rset.getString("senha"));
				Cliente.setTelefone(rset.getString("telefone"));
				
				cliente.add(Cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
		
	}
	
	//CONSULTAR POR ID
	public cliente consultarId(int id) {
		cliente cliente = new cliente();
		String query = "select * from cliente WHERE id = ?";
		
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rset = null;
		
		try {
			c = conexão.createConnectionMySQL();
			ps = c.prepareStatement(query);
			ps.setInt(1, id);
			rset = ps.executeQuery();
			rset.next();
			cliente.setId(rset.getInt("id"));
			cliente.setNome(rset.getString("nome"));
			cliente.setEmail(rset.getString("email"));
			cliente.setSenha(rset.getString("senha"));
			cliente.setTelefone(rset.getString("telefone"));
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return cliente;
}
	
	
	//ATUALIZAR
	public void atualizar(cliente cliente) {
		String query= "UPDATE cliente SET nome = ?, email = ?, senha = ?, telefone = ? WHERE id = ?";
		
		PreparedStatement ps = null;
		Connection c = null;
		ResultSet rset = null;
		
		try {
			c = conexão.createConnectionMySQL();
			ps = c.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getSenha());
			ps.setString(4, cliente.getTelefone());
			ps.setInt(5, cliente.getId());
			
			ps.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	

	//DELETAR
	public void deletar(int id) {
		String query = "DELETE FROM cliente WHERE id = ?";
		
		Connection c = null;
		PreparedStatement ps = null;
		
		try {
			c = conexão.createConnectionMySQL();
			ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
