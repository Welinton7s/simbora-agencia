package com.simbora.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "destino")
public class Destinos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partida")
    private String saida;

    @Column(name = "destino")
    private String destino;

    @Column(name = "data")
    private Date data;

    @Column(name = "quantidade_de_passageiros")
    private Integer passageiros;

    // Getters e setters
}
