<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Número Aleatório</title>
</head>
<body>

Essa página gera um novo número aleatório toda vez que é acessada: <%= Math.random() %>
</br>

<h1>Id da sessão do usuário: <%= session.getId() %></h1>
<%! int a = 10; %>

Temos aqui os resultados: </br>

<% for(int i=0; i<10; i++){%>
<h1> <%= i*a %> </h1>
<%} %>

</body>
</html>