package spotifyTest;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public abstract class SpotifyPaths {
	protected static final String CLIENT_ID = "d5a36d2fb4ab4c97b1242436455b6e3c";
	protected static final String CLIENT_SECRET = "6380e1c56f794e2da495c6bf3e44977f";
	protected static final String REDIRECT_URI = "http://localhost:8080/WebAppTest1/callback";
	protected static final String AUTHORIZATION_URL = "https://accounts.spotify.com/authorize";
	protected static final String TOKEN_URL = "https://accounts.spotify.com/api/token";
	protected static final String USER_INFO_URL = "https://api.spotify.com/v1/me";
	protected static final String TRACKS_URL = "https://api.spotify.com/v1/tracks/";
	protected static final String ARTISTS_URL = "https://api.spotify.com/v1/artists/";
	protected static final String TOP_TRACKS_URL = "https://api.spotify.com/v1/me/top/tracks";
	protected static final String TOP_ARTISTS_URL ="https://api.spotify.com/v1/me/top/artists";
	protected static final String RECENTLY_PLAYED_URL = "https://api.spotify.com/v1/me/player/recently-played";
	
	public static String getAuthorizationUrl(String scope) {
		 String state = UUID.randomUUID().toString();
	     return AUTHORIZATION_URL + "?response_type=code" +
	            "&client_id=" + CLIENT_ID +
	            "&scope=" + URLEncoder.encode(scope, StandardCharsets.UTF_8) +
	            "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8) +
	            "&state=" + state;
	 }
	
	protected static String getAccessTokenAuthorisationBody(String authorizationCode)
	{
		return "grant_type=authorization_code" +
                "&code=" + authorizationCode +
                "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8) +
                "&client_id=" + CLIENT_ID +
                "&client_secret=" + CLIENT_SECRET;
	}
	
	protected static String getAccessTokenNoAuthorisationBody()
	{
		return "grant_type=client_credentials" +
                "&client_id=" + CLIENT_ID +
                "&client_secret=" + CLIENT_SECRET;
	}
}
