package model;

public class Passagem {
    private int id;
    private int idCliente;
    private int idDestino;
    private String dataViagem;
    private double preco;
    private String partida;
    private String destino;
    private String dataDestino;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public int getIdDestino() { return idDestino; }
    public void setIdDestino(int idDestino) { this.idDestino = idDestino; }
    public String getDataViagem() { return dataViagem; }
    public void setDataViagem(String dataViagem) { this.dataViagem = dataViagem; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public String getPartida() { return partida; }
    public void setPartida(String partida) { this.partida = partida; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public String getDataDestino() { return dataDestino; }
    public void setDataDestino(String dataDestino) { this.dataDestino = dataDestino; }
}