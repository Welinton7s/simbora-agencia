package com.simbora.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "telefone")
    private String telefone;

	public void setNome(String nome2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(String email2) {
		// TODO Auto-generated method stub
		
	}

	public void setSenha(String senha2) {
		// TODO Auto-generated method stub
		
	}

	public void setTelefone(String telefone2) {
		// TODO Auto-generated method stub
		
	}

	public Object getSenha() {
		// TODO Auto-generated method stub
		return null;
	}

    // getters e setters aqui
}
