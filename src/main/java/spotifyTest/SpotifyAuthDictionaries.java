package spotifyTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.*;
import spotify.SpotifyCallbackRedirectFunctions;

//Controller: Coordinates between the model and view
public class SpotifyAuthDictionaries {
private final SpotifyAuthModel model;
private final Map<String, WebFunctionCalls> dictionaryFunctions;
private final Map<String, String> dictionaryScopes;

public SpotifyAuthDictionaries(SpotifyAuthModel model, SpotifyCallbackRedirectFunctions redirectFunctions) {
   this.model = model;
   
   dictionaryFunctions = new HashMap<String, WebFunctionCalls>();
   dictionaryFunctions.put("my-email", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException 
	   {
		   UserProfile user = model.getUserEmail(str);
		   redirectFunctions.redirrectToViewUserInfo(request, response,"User Info" , user);
	   }
   });
   dictionaryFunctions.put("top-1-track", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException  
	   {
		  List<Track> tracks = model.getTop1PlayedTrack(str);
		  redirectFunctions.redirrectToViewTracks(request, response,"Top 1 Track" , tracks);
	   }
   });
   dictionaryFunctions.put("recently-played-1-track", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException 
	   {
		   List<Track> tracks = model.get1RecentlyPlayedTrack(str);
		   redirectFunctions.redirrectToViewTracks(request, response, "Recently Played Track", tracks);
	   }
   });
   dictionaryFunctions.put("top-1-artist", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException  
	   {
		   List<Artist> artists = model.getTop1Artist(str);
		   redirectFunctions.redirrectToViewArtists(request, response,"Top 1 Artist", artists);
	   }
   });
   dictionaryFunctions.put("top-10-tracks", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException  
	   {
		   List<Track> tracks = model.getTop10PlayedTracks(str);
		   redirectFunctions.redirrectToViewTracks(request, response,"Top 10 Track" ,  tracks);
	   }
   });
   dictionaryFunctions.put("top-10-artists", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException  
	   {
		   List<Artist> artists = model.getTop10Artists(str);
		   redirectFunctions.redirrectToViewArtists(request, response, "Top 10 Artist", artists);
	   }
   });
   dictionaryFunctions.put("recently-played-10-tracks", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException  
	   {
		   List<Track> tracks = model.get10RecentlyPlayedTracks(str);
		   redirectFunctions.redirrectToViewTracks(request, response, "10 Recently Played Tracks", tracks);
	   }
   });
   dictionaryFunctions.put("top-10-genres", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException  
	   {
		   List<Genre> genres = model.getTop10Genres(str);
		   redirectFunctions.redirrectToViewGenres(request, response, "Top 10 Genres", genres);
	   }
   });
   dictionaryFunctions.put("top-25-genres", new WebFunctionCalls() 
   {
	   public void myFunc (HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException  
	   {
		   List<Genre> genres = model.getTop25Genres(str);
		   redirectFunctions.redirrectToViewGenres(request, response,"Top 25 Genres", genres);
	   }
   });
   
   
   
   dictionaryScopes = new HashMap<String, String>();
   dictionaryScopes.put("my-email", "user-read-email");
   dictionaryScopes.put("top-1-track", "user-top-read");
   dictionaryScopes.put("recently-played-1-track", "user-read-recently-played");
   dictionaryScopes.put("top-1-artist", "user-top-read");
   dictionaryScopes.put("top-10-tracks", "user-top-read");
   dictionaryScopes.put("top-10-artists", "user-top-read");
   dictionaryScopes.put("recently-played-10-tracks", "user-read-recently-played");
   dictionaryScopes.put("top-10-genres", "user-top-read");
   dictionaryScopes.put("top-25-genres", "user-top-read");
}

public String getScope(String info_to_get)
{
	return dictionaryScopes.get(info_to_get);
}

public void getInfo(String authorizationCode, String info_to_get, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	try
	{
		String accessToken = model.getAccessTokenAuthorisation(authorizationCode);
		dictionaryFunctions.get(info_to_get).myFunc(request, response, accessToken);
	}
	catch(IOException exc){}
}



}