package com.simbora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.simbora.model.Destinos;
import com.simbora.repository.DestinosRepository;

@Controller
public class DestinosController {

    private final DestinosRepository destinoRepository;

    @Autowired
    public DestinosController(DestinosRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    @PostMapping("/buscar")
    public String buscar(Destinos destino) {
        destinoRepository.save(destino);
        return "views/passagens/passagem";
    }
}
