<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spotify Stats</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<!-- <a href = "./FoodCart"> <label> see food </label> </a> -->
    <!-- Form to send a POST request -->
    <h2>Check your spotify statistics</h2>
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
</html> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spotify Stats</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <!-- Logo na górze po lewej stronie -->
    <div class="logo-container">
        <a href="https://www.spotify.com" target="_blank">
            <img src="images/spotify.png" alt="Spotify Icon" class="logo">
        </a>
    </div>

    <!-- Nagłówek -->
    <div class="header">
        <h1>Check your Spotify Statistics</h1>
    </div>

    <!-- Formularz z przyciskami -->
    <div class="form-container">
        <form action="callback" method="POST">
            <button type="submit" name="key-info" value="my-email">Email</button>
            <button type="submit" name="key-info" value="top-1-track">Top 1 Track</button>
            <button type="submit" name="key-info" value="top-10-tracks">Top 10 Tracks</button>
            <button type="submit" name="key-info" value="recently-played-1-track">Recently Played 1 Track</button>
            <button type="submit" name="key-info" value="recently-played-10-tracks">Recently Played 10 Tracks</button>
            <button type="submit" name="key-info" value="top-1-artist">Top 1 Artist</button>
            <button type="submit" name="key-info" value="top-10-artists">Top 10 Artists</button>
            <button type="submit" name="key-info" value="top-10-genres">Top 10 Genres</button>
            <button type="submit" name="key-info" value="top-25-genres">Top 25 Genres</button>
        </form>
    </div>
</body>
</html>

