package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.clienteDao;
import model.cliente;

@WebServlet(urlPatterns = { "/cliente-consultar", "/cliente-get-cadastrar", "/cliente-cadastrar", "/cliente-consultar-id", "/cliente-atualizar", "/cliente-deletar"})
public class cadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	clienteDao cdao = new clienteDao();
	cliente cliente = new cliente();

	public cadastroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/cliente-consultar":
			consultar(request, response);
			break;
		case "/cliente-get-cadastrar":
			getCadastrar(request, response);
			break;
		case "/cliente-cadastrar":
			try {
				cadastrar(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/cliente-consultar-id":
			consultarId(request, response);
			break;
		case "/cliente-atualizar":
			try {
				atualizar(request, response);
			} catch (ServletException e) {				
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			break;
		case "/cliente-deletar":
			deletar(request, response);
			break;
		default:
			response.sendRedirect("index.jsp");
			break;
		}

	}

	private void getCadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("./views/clientes/create.jsp");
		rd.forward(request, response);
		
	}

	protected void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<cliente> lista = cdao.consultar();

		request.setAttribute("listaClientes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/clientes/index.jsp");
		rd.forward(request, response);

	}

	protected void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));

		cdao.cadastrar(cliente);
		response.sendRedirect("views/cliente/login.jsp");
	}

	protected void consultarId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		cliente = cdao.consultarId(id);
		
		request.setAttribute("cliente", cliente);

		RequestDispatcher rd = request.getRequestDispatcher("./views/clientes/update.jsp");
		rd.forward(request, response);
	}

	protected void atualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));

		cdao.atualizar(cliente);
		response.sendRedirect("cliente-consultar");
	}

	protected void deletar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cdao.deletar(id);
		response.sendRedirect("cliente-consultar");
	}
}
