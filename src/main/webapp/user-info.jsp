<%@page import = "models.*" %>
<%@page import = "java.util.List" %>
<%@page import = "java.util.ArrayList" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	UserProfile user = (UserProfile) session.getAttribute("user");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="logo-container">
        <img src="images/spotify.png" alt="Spotify Logo" class="logo">
    </div>
    <div class="info-container">
        <h2>Your email:</h2>
        <p class="info"><c:out value="${user.email}"/></p>
        <h2>Your name:</h2>
        <p class="info"><c:out value="${user.displayName}"/></p>
    </div>
    <a href="index.jsp">
        <button class="redirect-button">Check other statistics</button>
    </a>
</body>
</html>
