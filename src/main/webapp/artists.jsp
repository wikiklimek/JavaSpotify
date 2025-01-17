<%@page import = "models.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<Artist> artists = (ArrayList<Artist>) session.getAttribute("artists");
    	request.setAttribute("list", artists);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>"${title}"</title>
</head>
<body>
<h2>${title}</h2>
<c:forEach var="artist" items = "${list}">
	<tr>
		<td><p><c:out value="${artist.topNumber}"/>. <c:out value="${artist.name}"/></p></td>
		<td><p style="text-indent: 20px;">Popularity: <c:out value="${artist.popularity}%"/></p></td>
		<td><p style="text-indent: 20px;">Genres: </p></td>
		<td>
			<c:forEach var="genre" items = "${artist.genres}">
				<tr>
					<td><p style="text-indent: 40px;"><c:out value="${genre}"/></p></td>
				</tr>
			</c:forEach>
		</td>
	</tr>
</c:forEach>
</body>
</html>