<%@page import = "models.Genre" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<Genre> genres = (ArrayList<Genre>) session.getAttribute("genres");
    	request.setAttribute("list", genres);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>"${title}"</title>
</head>
<body>
<h2>${title}</h2>
<c:forEach var="genre" items = "${list}">
	<tr>
		<td><p><c:out value="${genre.topNumber}"/>.<c:out value="${genre.name}"/></p></td>
	</tr>
</c:forEach>
</body>
</html>