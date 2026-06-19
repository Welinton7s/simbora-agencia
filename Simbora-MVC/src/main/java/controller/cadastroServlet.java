package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ClienteDao;
import model.Cliente;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(urlPatterns = {"/usuario", "/usuario-create", "/usuario-edit", "/usuario-update", "/usuario-delete"})
public class CadastroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDao clienteDao = new ClienteDao();

    public CadastroServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("telefone");

        try {

            Cliente existente = clienteDao.consultarPorEmail(email);
            if (existente != null) {
                request.setAttribute("mensagemErro", "Este e-mail já está cadastrado. Faça login ou use outro e-mail.");
                request.getRequestDispatcher("/views/cliente/cadastro.jsp").forward(request, response);
                return;
            }

            String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());
            Cliente cliente = new Cliente(nome, email, senhaHash, telefone);
            clienteDao.cadastrar(cliente);
            request.setAttribute("mensagemSucesso", "Cadastro realizado com sucesso! Faça seu login.");
            request.getRequestDispatcher("/views/cliente/login.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao cadastrar. Tente novamente.");
            request.getRequestDispatcher("/views/cliente/cadastro.jsp").forward(request, response);
        }
    }
}