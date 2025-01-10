<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "./FoodCart"> <label> see food </label> </a>
    <!-- Form to send a POST request -->
    <h2>Send a POST Request</h2>
    <form action="callback" method="POST">
        <label for="key-info">Select your Action:</label>
	    <select id="key-info" name="key-info">
	        <option value="my-email">Email</option>
	        <option value="top-1-track">Top 1 Track</option>
	        <option value="recently-played-1-track">Recently Played 1 Track</option>
	        <option value="top-1-artist">Top 1 Artist</option>
	        <option value="top-10-tracks">Top 10 Tracks</option>
	        <option value="top-10-artists">Top 10 Artists</option>
	        <option value="recently-played-10-tracks">Recently Played 10 Tracks</option>
	        <option value="top-10-genres">Top 10 Genres</option>
	        <option value="top-25-genres">Top 25 Genres</option>
	    </select>
        <button type="submit">Send POST Request</button>
    </form>
    
    
</body>
</html>