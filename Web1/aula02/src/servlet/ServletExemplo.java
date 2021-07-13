package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletExemplo")
public class ServletExemplo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter saida = response.getWriter();
	    saida.write(
	    		"<html>"
	    		+ "<body>"
	    		+ "<h1>Olá!</h1>"
	    		+ "<a href=\"http://localhost:11182/aula02/MeuPrimeiroServlet\" target=\"_blank\">Clique aqui!</a>"
	    		+ "</body>"
	    		+ "</html>");
	    saida.close();
	}

}
