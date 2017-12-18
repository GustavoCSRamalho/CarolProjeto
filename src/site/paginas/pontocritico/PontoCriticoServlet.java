package site.paginas.pontocritico;

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


@WebServlet(name = "PontoCriticoServlet", urlPatterns = { "/addponto" })
public class PontoCriticoServlet extends HttpServlet {

	public static BancoDAO dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BancoDAO bd = new BancoDAO();
		String id = request.getParameter("id");
		if (id != null) {
			if (Integer.parseInt(id) != 0) {
				List<Object> lista = bd.findAll("Conteudo");
				Conteudo conteudo = new Conteudo();
				for (Object ob : lista) {
					Conteudo c = (Conteudo) ob;
					if (Integer.parseInt(id) == c.getId()) {
						conteudo = c;
					}
				}
				request.setAttribute("endereco", conteudo.getEndereco());
				request.setAttribute("mensagem", conteudo.getMensagem());
				request.setAttribute("id", conteudo.getId());
			}
		}

		String user = request.getParameter("user");
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("teste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession sessao = request.getSession();
		// String user = (String)sessao.getAttribute("user");
		BancoDAO bd = new BancoDAO();
		String user = request.getParameter("nome");
		request.setAttribute("user", user);
		String id = request.getParameter("id");
		boolean existe = false;
		Conteudo conteudoBD = null;
		if (Integer.parseInt(id) != 0) {

			List<Object> lista = bd.findAll("Conteudo");
			for (Object ob : lista) {
				Conteudo c = (Conteudo) ob;
				if (c.getId() == Integer.parseInt(id)) {
					conteudoBD = c;
					existe = true;
					break;
				}
			}
		}

		if (!existe) {
			Conteudo po = new Conteudo();
			dao = new BancoDAO();
			String msg = request.getParameter("mensagem");
			String end = request.getParameter("endereco");
			String opcao = request.getParameter("op");
			po.setMensagem(msg);
			po.setEndereco(end);
			po.setNome(user);
			po.setTipo(opcao);
			dao.inserir(po);

		} else {
			String mensagem = request.getParameter("mensagem");
			String endereco = request.getParameter("endereco");
			// String tipo = request.getParameter("tipo");
			String opcao = request.getParameter("op");
			conteudoBD.setEndereco(endereco);
			conteudoBD.setMensagem(mensagem);
			conteudoBD.setTipo(opcao);
			// conteudoBD.setTipo(tipo);
			bd.update(conteudoBD);

		}
		List<Object> lista = bd.findAll("Conteudo");
		List<Conteudo> listaConteudo = new ArrayList<Conteudo>();
		for (Object ob : lista) {
			Conteudo conteudo = (Conteudo) ob;

			listaConteudo.add(conteudo);

		}
		request.setAttribute("lista", listaConteudo);
		request.getRequestDispatcher("ponte.jsp").forward(request, response);

		// String user = request.getParameter("user");

	}
}
