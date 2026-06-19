package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Passagem;
import connection.conexao;

public class PassagemDao {

    public void cadastrar(Passagem passagem) throws Exception {
        String sql = "INSERT INTO passagem (id_cliente, id_destino, data_viagem, preco) VALUES (?, ?, ?, ?)";
        try (Connection conn = conexao.createConnectionMySQL();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, passagem.getIdCliente());
            pst.setInt(2, passagem.getIdDestino());
            pst.setString(3, passagem.getDataViagem());
            pst.setDouble(4, passagem.getPreco());
            pst.executeUpdate();
        }
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM passagem WHERE id = ?";
        try (Connection conn = conexao.createConnectionMySQL();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }

    public void editar(int idPassagem, String partida, String destino, String dataViagem) throws Exception {
        String sqlDestino = "UPDATE destino SET partida = ?, destino = ?, data = ? WHERE id = (SELECT id_destino FROM passagem WHERE id = ?)";
        String sqlPassagem = "UPDATE passagem SET data_viagem = ? WHERE id = ?";
        try (Connection conn = conexao.createConnectionMySQL()) {
            try (PreparedStatement pst = conn.prepareStatement(sqlDestino)) {
                pst.setString(1, partida);
                pst.setString(2, destino);
                pst.setString(3, dataViagem);
                pst.setInt(4, idPassagem);
                pst.executeUpdate();
            }
            try (PreparedStatement pst = conn.prepareStatement(sqlPassagem)) {
                pst.setString(1, dataViagem);
                pst.setInt(2, idPassagem);
                pst.executeUpdate();
            }
        }
    }

    public List<Passagem> consultarPorCliente(int idCliente) {
        List<Passagem> lista = new ArrayList<>();
        String sql = "SELECT p.*, d.partida, d.destino, d.data FROM passagem p JOIN destino d ON p.id_destino = d.id WHERE p.id_cliente = ?";
        try (Connection conn = conexao.createConnectionMySQL();
                PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Passagem p = new Passagem();
                    p.setId(rs.getInt("id"));
                    p.setIdCliente(rs.getInt("id_cliente"));
                    p.setIdDestino(rs.getInt("id_destino"));
                    p.setDataViagem(rs.getString("data_viagem"));
                    p.setPreco(rs.getDouble("preco"));
                    p.setPartida(rs.getString("partida"));
                    p.setDestino(rs.getString("destino"));
                    p.setDataDestino(rs.getString("data"));
                    lista.add(p);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}