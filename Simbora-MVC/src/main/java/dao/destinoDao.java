package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.destino;
import connection.conexão;

public class destinoDao {
	public void cadastrar(destino destino) throws Exception {
		String sql = "INSERT INTO destino (partida, destino, data, quantidade_de_passageiros) VALUES (?, ?, ?, ?)";

		try (Connection conn = conexão.createConnectionMySQL();
				PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, destino.getPartida());
			pst.setString(2, destino.getDestino());
			pst.setString(3, destino.getData());
			pst.setInt(4, destino.getQuantidade_de_passageiros());

			pst.executeUpdate();
		}
	}
}