package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.DestinoDao;
import dao.PassagemDao;
import model.Cliente;
import model.Destino;
import model.Passagem;

@WebServlet("/destino-cadastrar")
public class DestinoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DestinoDao ddao = new DestinoDao();

    public DestinoServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
        case "/destino-cadastrar":
            try {
                cadastrar(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
        default:
            response.sendRedirect("index.jsp");
            break;
        }
    }

    protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Destino destino = new Destino();
        destino.setPartida(request.getParameter("saida"));
        destino.setDestino(request.getParameter("destino"));
        destino.setData(request.getParameter("data"));
        destino.setQuantidade_de_passageiros(Integer.parseInt(request.getParameter("Passageiros")));
        ddao.cadastrar(destino);

        int idDestino = ddao.getUltimoId();

        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");

        PassagemDao pdao = new PassagemDao();
        Passagem passagem = new Passagem();
        passagem.setIdCliente(clienteLogado.getId());
        passagem.setIdDestino(idDestino);
        passagem.setDataViagem(request.getParameter("data"));
        passagem.setPreco(100 + (Math.random() * 400));
        pdao.cadastrar(passagem);

        response.sendRedirect(request.getContextPath() + "/passagem-listar");
    }
}