package site.paginas.entrar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.dao.BancoDAO;
import site.modelos.Conteudo;
import site.modelos.DadosUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EntrarServlet", urlPatterns = {"/sd"}, loadOnStartup = 1) 
public class EntrarServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	
    	request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    	
        
    }
}