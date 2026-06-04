package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Destino;

public class DestinoDao {
    private Connection connection;

    public DestinoDao(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Destino destino) throws SQLException {
        String sql = "INSERT INTO destino(partida, destino, data, quantidade_de_passageiros) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, destino.getPartida());
            stmt.setString(2, destino.getDestino());
            stmt.setString(3, destino.getData());
            stmt.setInt(4, destino.getQuantidadeDePassageiros());
            stmt.execute();
        }
    }

    public void altera(Destino destino) throws SQLException {
        String sql = "UPDATE destino SET partida = ?, destino = ?, data = ?, quantidade_de_passageiros = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, destino.getPartida());
            stmt.setString(2, destino.getDestino());
            stmt.setString(3, destino.getData());
            stmt.setInt(4, destino.getQuantidadeDePassageiros());
            stmt.setInt(5, destino.getId());
            stmt.execute();
        }
    }

    public void exclui(int id) throws SQLException {
        String sql = "DELETE FROM destino WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    public List<Destino> getDestinos() throws SQLException {
        List<Destino> destinos = new ArrayList<>();
        String sql = "SELECT * FROM destino";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Destino destino = new Destino(
                    rs.getString("partida"),
                    rs.getString("destino"),
                    rs.getString("data"),
                    rs.getInt("quantidade_de_passageiros")
                );
                destino.setId(rs.getInt("id"));
                destinos.add(destino);
            }
        }
        return destinos;
    }

    public Destino getDestinoPeloNome(String nomeDestino) throws SQLException {
        Destino destino = null;
        String sql = "SELECT * FROM destino WHERE destino = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, nomeDestino);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                destino = new Destino(
                    rs.getString("partida"),
                    rs.getString("destino"),
                    rs.getString("data"),
                    rs.getInt("quantidade_de_passageiros")
                );
                destino.setId(rs.getInt("id"));
            }
        }
        return destino;
    }

    public Destino getDestino(int id) throws SQLException {
        Destino destino = null;
        String sql = "SELECT * FROM destino WHERE id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                destino = new Destino(
                    rs.getString("partida"),
                    rs.getString("destino"),
                    rs.getString("data"),
                    rs.getInt("quantidade_de_passageiros")
                );
                destino.setId(rs.getInt("id"));
            }
        }
        return destino;
    }
}