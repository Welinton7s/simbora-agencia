package model;

public class Passagem {
    private int id;
    private Cliente cliente;
    private Destino destino;
    private String dataViagem;
    private double preco;

    public Passagem(int id, Cliente cliente, Destino destino, String dataViagem, double preco) {
        this.id = id;
        this.cliente = cliente;
        this.destino = destino;
        this.dataViagem = dataViagem;
        this.preco = preco;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Destino getDestino() {
        return destino;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public double getPreco() {
        return preco;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdDestino() {
        return destino.getId();
    }

    public int getIdCliente() {
        return cliente.getId();
    }
}