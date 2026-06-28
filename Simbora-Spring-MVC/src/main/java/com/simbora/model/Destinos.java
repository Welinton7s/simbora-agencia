package com.simbora.model;

import jakarta.persistence.*;

@Entity
@Table(name = "destino")
public class Destinos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "partida", nullable = false, length = 100)
    private String partida;

    @Column(name = "destino", nullable = false, length = 100)
    private String destino;

    // O banco já tem essa coluna como VARCHAR(30), e o projeto trabalha
    // a data como texto, então mantemos String aqui também.
    @Column(name = "data", length = 30)
    private String data;

    @Column(name = "quantidade_de_passageiros", nullable = false)
    private Integer quantidadeDePassageiros;

    public Destinos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getQuantidadeDePassageiros() {
        return quantidadeDePassageiros;
    }

    public void setQuantidadeDePassageiros(Integer quantidadeDePassageiros) {
        this.quantidadeDePassageiros = quantidadeDePassageiros;
    }
}