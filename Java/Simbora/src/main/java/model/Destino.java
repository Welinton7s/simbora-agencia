package model;

public class Destino {
    private int id;
    private String partida;
    private String destino;
    private String data;
    private int quantidadeDePassageiros;

    public Destino(String partida, String destino, String data, int quantidadeDePassageiros) {
        this.id = id;
        this.partida = partida;
        this.destino = destino;
        this.data = data;
        this.quantidadeDePassageiros = quantidadeDePassageiros;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getPartida() {
        return partida;
    }

    public String getDestino() {
        return destino;
    }

    public String getData() {
        return data;
    }

    public int getQuantidadeDePassageiros() {
        return quantidadeDePassageiros;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setQuantidadeDePassageiros(int quantidadeDePassageiros) {
        this.quantidadeDePassageiros = quantidadeDePassageiros;
    }
}