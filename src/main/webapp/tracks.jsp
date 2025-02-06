<%@page import = "models.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	List<Track> tracks = (ArrayList<Track>) session.getAttribute("tracks");
    	request.setAttribute("list", tracks);
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
<c:forEach var="track" items = "${list}">
	<tr>
		<td><p><c:out value="${track.topNumber}"/>. <c:out value="${track.name}"/></p></td>
		<td><p style="text-indent: 20px;">Album: <c:out value="${track.album.name}"/></p></td>
		<td><p style="text-indent: 20px;">Artists: </p></td>
		<td>
			<c:forEach var="artist" items = "${track.artists}">
				<tr>
					<td><p style="text-indent: 40px;"><c:out value="${artist.name}"/></p></td>
				</tr>
			</c:forEach>
		</td>
	</tr>
</c:forEach>
<a href="index.jsp">
        <button class="redirect-button">Check other statistics</button>
    </a>
</body>
</html>
