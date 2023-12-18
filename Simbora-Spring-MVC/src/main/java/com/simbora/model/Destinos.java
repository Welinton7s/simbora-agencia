package com.simbora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destinos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String saida;
    private String destino;
    private String data;
    private String passageiros;

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
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

    public String getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(String passageiros) {
        this.passageiros = passageiros;
    }
}

