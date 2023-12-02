package controller;

import java.io.IOException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dao.clienteDao;
import model.cliente;

@WebServlet(urlPatterns = { "/usuario", "/usuario-create", "/usuario-edit", "/usuario-update", "/usuario-delete" })
public class cadastroServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    private clienteDao clienteDao = new clienteDao();

    public cadastroServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");

        cliente cliente = new cliente(nome, email, senha, telefone);
        try {
			clienteDao.cadastrar(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect("views/cliente/login.jsp");
    }
}
