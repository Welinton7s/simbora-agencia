package com.simbora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simbora.model.Passagens;

public interface PassagensRepository extends JpaRepository<Passagens, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
