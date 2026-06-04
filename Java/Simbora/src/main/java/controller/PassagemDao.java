package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Destino;
import model.Passagem;

public class PassagemDao {
    private Connection connection;

    public PassagemDao(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Passagem passagem) throws SQLException {
        String sql = "INSERT INTO passagem(id_cliente, id_destino, data_viagem, preco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, passagem.getIdCliente());
            stmt.setInt(2, passagem.getIdDestino());
            stmt.setString(3, passagem.getDataViagem());
            stmt.setDouble(4, passagem.getPreco());
            stmt.execute();
        }
    }

    public void altera(Passagem passagem) throws SQLException {
        String sql = "UPDATE passagem SET id_cliente = ?, id_destino = ?, data_viagem = ?, preco = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, passagem.getIdCliente());
            stmt.setInt(2, passagem.getIdDestino());
            stmt.setString(3, passagem.getDataViagem());
            stmt.setDouble(4, passagem.getPreco());
            stmt.setInt(5, passagem.getId());
            stmt.execute();
        }
    }

    public void exclui(int id) throws SQLException {
        String sql = "DELETE FROM passagem WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }

    public List<Passagem> getPassagens() throws SQLException {
        List<Passagem> passagens = new ArrayList<>();
        String sql = "SELECT * FROM passagem";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ClienteDao clienteDao = new ClienteDao(connection);
                DestinoDao destinoDao = new DestinoDao(connection);
                Cliente cliente = clienteDao.getCliente(rs.getInt("id_cliente"));
                Destino destino = destinoDao.getDestino(rs.getInt("id_destino"));
                Passagem passagem = new Passagem(
                    rs.getInt("id"),
                    cliente,
                    destino,
                    rs.getString("data_viagem"),
                    rs.getDouble("preco")
                );
                passagens.add(passagem);
            }
        }
        return passagens;
    }

    public void salvar(Passagem passagem) throws SQLException {
        if (passagem.getId() == 0) {
            adiciona(passagem);
        } else {
            altera(passagem);
        }
    }

    public Passagem getPassagem(int idPassagem) throws SQLException {
        String sql = "SELECT * FROM passagem WHERE id = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, idPassagem);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ClienteDao clienteDao = new ClienteDao(connection);
                DestinoDao destinoDao = new DestinoDao(connection);
                Cliente cliente = clienteDao.getCliente(rs.getInt("id_cliente"));
                Destino destino = destinoDao.getDestino(rs.getInt("id_destino"));
                Passagem passagem = new Passagem(
                    rs.getInt("id"),
                    cliente,
                    destino,
                    rs.getString("data_viagem"),
                    rs.getDouble("preco")
                );
                return passagem;
            } else {
                return null;
            }
        }
    }
}