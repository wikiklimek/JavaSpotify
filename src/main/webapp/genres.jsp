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
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="logo-container">
     <img src="images/spotify.png" alt="Spotify Logo" class="logo">
</div>
<h2>${title}</h2>
<c:forEach var="genre" items = "${list}">
	<tr>
		<td><p><c:out value="${genre.topNumber}"/>.<c:out value="${genre.name}"/></p></td>
	</tr>
</c:forEach>
<a href="index.jsp">
    <button class="redirect-button">Check other statistics</button>
</a>
</body>
</html>