package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.passagemDao;
import model.passagem;

@WebServlet(urlPatterns = { "/passagem-cadastrar"})
public class passagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	passagemDao pdao = new passagemDao();
	passagem passagem = new passagem();

	public passagemServlet() {
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
		default:
			response.sendRedirect("index.jsp");
			break;
		}

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		passagem.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		passagem.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		passagem.setDataViagem(request.getParameter("dataViagem"));
		passagem.setPreco(Double.parseDouble(request.getParameter("preco")));

		pdao.cadastrar(passagem);
		response.sendRedirect("views/passagem/passagem.jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<passagem> listaPassagens = pdao.consultar();

		request.setAttribute("listaPassagens", listaPassagens);

		RequestDispatcher rd = request.getRequestDispatcher("./views/passagens/passagem.jsp");
		rd.forward(request, response);
	}
}
