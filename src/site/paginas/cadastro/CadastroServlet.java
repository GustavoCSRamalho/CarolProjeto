package site.paginas.cadastro;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.dao.BancoDAO;

import site.modelos.DadosUsuario;

@WebServlet(name = "CadastroServlet", urlPatterns = { "/cadastro" })
public class CadastroServlet extends HttpServlet {

	public static BancoDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("OI");
		request.getRequestDispatcher("informacoes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DadosUsuario du = null;

		System.out.println("Aqui");
		du = new DadosUsuario();
		String conteudo = request.getParameter("nome");
		du.setNome(conteudo);
		conteudo = request.getParameter("cpf");
		du.setCpf(conteudo);
		conteudo = request.getParameter("endereco");
		du.setEndereco(conteudo);
		conteudo = request.getParameter("email");
		du.setEmail(conteudo);
		conteudo = request.getParameter("usuario");
		du.setUsuario(conteudo);
		conteudo = request.getParameter("senha");
		du.setSenha(conteudo);
		conteudo = request.getParameter("op");
		du.setSexo(conteudo);

		dao = new BancoDAO();

		dao.inserir(du);

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}
}
