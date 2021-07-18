<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>XML DOM</title>
</head>

<body onload="onLoad()">

	<script type="text/javascript">
		var xmlDoc = null;
		var livro = null;

		function onLoad() {

			var ajaxReq = new XMLHttpRequest();
			var url = "/aula06/livros.xml";

			ajaxReq.onreadystatechange = function() {
				if (ajaxReq.readyState == 4 && ajaxReq.status == 200) {
					xmlDoc = ajaxReq.responseXML;
					carregarLista();
				}
			};

			ajaxReq.open("GET", url, true);
			ajaxReq.send();

		}

		function carregarLista() {

			var livros = xmlDoc.getElementsByTagName("livro");
			for (var i = 0; i < livros.length; i++) {

				var livro = livros.item(i);

				var nome = "";
				var isbn = "";

				if (livro.hasAttributes()) {
					nome = livro.attributes.getNamedItem("nome").nodeValue;
					document.getElementById("nome").innerHTML = nome;
					isbn = livro.attributes.getNamedItem("isbn").nodeValue;
					document.getElementById("isbn").innerHTML = isbn;
				}

				var campoLivro = document.getElementById("livros");
				campoLivro.options[campoLivro.length] = new Option(nome, "" + i);

			}

		}

		function carregarLivro(indice) {

			var livros = xmlDoc.getElementsByTagName("livro");
			var livro = livros.item(indice);

			var nome = "";
			var isbn = "";
			if (livro.hasAttributes()) {
				nome = livro.attributes.getNamedItem("nome").nodeValue;
				document.getElementById("nome").innerHTML = nome;
				isbn = livro.attributes.getNamedItem("isbn").nodeValue;
				document.getElementById("isbn").innerHTML = isbn;
			}

			var nosFilhos = livro.childNodes;
			for (var i = 0; i < nosFilhos.length; i++) {
				var noFilho = nosFilhos.item(i);

				switch (noFilho.nodeName) {
				case "editora":
				case "edicao":
				case "preco":
				case "sinopse":
					var valor = noFilho.firstChild.nodeValue;
					document.getElementById(noFilho.nodeName).innerHTML = valor
					break;
				case "autores":
					var valor = "";
					for (var j = 0; j < noFilho.childNodes.length; j++) {
						if (noFilho.childNodes.item(j).nodeName == "autor") {
							if (valor != "") {
								valor += " | ";
							}
							valor += noFilho.childNodes.item(j).firstChild.nodeValue;
						}
					}
					document.getElementById(noFilho.nodeName).innerHTML = valor;

				default:
					break;
				}

			}

			var atributos = document.getElementById("divLivroSelecionado").attributes;
			atributos.getNamedItem("style").nodeValue = "";
		}
	</script>
	<br>

	<select id="livros" size="2" onclick="carregarLivro(this.value)">
	</select>

	<br>

	<div id="divLivroSelecionado" style="visibility: hidden;">
		<br>
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