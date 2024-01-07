package com.simbora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


import com.simbora.model.Clientes;
import com.simbora.repository.ClientesRepository;

@Controller
public class ClientesController {

    @Autowired
    private ClientesRepository clienteRepository;
    
    @GetMapping("/clientes/cadastro")
    public String cadastro() {
        return "views/clientes/cadastro";
    }
    
    @GetMapping("/clientes/login")
    public String login() {
        return "views/clientes/login";
    }

    @PostMapping("/clientes")
    @ResponseBody
    public Clientes createCliente(@RequestBody Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    @PostMapping("/clientes/login")
    public String cadastrar(@RequestParam String nome, @RequestParam String email, @RequestParam String senha, @RequestParam String telefone) {
        // Crie um novo objeto Clientes com os dados do formulário
        Clientes cliente = new Clientes();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setSenha(senha);
        cliente.setTelefone(telefone);

        // Salve o novo cliente no banco de dados
        clienteRepository.save(cliente);

        // Redirecione para a página de login
        return "views/clientes/login";
    }

    
    @PostMapping("/destinos/destinos")
    public String login(@RequestParam String email, @RequestParam String senha, Model model) {
        // Busque o cliente no banco de dados pelo email
        Clientes cliente = clienteRepository.findByEmail(email);

        // Verifique se o cliente existe e a senha está correta
        if (cliente != null && cliente.getSenha().equals(senha)) {
            // Login bem-sucedido, redirecione para a página de destinos
            return "views/destinos/destinos";
        } else {
            // Login falhou, retorne à página de login com uma mensagem de erro
        	 model.addAttribute("erro", "Email ou senha inválidos");
             return "views/clientes/login";
        }
    }


    @GetMapping("/home")
    public String home() {
        return "index";
    }
}