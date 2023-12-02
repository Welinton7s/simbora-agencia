package controller;

import java.io.IOException;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import dao.destinoDao;
import model.destino;

@WebServlet("/destino-cadastrar")
public class destinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	destinoDao ddao = new destinoDao();
	destino destino = new destino();

	public destinoServlet() {
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
	    destino destino = new destino();
	    destino.setPartida(request.getParameter("saida"));
	    destino.setDestino(request.getParameter("destino"));
	    destino.setData(request.getParameter("data"));
	    destino.setQuantidade_de_passageiros(Integer.parseInt(request.getParameter("Passageiros")));

	    ddao.cadastrar(destino);
	    response.sendRedirect("views/passagem/passagem.jsp");
	}

}
