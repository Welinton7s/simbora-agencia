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
public class ClientesController {

    @Autowired
    private ClientesRepository clienteRepository;

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    // ===== CADASTRO =====

    @GetMapping("/clientes/cadastro")
    public String cadastro(HttpSession session) {
        // Se já estiver logado, manda direto pra destinos
        if (session.getAttribute("clienteLogado") != null) {
            return "redirect:/destinos";
        }
        return "views/clientes/cadastro";
    }

    @PostMapping("/clientes/cadastro")
    public String cadastrar(@RequestParam String nome,
                            @RequestParam String email,
                            @RequestParam String senha,
                            @RequestParam String telefone,
                            Model model) {

        // Verifica se já existe cliente com esse email (igual ao CadastroServlet do JSP)
        Clientes existente = clienteRepository.findByEmail(email);
        if (existente != null) {
            model.addAttribute("mensagemErro", "Este e-mail já está cadastrado. Faça login ou use outro e-mail.");
            return "views/clientes/cadastro";
        }

        Clientes cliente = new Clientes();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setSenha(BCrypt.hashpw(senha, BCrypt.gensalt()));
        cliente.setTelefone(telefone);

        clienteRepository.save(cliente);

        model.addAttribute("mensagemSucesso", "Cadastro realizado com sucesso! Faça seu login.");
        return "views/clientes/login";
    }

    // ===== LOGIN =====

    @GetMapping("/clientes/login")
    public String login(HttpSession session, Model model) {
        // Se já estiver logado, manda direto pra destinos
        if (session.getAttribute("clienteLogado") != null) {
            return "redirect:/destinos";
        }
        return "views/clientes/login";
    }

    @PostMapping("/clientes/login")
    public String autenticar(@RequestParam String email,
                             @RequestParam String senha,
                             HttpSession session,
                             Model model) {

        Clientes cliente = clienteRepository.findByEmail(email);

        if (cliente != null && BCrypt.checkpw(senha, cliente.getSenha())) {
            session.setAttribute("clienteLogado", cliente);
            return "redirect:/destinos";
        }

        model.addAttribute("mensagemErro", "E-mail ou senha inválidos.");
        return "views/clientes/login";
    }

    // ===== RECUPERAR SENHA =====

    @GetMapping("/clientes/recuperar-senha")
    public String recuperarSenha(HttpSession session) {
        if (session.getAttribute("clienteLogado") != null) {
            return "redirect:/destinos";
        }
        return "views/clientes/recuperar-senha";
    }

    @PostMapping("/clientes/recuperar-senha")
    public String processarRecuperarSenha(@RequestParam String email, Model model) {
        Clientes cliente = clienteRepository.findByEmail(email);

        if (cliente != null) {
            model.addAttribute("mensagemSucesso", "Instruções enviadas para " + email + ". Verifique sua caixa de entrada.");
        } else {
            model.addAttribute("mensagemErro", "E-mail não encontrado. Verifique e tente novamente.");
        }

        return "views/clientes/recuperar-senha";
    }

    // ===== LOGOUT =====

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home";
    }
}