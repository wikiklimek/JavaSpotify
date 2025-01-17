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
<title>"${title}"</title>
</head>
<body>
<h2>${title}</h2>
<p>Email: <c:out value="${user.email}"/></p>
<p>Name: <c:out value="${user.displayName}"/></p>
</body>
</html>