package com.simbora.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.simbora.model.Clientes;
import com.simbora.repository.ClientesRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PerfilController {

    @Autowired
    private ClientesRepository clienteRepository;

    @GetMapping("/perfil")
    public String perfil(HttpSession session, Model model) {
        Clientes clienteLogado = (Clientes) session.getAttribute("clienteLogado");
        model.addAttribute("cliente", clienteLogado);
        return "views/clientes/perfil";
    }

    @PostMapping("/perfil")
    public String atualizar(@RequestParam String nome,
                            @RequestParam String email,
                            @RequestParam(required = false) String telefone,
                            @RequestParam(required = false) String senhaAtual,
                            @RequestParam(required = false) String novaSenha,
                            HttpSession session,
                            Model model) {

        Clientes clienteLogado = (Clientes) session.getAttribute("clienteLogado");

        // Se o cliente preencheu o campo de senha atual, tenta trocar a senha
        if (senhaAtual != null && !senhaAtual.isEmpty()) {
            if (!BCrypt.checkpw(senhaAtual, clienteLogado.getSenha())) {
                model.addAttribute("mensagemErro", "Senha atual incorreta.");
                model.addAttribute("cliente", clienteLogado);
                return "views/clientes/perfil";
            }
            clienteLogado.setSenha(BCrypt.hashpw(novaSenha, BCrypt.gensalt()));
        }

        clienteLogado.setNome(nome);
        clienteLogado.setEmail(email);
        clienteLogado.setTelefone(telefone);

        clienteRepository.save(clienteLogado);

        // Atualiza os dados na sessão para refletir no menu imediatamente
        session.setAttribute("clienteLogado", clienteLogado);

        model.addAttribute("mensagemSucesso", "Perfil atualizado com sucesso!");
        model.addAttribute("cliente", clienteLogado);
        return "views/clientes/perfil";
    }
}