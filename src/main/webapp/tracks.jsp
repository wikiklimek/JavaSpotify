<%@page import = "models.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
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
</body>
</html>