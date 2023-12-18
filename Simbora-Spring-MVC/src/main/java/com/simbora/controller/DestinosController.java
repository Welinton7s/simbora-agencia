package com.simbora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DestinosController {

    @PostMapping("/buscarDestinos")
    public String buscarDestinos(@RequestParam String saida, @RequestParam String destino, @RequestParam String data, @RequestParam String passageiros, Model model) {
        // Aqui você pode adicionar a lógica para buscar os destinos com os parâmetros fornecidos

        // Adicione os parâmetros ao model para que eles possam ser acessados na view
        model.addAttribute("saida", saida);
        model.addAttribute("destino", destino);
        model.addAttribute("data", data);
        model.addAttribute("passageiros", passageiros);

        // Redirecione para a página de destinos
        return "destinos";
    }
}
