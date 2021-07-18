<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
		<title>Receitas</title>
		
		<style>
			body{
				padding: 20px;
			}
		</style>
	</head>

	<body onload="get('/aula06/receitas/todas', carregarReceitas)">

		<script type="text/javascript">

		function get(url, callback){
		   
			var ajaxReq = new XMLHttpRequest();

			ajaxReq.onreadystatechange = function() {
				if (ajaxReq.readyState == 4 && ajaxReq.status == 200) {
					var receitasJson = ajaxReq.responseText;
					callback(receitasJson)
				}
			};
	
			ajaxReq.open("GET", url, true);
			ajaxReq.send();
		   
		}

		function carregarReceitas(receitasJson){
			
			var receitas = JSON.parse(receitasJson);
			
			 var select = document.getElementById("receitas");
			 
			 for (i in receitas) {
				 select.options[select.length] = new Option(receitas[i].titulo, receitas[i].id);
			 }
		     
		}

		function carregarReceita(id){
			
			get('/aula06/receitas/receita?id='+ id, function(receitaJson){
				
				var receita = JSON.parse(receitaJson);
				
				document.getElementById("titulo").innerHTML = receita.titulo;
				document.getElementById("descricao").innerHTML = receita.descricao;
				document.getElementById("ingredientes").innerHTML = receita.ingredientes;
				document.getElementById("preparo").innerHTML = receita.preparo;

				var atributos = document.getElementById("receitaSelecionada").attributes;
				atributos.getNamedItem("style").nodeValue="";
				
			})
		     
		}

		</script>
		
		<h1>Receitas</h1>
		
		<select id="receitas" size="5" style="width: 100%" onChange="carregarReceita(this.value)">
			
		</select>
		
		<br>

		<div id="receitaSelecionada" style="visibility: hidden;"><br>
			<table class="table" border="1" width="100%">
				<tr>
					<td width="20%">Título:</td>
					<td id="titulo"></td>
				</tr>
				<tr>
					<td>Descrição:</td>
					<td id="descricao"></td>
				</tr>
				<tr>
					<td>Ingredientes:</td>
					<td id="ingredientes"></td>
				</tr>
				<tr>
					<td>Preparo:</td>
					<td id="preparo"></td>
				</tr>
			</table>
		</div>
		
		
	</body>
</html>