package controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.PassagemDao;
import model.Cliente;
import model.Passagem;

@WebServlet(urlPatterns = {"/passagem-cadastrar", "/passagem-listar", "/passagem-excluir", "/passagem-editar"})
public class PassagemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PassagemDao pdao = new PassagemDao();

    public PassagemServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
        case "/passagem-cadastrar":
            try {
                cadastrar(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        case "/passagem-editar":
            try {
                editar(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        default:
            response.sendRedirect("index.jsp");
            break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
        case "/passagem-excluir":
            try {
                excluir(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        default:
            listar(request, response);
            break;
        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");
        if (clienteLogado == null) {
            response.sendRedirect(request.getContextPath() + "/views/cliente/login.jsp");
            return;
        }
        List<Passagem> lista = pdao.consultarPorCliente(clienteLogado.getId());
        request.setAttribute("listaPassagens", lista);
        request.getRequestDispatcher("/views/passagem/passagem.jsp").forward(request, response);
    }

    protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Passagem passagem = new Passagem();
        passagem.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
        passagem.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
        passagem.setDataViagem(request.getParameter("dataViagem"));
        passagem.setPreco(Double.parseDouble(request.getParameter("preco")));
        pdao.cadastrar(passagem);
        response.sendRedirect(request.getContextPath() + "/passagem-listar");
    }

    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        pdao.excluir(id);
        response.sendRedirect(request.getContextPath() + "/passagem-listar");
    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String partida = request.getParameter("partida");
        String destino = request.getParameter("destino");
        String dataViagem = request.getParameter("dataViagem");
        pdao.editar(id, partida, destino, dataViagem);
        response.sendRedirect(request.getContextPath() + "/passagem-listar");
    }
}