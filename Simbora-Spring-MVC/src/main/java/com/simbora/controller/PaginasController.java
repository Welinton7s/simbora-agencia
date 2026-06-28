package com.simbora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {

    @GetMapping("/promocao")
    public String promocao() {
        return "views/promocao";
    }

    @GetMapping("/contato")
    public String contato() {
        return "views/contato";
    }
}