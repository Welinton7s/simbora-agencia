package com.simbora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.simbora.model.Passagens;
import com.simbora.repository.PassagensRepository;

@Controller
public class PassagensController {

    @Autowired
    private PassagensRepository passagemRepository;

    @PostMapping("/passagens")
    @ResponseBody
    public Passagens createPassagem(@RequestBody Passagens passagem) {
        return passagemRepository.save(passagem);
    }

    // Outros métodos do controlador aqui
}

