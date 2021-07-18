package br.ufrn.imd.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * Controlador do sistema
  */
@WebServlet({"/receitas/html", "/receitas/todas", 
	"/receitas/receita"})
public class ControladorReceitas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static String receitas = "[\n" + 
			"	{\n" + 
			"		\"id\": 1,\n" + 
			"		\"titulo\": \"Frango Xadrez\"\n" + 
			"	},\n" + 
			"	{\n" + 
			"		\"id\": 2,\n" + 
			"		\"titulo\": \"Filé à Parmegiana\"\n" + 
			"	}\n" + 
			"]\n" + 
			"";
	
	private static Map<Integer, String> receitasMap = new HashMap<>();
	
	public ControladorReceitas() {
		   initMap();
	   }
	
	public static void initMap() {
	   receitasMap.put(1, "{\n" + 
		   		"	\"id\": 1,\n" + 
		   		"	\"titulo\": \"Frango Xadrez\",\n" + 
		   		"	\"descricao\": \"Frango Xadrez estilo Japonês com molho Shoyo Light.\",\n" + 
		   		"	\"ingredientes\": [\"1kg de Frango\", \"1/2 pimentão\", \"1 Cebola\", \"2 colheres de sopa de azeite\", \n" + 
		   		"	\"2 dentes de alho\"],\n" + 
		   		"	\"preparo\": \"Em uma frigideira ou panela grande, misture a metade do azeite de oliva, a cebola, o alho e deixe fritar. Retire e coloque em um prato. Na mesma panela, coloque o sal, o restante do azeite e frite os pimentões e os cogumelos por 5 minutos. Retire e despeje em outro prato. Ainda na mesma panela, coloque o frango e frite até dourar. Coloque todos os ingredientes novamente na frigideira, misture bem com uma colher de pau e refogue por mais 2 minutos. Em uma xícara, misture o molho shoyu, a maisena e a água. Mexa bem e junte a mistura de frango. Cozinhe, mexendo constantemente, até formar um molho espesso. Coloque em uma travessa, polvilhe com amendoim e sirva quente.\"\n" + 
		   		"}");
		   
	   receitasMap.put(2, "{\n" + 
	   		"	\"id\": 2,\n" + 
	   		"	\"titulo\": \"Filé à Parmegiana\",\n" + 
	   		"	\"descricao\": \"Filé à Parmegiana clássico.\",\n" + 
	   		"	\"ingredientes\": [\"10 bifes filé mignon\", \"1 xícara de farinha de trigo\", \"2 ovos\", \"1 pitada de sal\", \n" + 
	   		"	\"farinha de rosca\", \"1 lata de extrato de tomate\", \"1 pitadinha de açúcar\", \"10 fatias de mussarela\"],\n" + 
	   		"	\"preparo\": \"Corte o filé em bifes não muito finos (por favor não bata) e tempere-os a gosto. Passe os bifes na farinha de trigo. Bata ligeiramente os ovos (dois ou mais) com uma pitadinha de sal e passe os bifes nessa mistura. Passe os bifes na farinha de rosca. Faça com que a massa fique bem aderida aos bifes. Frite os bifes, deixe-os em papel toalha para que sequem bem e coloque-os em uma forma refratária.\"\n" + 
	   		"}");
	}
   
   /**
    * Metodo que trata/recebe as requisicoes do tipo POST
    *
    * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
    *      javax.servlet.http.HttpServletResponse)
    */
   @Override
   protected void doPost(HttpServletRequest request,
       HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
   }

   /**
    * Metodo que trata/recebe as requisicoes do tipo GET
    *
    * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
    *      javax.servlet.http.HttpServletResponse)
    */
   @Override
   protected void doGet(HttpServletRequest request,
       HttpServletResponse response) throws ServletException, IOException {

     String acaoSelecionada = request.getServletPath();
     if (acaoSelecionada.equalsIgnoreCase("/receitas/html")) {
    	enviarPaginaPadrao(request, response);
     } else if (acaoSelecionada.equalsIgnoreCase("/receitas/todas")) {
    	 enviarJson(receitas, response);
     } else if (acaoSelecionada.equalsIgnoreCase("/receitas/receita")) {
    	 Integer id = Integer.parseInt(request.getParameter("id"));
    	 if (id != null) {
    		 enviarJson(receitasMap.get(id), response);
    	 }
     }
     
   }

   private void enviarPaginaPadrao(HttpServletRequest request,
	       HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("/receitas_padrao.jsp").forward(request,
         response);
   }
   
   private void enviarJson(String json, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/json; charset=ISO-8859-1");
	   response.getWriter().write(json);
	   response.flushBuffer();
   }

}