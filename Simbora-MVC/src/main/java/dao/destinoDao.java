package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.conexao;
import model.Destino;

public class DestinoDao {

    public boolean cadastrar(Destino destino) throws Exception {

        String sql = "INSERT INTO destino (partida, destino, data, quantidade_de_passageiros) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = conexao.createConnectionMySQL();
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, destino.getPartida());
            pst.setString(2, destino.getDestino());
            pst.setDate(3, Date.valueOf(destino.getData()));
            pst.setInt(4, destino.getQuantidade_de_passageiros());

            return pst.executeUpdate() > 0;
        }
    }

    public int getUltimoId() throws Exception {

        String sql = "SELECT MAX(id) AS id FROM destino";

        try (
                Connection conn = conexao.createConnectionMySQL();
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("id");
            }
        }

        return 0;
    }

    public Destino consultarPorDestino(String nomeDestino) throws Exception {

        String sql = "SELECT * FROM destino WHERE destino = ?";

        try (
                Connection conn = conexao.createConnectionMySQL();
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, nomeDestino);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {

                    Destino destino = new Destino();

                    destino.setPartida(rs.getString("partida"));
                    destino.setDestino(rs.getString("destino"));
                    destino.setData(rs.getString("data"));
                    destino.setQuantidade_de_passageiros(
                            rs.getInt("quantidade_de_passageiros"));

                    return destino;
                }
            }
        }

        return null;
    }

    public boolean deletarPorDestino(String nomeDestino) throws Exception {

        String sql = "DELETE FROM destino WHERE destino = ?";

        try (
                Connection conn = conexao.createConnectionMySQL();
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, nomeDestino);

            return pst.executeUpdate() > 0;
        }
    }
}