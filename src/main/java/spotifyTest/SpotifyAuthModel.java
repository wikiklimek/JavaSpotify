package spotifyTest;

import helpers.*;
import models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SpotifyAuthModel extends SpotifyPaths {
 
private String getAccessToken(String body) throws IOException
{
	 URL url = new URL(TOKEN_URL);
	 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	 connection.setRequestMethod("POST");
	 connection.setDoOutput(true);
	   
	 try (OutputStream os = connection.getOutputStream()) {
         byte[] input = body.getBytes(StandardCharsets.UTF_8);
         os.write(input, 0, input.length);
     }
     
         String jsonResponse = readResponseStringFromConnection(connection);
         TokenResponse token_response = new TokenResponse();
         ObjectMapper mapper = new ObjectMapper();
         
         try 
	     {
        	 token_response = mapper.readValue(jsonResponse, TokenResponse.class);
	     }
	     catch(IOException e)
	     {
	         System.out.println(e.getMessage());
	     }
	     
         return token_response.getAccessToken();
	    
}
 public String getAccessTokenAuthorisation(String authorizationCode) throws IOException {
     return getAccessToken(getAccessTokenAuthorisationBody(authorizationCode));   
 }
 
 public String getAccessTokenNoAuthorisation() throws IOException {
	    return getAccessToken(getAccessTokenNoAuthorisationBody());
	}

 
 private String readResponseStringFromConnection(HttpURLConnection connection) throws IOException
 {
	 try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	        StringBuilder response = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            response.append(line);
	        }
	        
	        return response.toString();
	    }
 }
 
private String getResponseString(String stringURL, String accessToken) throws IOException
{
	URL url = new URL(stringURL);
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Authorization", "Bearer " + accessToken);

    return readResponseStringFromConnection(connection);
}
 
 public String getUserEmail(String accessToken) throws IOException {

	 try {
	    	
	     String jsonResponse = getResponseString(USER_INFO_URL, accessToken);
	     
	     ObjectMapper mapper = new ObjectMapper();
	     UserProfile user_profile = new UserProfile();
	     
	     try 
	     {
	    	 user_profile = mapper.readValue(jsonResponse, UserProfile.class);
	     }
	     catch(IOException e)
	     {
	         System.out.println(e.getMessage());
	     }
	     
	     StringBuilder my_info = new StringBuilder();
	     my_info.append("email: ");
	     my_info.append(user_profile.getEmail());
	     
	     return my_info.toString();
	     
     }
	 catch(IOException e)
	 {
		 System.out.println(e.getMessage());
		 return e.getMessage();
	 }
 }
 
 public String getTop1PlayedTrack(String accessToken) throws IOException {
	    return getTopPlayedTracks(accessToken, "?limit=1");
	}
 
 public String getTop10PlayedTracks(String accessToken) throws IOException {
	    return getTopPlayedTracks(accessToken, "?limit=10");
	}
 
 private String getTopPlayedTracks(String accessToken, String limit) throws IOException {
	 try
	 {
	    List<Track> tracks = getTopPlayedTracksList(accessToken, limit);
	        
	    StringBuilder my_info = new StringBuilder();
	    for(Track track : tracks)
	    {
		    my_info.append("name: ");
		    my_info.append(track.getName());
		    my_info.append("\nalbum: ");
		    my_info.append(track.getAlbum().getName());
		        
		    my_info.append("\nartists: ");
		    for(Artist artist : track.getArtists())
		    {
		        my_info.append("\n name: ");
				my_info.append(artist.getName());
		    }
		    my_info.append("\n\n");
	    }
	        
	    return my_info.toString();
	   }
	   catch(IOException e)
	   {
		   System.out.println(e.getMessage());
		  	return e.getMessage();
		}
	}
 
 public String get1RecentlyPlayedTrack(String accessToken) throws IOException {
	 return getRecentlyPlayedTracks(accessToken, "?limit=1");
 }
 
 public String get10RecentlyPlayedTracks(String accessToken) throws IOException {
	 return getRecentlyPlayedTracks(accessToken, "?limit=10");
 }
 
 private String getRecentlyPlayedTracks(String accessToken, String limit) throws IOException {

	    String recentlyPlayedURL = RECENTLY_PLAYED_URL + limit;

	    try {
	    	
	    	String jsonResponse = getResponseString(recentlyPlayedURL, accessToken);
	    	StringBuilder my_info = new StringBuilder();
	    	
	    	ObjectMapper mapper = new ObjectMapper();
	        SpotifyRecentlyResponse spotify_response = new SpotifyRecentlyResponse();
	        
	        try 
	        {
	        	spotify_response = mapper.readValue(jsonResponse, SpotifyRecentlyResponse.class);
	        }
	        catch(IOException e)
	        {
	        	System.out.println(e.getMessage());
	        }
	        
	        for(RecentlyItem item : spotify_response.getItems())
	        {
	        	Track track = item.getTrack();
	        	 my_info.append("name: ");
			     my_info.append(track.getName());
			     my_info.append("\nalbum: ");
			     my_info.append(track.getAlbum().getName());
			        
			     my_info.append("\nartists: ");
			     for(Artist artist : track.getArtists())
			     {
			         my_info.append("\n name: ");
					 my_info.append(artist.getName());
			     }
			     my_info.append("\n\n");
	        }
	        return my_info.toString();
	        
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e.getMessage());
	    	return e.getMessage();
	    }
	}
 
 public String getTop10Artists(String accessToken) throws IOException {
	 return getTopArtists(accessToken, "?limit=10");
 }
 
 public String getTop1Artist(String accessToken) throws IOException {
	 return getTopArtists(accessToken, "?limit=1");
	}
 
 private String getTopArtists(String accessToken, String limit) throws IOException {
	    try {
	    	List<Artist> topArtistList = getTopArtistsList(accessToken, limit);
	        StringBuilder my_info = new StringBuilder();
	        for(Artist artist : topArtistList)
	        {
		        my_info.append("name: ");
		        my_info.append(artist.getName());
		        my_info.append("\ngenres: ");
		        my_info.append(artist.getGenres());
		        my_info.append("\n\n");
	        }
	        
	        return my_info.toString();
	        
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e.getMessage());
	    	return e.getMessage();
	    }
	}
 
 private Map<String, Integer> getTopGenresMap(String accessToken) throws IOException {
	    try {
	    	List<Artist> topArtistList = getTopArtistsList(accessToken, "?limit=50");
	    	List<Track> topTrackList = getTopPlayedTracksList(accessToken, "?limit=50");
	    	Map<String, Integer> genres = new HashMap<String, Integer>();
	    	
	        //tutaj dla kazdego tracks dla kazdego artist trzeba zbrac info o gatunkach
	        String accessTokenArtist = getAccessTokenNoAuthorisation();
	        for(Track track : topTrackList)
	        	for(Artist artist_incomplete : track.getArtists())
	        	{
	        		Artist artist_complete = getArtistByID(accessTokenArtist, artist_incomplete.getId());
	        		
	        		//every artist once
	        		/*
	        		if(!topArtistList.stream().anyMatch(a -> a.getId().equals(artist_complete.getId())))
	        		{
	        			topArtistList.add(artist_complete);
	        		}
	        		*/
	        		
	        		//duplicate artists
	        		topArtistList.add(artist_complete);
	        	}
	        
	        for(Artist artist : topArtistList)
	        	for(String genre : artist.getGenres())
		        {
			        if(genres.containsKey(genre))
			        {
			        	genres.put(genre, genres.get(genre) + 1);
			        }
			        else
			        {
			        	genres.put(genre, 1);
			        }
	        		
		        }
	        
	        
	        return genres;
	        
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e.getMessage());
	    	return new HashMap<String, Integer>();
	    }
	}
 
 public String getTop10Genres(String accessToken) throws IOException {
	 return getTopGenres(accessToken, 10);
 }
 
 public String getTop25Genres(String accessToken) throws IOException {
	 return getTopGenres(accessToken, 25);
 }
 
 private String getTopGenres(String accessToken, int limit) throws IOException {
	 Map<String, Integer> map_genres_unsorted = getTopGenresMap(accessToken);
	 Map<String, Integer> map_genres = Sort.sortByValue(map_genres_unsorted);
	 List<String> list_genres = new ArrayList<String>(map_genres.keySet());
	 
	 for (var entry : map_genres.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
	}
	 
	 StringBuilder my_info = new StringBuilder();
	 my_info.append("Top ");
	 my_info.append(limit);
	 my_info.append(" Genres\n");
	 for(int i = 0; i< Math.min(limit, list_genres.size()); i++)
	 {
		 my_info.append(i + 1);
		 my_info.append(". ");
		 my_info.append(list_genres.get(i));
		 my_info.append('\n');
	 }
	 
	 return my_info.toString();
 }
 
 private List<Artist> getTopArtistsList(String accessToken, String limit) throws IOException {
	    String topArtistsURL = TOP_ARTISTS_URL + limit;

	    try {
	    	
	    	String jsonResponse = getResponseString(topArtistsURL, accessToken);
	    	
	        ObjectMapper mapper = new ObjectMapper();
	        SpotifyTopResponseArtist spotify_response = new SpotifyTopResponseArtist();
	        
	        try 
	        {
	        	spotify_response = mapper.readValue(jsonResponse, SpotifyTopResponseArtist.class);
	        }
	        catch(IOException e)
	        {
	        	System.out.println(e.getMessage());
	        }
	        
	        
	        return spotify_response.getItems();
	        
	        
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e.getMessage());
	    	return new ArrayList<Artist>();
	    }
	}
 
 private List<Track> getTopPlayedTracksList(String accessToken, String limit) throws IOException {

	    String topTracksURL = TOP_TRACKS_URL + limit;
	    
	    try {
	    	
	    	String jsonResponse = getResponseString(topTracksURL, accessToken);
	    	
	        ObjectMapper mapper = new ObjectMapper();
	        SpotifyTopResponseTrack spotify_response = new SpotifyTopResponseTrack();
	        
	        try 
	        {
	        	spotify_response = mapper.readValue(jsonResponse, SpotifyTopResponseTrack.class);
	        }
	        catch(IOException e)
	        {
	        	System.out.println(e.getMessage());
	        }
	        
	        
	        return spotify_response.getItems();
	        
	    }
	    catch(IOException e)
		{
	    	System.out.println(e.getMessage());
		  	return new ArrayList<Track>();
		}
	}
 
 private Artist getArtistByID(String accessToken, String id) throws IOException {
	    String artistsURL = ARTISTS_URL + id;

	    try {
	    	
	    	String jsonResponse = getResponseString(artistsURL, accessToken);
	    	
	        ObjectMapper mapper = new ObjectMapper();
	        Artist artist = new Artist();
	        
	        try 
	        {
	        	artist = mapper.readValue(jsonResponse, Artist.class);
	        }
	        catch(IOException e)
	        {
	        	System.out.println(e.getMessage());
	        }
	        
	        
	        return artist;
	        
	        
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e.getMessage());
	    	return new Artist();
	    }
	}
 
 public Track getTrackByID(String accessToken, String id) throws IOException {
	    String tracksURL = TRACKS_URL + id;

	    try {
	    	
	    	String jsonResponse = getResponseString(tracksURL, accessToken);
	    	
	        ObjectMapper mapper = new ObjectMapper();
	        Track track = new Track();
	        
	        try 
	        {
	        	track = mapper.readValue(jsonResponse, Track.class);
	        }
	        catch(IOException e)
	        {
	        	System.out.println(e.getMessage());
	        }
	        
	        
	        return track;
	        
	        
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e.getMessage());
	    	return new Track();
	    }
	}
 
}



