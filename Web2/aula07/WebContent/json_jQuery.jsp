<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.js"></script>
		<title>JSON+jQuery</title>
	</head>
	<body>

		<script type="text/javascript">

		   $(document).ready(onLoad);

		   var jsonObj = null;
		   var livro = null;

		   function onLoad() {

		     $("#livros").click(carregarLivro);

		     var ajaxReq = new XMLHttpRequest();
		     var url = "/aula07/livros.json";

		     ajaxReq.onreadystatechange = function() {
		       if (ajaxReq.readyState == 4 && ajaxReq.status == 200) {
		         jsonObj = eval('(' + ajaxReq.responseText + ')');
		         carregarLista();
		       }
		     };

		     ajaxReq.open("GET", url, true);
		     ajaxReq.send();

		   }
		   
		   function carregarLista() {
			      
		     var livros = jsonObj.livros.livro;
		     console.log(livros);
		     for ( var i = 0; i < livros.length; i++) {
		       var livro = livros[i];
		       console.log(livro);
		       var campoLivro = document.getElementById("livros");
		       alert(livro); 
		       campoLivro.options[campoLivro.length] = new Option(livro.nome, "" + i);
		     }
		   }

		   //function carregarLivro(indice) {
		   function carregarLivro() {
		     
		     var indice = $("#livros").val();
		     var livros = jsonObj.livros.livro;
		     var livro = livros[indice];

		     $("#nome").html(livro.nome);
		     $("#isbn").html(livro.isbn);

		     $("#editora").html(livro.editora);
		     $("#edicao").html(livro.edicao);
		     $("#preco").html(livro.preco);

		     var autoresStr = "";
		     var autores = livro.autores.autor;
		     for ( var i = 0; i < autores.length; i++) {
		       if (i > 0) {
		         autoresStr += " | ";
		       }
		       autoresStr += autores[i];
		     }
		     $("#autores").html(autoresStr);
		     $("#sinopse").html(livro.sinopse);

		     var atributos = document.getElementById("divLivroSelecionado").attributes;
		     atributos.getNamedItem("style").nodeValue = "";
		   }
		</script>
		<br>
		<select id="livros" size="2">
		</select>
		<br>

		<div id="divLivroSelecionado" style="visibility: hidden;"><br>
			<table border="1" width="60%">
			   <tr>
			     <td width="20%">Nome:</td>
			     <td id="nome"></td>
			   </tr>
			   <tr>
			     <td>ISBN:</td>
			     <td id="isbn"></td>
			   </tr>
			   <tr>
			     <td>Editora:</td>
			     <td id="editora"></td>
			   </tr>
			   <tr>
			     <td>Edição:</td>
			     <td id="edicao"></td>
			   </tr>
			   <tr>
			     <td>Autor(es):</td>
			     <td id="autores"></td>
			   </tr>
			   <tr>
			    <td>Preço:</td>
			     <td id="preco"></td>
			   </tr>
			   <tr>
			     <td colspan="2">Sinopse:</td>
			   </tr>
			   <tr height="100">
			     <td colspan="2" id="sinopse"></td>
			   </tr>
			</table>
		</div>

	</body>
</html>