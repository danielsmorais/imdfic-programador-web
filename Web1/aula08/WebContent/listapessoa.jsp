<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<body>
		<strong>Lista de pessoass:</strong>
		<%
		request.setAttribute("pessoas", new String[] {"joao", "maria", "joaquim", "Luana", "eduardo"});
		%>
		<br><br>
		<table>
			<c:forEach var="pessoa" items="${pessoas}" varStatus="status">
				<c:choose>
					<c:when test="${status.index % 2 == 0}">
						<c:set var="bgColor" value="GRAY" />
					</c:when>
					<c:otherwise>
						<c:set var="bgColor" value="WHITE" />
					</c:otherwise>
				</c:choose>
				<tr bgcolor="<c:out value="${bgColor}"/>">
					<td><c:out value="${pessoa}" /></td>
                </tr>
			</c:forEach>
		</table>
	</body>
</html>