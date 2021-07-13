<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Cadastrar novo encontro</title>
	</head>
	<body>
		<h3>Cadastrar novo encontro:</h3>
		<form action="ServletControlador" method="post">
		<input type="hidden" name="acao" value="confirmarCadastro"/>
		Nome: <input type="text" name="nomePessoa" value=""/><br>
		Local: <input type="text" name="local" value=""/><br>
		Motivo: <input type="text" name="motivo" value=""/><br>
		<input type="submit" value="Registrar encontro"/><br>
		</form><BR><BR>
		<a href="ServletControlador">Voltar ao menu</a>
	</body>
</html>