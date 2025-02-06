package spotify;
import spotifyTest.*;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.*;

public class SpotifyCallbackRedirectFunctions {
	public void redirrectToViewGenres(HttpServletRequest request, HttpServletResponse response, String title, List<Genre> genres) throws ServletException, IOException 
	{
    	HttpSession hs = request.getSession();
    	hs.setAttribute("title", title);
    	hs.setAttribute("genres", genres);
    	response.sendRedirect("genres.jsp");
    }
    
    public void redirrectToViewTracks(HttpServletRequest request, HttpServletResponse response, String title, List<Track> tracks) throws ServletException, IOException 
    {
    	HttpSession hs = request.getSession();
    	hs.setAttribute("title", title);
    	hs.setAttribute("tracks", tracks);
    	response.sendRedirect("tracks.jsp");
    }
    
    public void redirrectToViewArtists(HttpServletRequest request, HttpServletResponse response,String title, List<Artist> artists) throws ServletException, IOException 
    {
    	HttpSession hs = request.getSession();
    	hs.setAttribute("title", title);
    	hs.setAttribute("artists", artists);
    	response.sendRedirect("artists.jsp");
    }

    public void redirrectToViewUserInfo(HttpServletRequest request, HttpServletResponse response,String title, UserProfile user) throws ServletException, IOException 
    {
    	HttpSession hs = request.getSession();
    	hs.setAttribute("title", title);
    	hs.setAttribute("user", user);
    	response.sendRedirect("user-info.jsp");
    }
    
    public void redirrectToViewShows(HttpServletRequest request, HttpServletResponse response,String title, List<Show> shows) throws ServletException, IOException 
    {
    	HttpSession hs = request.getSession();
    	hs.setAttribute("title", title);
    	hs.setAttribute("shows", shows);
    	response.sendRedirect("saved-shows.jsp");
    }
    
    public void redirrectToViewEpisodes(HttpServletRequest request, HttpServletResponse response,String title, List<Episode> episodes) throws ServletException, IOException 
    {
    	HttpSession hs = request.getSession();
    	hs.setAttribute("title", title);
    	hs.setAttribute("episodes", episodes);
    	response.sendRedirect("saved-episodes.jsp");
    }
}
