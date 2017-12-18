package site.paginas.atualizar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.dao.BancoDAO;

import site.modelos.Conteudo;
import site.modelos.DadosUsuario;



@WebServlet(name = "AtualizarServlet", urlPatterns = {"/atualizar"}) 
public class AtualizarServlet extends HttpServlet {

	public static BancoDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		BancoDAO bd = new BancoDAO();
		List<Object> lista = bd.findAll("Conteudo");
		List<Conteudo> listaConteudo = new ArrayList<Conteudo>();
		for (Object ob : lista) {
			Conteudo conteudo = (Conteudo) ob;
			if (user.equals(conteudo.getNome())) {
				listaConteudo.add(conteudo);
			}
		}
		request.setAttribute("lista", listaConteudo);
		request.setAttribute("user", user);
		request.getRequestDispatcher("atualizar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
