package clienteServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bd.BD;

/**
 * Servlet implementation class UpdateDadosContatoCliente
 */
@WebServlet("/UpdateDadosContatoCliente")
public class UpdateDadosContatoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDadosContatoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		String cpf = request.getParameter("cpf"); //pegar par�metro da URL

		String email = request.getParameter("cliente_email");
		String fixo = request.getParameter("cliente_fixo");
		String celular = request.getParameter("cliente_cel");

		try{
			BD.clientes.updateDadosContatoCliente(email, fixo, celular, cpf);

			request.getSession().setAttribute("mensagem", "sucesso");

			request.getSession().setAttribute("cpf", cpf);

			response.sendRedirect(request.getContextPath() + "/jsp/cliente/consultar.jsp?resultado=sucesso");
		}

		catch(Exception e){
			e.printStackTrace();

			request.getSession().setAttribute("mensagem", "erro");

			response.sendRedirect(request.getContextPath() + "/jsp/cliente/consultar.jsp?resultado=erro");
		}
	}
}
