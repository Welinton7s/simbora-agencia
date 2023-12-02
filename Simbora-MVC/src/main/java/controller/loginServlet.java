package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.clienteDao;
import model.cliente;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private clienteDao clienteDao = new clienteDao();

    public loginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            cliente cliente = clienteDao.consultarPorEmailESenha(email, senha);
            if (cliente != null) {
                // O cliente existe, faça o login.
                request.getSession().setAttribute("clienteLogado", cliente);
                response.sendRedirect("views/destino/destinos.jsp");
            } else {
                // O cliente não existe, redirecione de volta para a página de login com uma mensagem de erro.
                request.setAttribute("mensagemErro", "E-mail ou senha inválidos.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
