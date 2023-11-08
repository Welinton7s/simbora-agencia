package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.passagem;
import connection.conexão;

public class passagemDao {
	public void cadastrar(passagem passagem) throws Exception {
		String sql = "INSERT INTO Passagem (idCliente, idDestino, dataViagem, preco) VALUES (?, ?, ?, ?)";

		try (Connection conn = conexão.createConnectionMySQL();
				PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setInt(1, passagem.getIdCliente());
			pst.setInt(2, passagem.getIdDestino());
			pst.setString(3, passagem.getDataViagem());
			pst.setDouble(4, passagem.getPreco());

			pst.executeUpdate();
			
			Random rand = new Random();
			double precoAleatorio = 100 + (500 - 100) * rand.nextDouble();
			pst.setDouble(4, precoAleatorio);

			pst.executeUpdate();
		}
	}

	public List<passagem> consultar() {
		List<passagem> listaPassagens = new ArrayList<>();

		String sql = "SELECT * FROM Passagem";

		try (Connection conn = conexão.createConnectionMySQL();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				passagem passagem = new passagem();

				passagem.setId(rs.getInt("id"));
				passagem.setIdCliente(rs.getInt("idCliente"));
				passagem.setIdDestino(rs.getInt("idDestino"));
				passagem.setDataViagem(rs.getString("dataViagem"));
				passagem.setPreco(rs.getDouble("preco"));

				listaPassagens.add(passagem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaPassagens;
	}
}