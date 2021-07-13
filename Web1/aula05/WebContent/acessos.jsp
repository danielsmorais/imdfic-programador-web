<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Número Aleatório</title>
</head>
<body>
	<% aula05.Contador.novoAcesso(); %>
	Quantidade de acessos a essa página: <%= aula05.Contador.getQuantidadeAcessos() %>
	
	</br>
	<% int cont = 1; %>
	Este é o acesso de número: <%= cont %>
	<% cont = cont + 1; %>
</body>
</html>