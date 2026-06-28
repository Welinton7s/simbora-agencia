package com.simbora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simbora.model.Clientes;
import com.simbora.model.Passagens;
import com.simbora.repository.PassagensRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PassagensController {

    @Autowired
    private PassagensRepository passagemRepository;

    // Lista apenas as passagens do cliente logado (igual ao passagem-listar do JSP)
    @GetMapping("/passagens")
    public String listar(HttpSession session, Model model) {
        Clientes clienteLogado = (Clientes) session.getAttribute("clienteLogado");
        model.addAttribute("listaPassagens", passagemRepository.findByClienteId(clienteLogado.getId()));
        return "views/passagens/passagem";
    }

    // Edita partida/destino/data da passagem (igual ao passagem-editar do JSP)
    @PostMapping("/passagens/editar")
    public String editar(@RequestParam Integer id,
                         @RequestParam String partida,
                         @RequestParam String destino,
                         @RequestParam String dataViagem,
                         HttpSession session) {

        Clientes clienteLogado = (Clientes) session.getAttribute("clienteLogado");

        Passagens passagem = passagemRepository.findById(id).orElse(null);
        if (passagem != null && passagem.getCliente().getId().equals(clienteLogado.getId())) {
            passagem.getDestino().setPartida(partida);
            passagem.getDestino().setDestino(destino);
            passagem.setDataViagem(dataViagem);
            passagemRepository.save(passagem);
        }

        return "redirect:/passagens";
    }

    // Exclui a passagem (igual ao passagem-excluir do JSP)
    @PostMapping("/passagens/excluir")
    public String excluir(@RequestParam Integer id, HttpSession session) {
        Clientes clienteLogado = (Clientes) session.getAttribute("clienteLogado");

        Passagens passagem = passagemRepository.findById(id).orElse(null);
        if (passagem != null && passagem.getCliente().getId().equals(clienteLogado.getId())) {
            passagemRepository.delete(passagem);
        }

        return "redirect:/passagens";
    }
}