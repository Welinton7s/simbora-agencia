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

@WebServlet(urlPatterns = {"/perfil", "/perfil-atualizar"})
public class PerfilServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteDao clienteDao = new ClienteDao();

    public PerfilServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        if (clienteLogado == null) {
            response.sendRedirect(request.getContextPath() + "/views/cliente/login.jsp");
            return;
        }
        request.getRequestDispatcher("/views/cliente/perfil.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        if (clienteLogado == null) {
            response.sendRedirect(request.getContextPath() + "/views/cliente/login.jsp");
            return;
        }

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String senhaAtual = request.getParameter("senhaAtual");
        String novaSenha = request.getParameter("novaSenha");

        try {
            // Verifica se quer mudar a senha
            if (senhaAtual != null && !senhaAtual.isEmpty()) {
                if (!BCrypt.checkpw(senhaAtual, clienteLogado.getSenha())) {
                    request.setAttribute("mensagemErro", "Senha atual incorreta.");
                    request.getRequestDispatcher("/views/cliente/perfil.jsp").forward(request, response);
                    return;
                }
                clienteLogado.setSenha(BCrypt.hashpw(novaSenha, BCrypt.gensalt()));
            }

            clienteLogado.setNome(nome);
            clienteLogado.setEmail(email);
            clienteLogado.setTelefone(telefone);

            clienteDao.atualizar(clienteLogado);

            // Atualiza a sessão
            request.getSession().setAttribute("clienteLogado", clienteLogado);
            request.setAttribute("mensagemSucesso", "Perfil atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagemErro", "Erro ao atualizar perfil.");
        }

        request.getRequestDispatcher("/views/cliente/perfil.jsp").forward(request, response);
    }
}