package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ClienteDao;
import model.Cliente;

@WebServlet("/recuperar-senha")
public class recuperarSenhaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDao clienteDao = new ClienteDao();

    public recuperarSenhaServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");

        try {
            Cliente cliente = clienteDao.consultarPorEmail(email);

            if (cliente != null) {
                request.setAttribute("mensagemSucesso", "Instruções enviadas para " + email + ". Verifique sua caixa de entrada.");
            } else {
                request.setAttribute("mensagemErro", "E-mail não encontrado. Verifique e tente novamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao processar. Tente novamente.");
        } finally {
            request.getRequestDispatcher("/views/cliente/recuperar-senha.jsp").forward(request, response);
        }
    }
}