package spotifyTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Controller: Coordinates between the model and view
public class SpotifyAuthDictionaries {
private final SpotifyAuthModel model;
private final Map<String, WebFunctionCalls> dictionaryFunctions;
private final Map<String, String> dictionaryScopes;

public SpotifyAuthDictionaries(SpotifyAuthModel model) {
   this.model = model;
   dictionaryFunctions = new HashMap<String, WebFunctionCalls>();
   dictionaryFunctions.put("my-email", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.getUserEmail(str);}
   });
   dictionaryFunctions.put("top-1-track", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.getTop1PlayedTrack(str);}
   });
   dictionaryFunctions.put("recently-played-1-track", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.get1RecentlyPlayedTrack(str);}
   });
   dictionaryFunctions.put("top-1-artist", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.getTop1Artist(str);}
   });
   dictionaryFunctions.put("top-10-tracks", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.getTop10PlayedTracks(str);}
   });
   dictionaryFunctions.put("top-10-artists", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.getTop10Artists(str);}
   });
   dictionaryFunctions.put("recently-played-10-tracks", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.get10RecentlyPlayedTracks(str);}
   });
   dictionaryFunctions.put("top-10-genres", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.getTop10Genres(str);}
   });
   dictionaryFunctions.put("top-25-genres", new WebFunctionCalls() 
   {
	   public String myFunc (String str) throws IOException {return model.getTop25Genres(str);}
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

public String getInfo(String authorizationCode, String info_to_get) throws IOException
{
	try
	{
		String accessToken = model.getAccessTokenAuthorisation(authorizationCode);
		String resp =  dictionaryFunctions.get(info_to_get).myFunc(accessToken);
		return resp;
	}
	catch(IOException exc)
	{
		return " ";
	}
}



}