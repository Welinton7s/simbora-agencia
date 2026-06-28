package com.simbora.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simbora.model.Clientes;
import com.simbora.model.Destinos;
import com.simbora.model.Passagens;
import com.simbora.repository.DestinosRepository;
import com.simbora.repository.PassagensRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DestinosController {

    private final DestinosRepository destinoRepository;
    private final PassagensRepository passagemRepository;

    @Autowired
    public DestinosController(DestinosRepository destinoRepository, PassagensRepository passagemRepository) {
        this.destinoRepository = destinoRepository;
        this.passagemRepository = passagemRepository;
    }

    @GetMapping("/destinos")
    public String destinos() {
        return "views/destinos/destinos";
    }

    // Escolher um destino dos cards pré-definidos (ou busca customizada do formulário)
    @PostMapping("/buscar")
    public String buscar(@RequestParam String saida,
                         @RequestParam String destino,
                         @RequestParam String data,
                         @RequestParam(name = "passageiros", required = false, defaultValue = "1") Integer passageiros,
                         HttpSession session) {

        // O AuthInterceptor já garante que existe um cliente logado nessa rota
        Clientes clienteLogado = (Clientes) session.getAttribute("clienteLogado");

        // Salva o destino (igual ao DestinoServlet do JSP)
        Destinos novoDestino = new Destinos();
        novoDestino.setPartida(saida);
        novoDestino.setDestino(destino);
        novoDestino.setData(data);
        novoDestino.setQuantidadeDePassageiros(passageiros);
        destinoRepository.save(novoDestino);

        // Cria a passagem automaticamente vinculada ao cliente logado, com preço aleatório
        // (mesmo comportamento do DestinoServlet original: preço entre 100 e 500)
        Passagens passagem = new Passagens();
        passagem.setCliente(clienteLogado);
        passagem.setDestino(novoDestino);
        passagem.setDataViagem(data);
        double preco = 100 + new Random().nextDouble() * 400;
        passagem.setPreco(Math.round(preco * 100.0) / 100.0);
        passagemRepository.save(passagem);

        return "redirect:/passagens";
    }
}