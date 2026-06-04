package com.simbora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simbora.model.Destinos;

public interface DestinosRepository extends JpaRepository<Destinos, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}

