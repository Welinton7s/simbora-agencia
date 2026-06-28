package com.simbora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simbora.model.Passagens;

public interface PassagensRepository extends JpaRepository<Passagens, Integer> {

    List<Passagens> findByClienteId(Integer idCliente);
}