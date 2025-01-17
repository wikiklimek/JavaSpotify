package spotifyTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WebFunctionCalls {
	public void myFunc(HttpServletRequest request, HttpServletResponse response, String str) throws ServletException, IOException ;
}
