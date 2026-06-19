package controller;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cliente;

@WebFilter(urlPatterns = {
    "/views/destino/*",
    "/views/passagem/*",
    "/views/promocao/*",
    "/views/contato/*",
    "/views/cliente/perfil.jsp",
    "/passagem-listar",
    "/passagem-cadastrar",
    "/passagem-excluir",
    "/passagem-editar",
    "/destino-cadastrar",
    "/perfil",
    "/perfil-atualizar",
    "/logout"
})
public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        Cliente clienteLogado = (session != null) ? (Cliente) session.getAttribute("clienteLogado") : null;

        if (clienteLogado == null) {
            res.sendRedirect(req.getContextPath() + "/views/cliente/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}