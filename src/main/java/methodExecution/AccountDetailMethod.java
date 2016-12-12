package methodExecution;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import lib.UrlConstants;
import lib.VerificationToken;

public class AccountDetailMethod {
	public int getAll(HttpURLConnection conn) throws Throwable{
		
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("authorization", VerificationToken.AuthToken.token);
		int i = conn.getResponseCode();
		/*System.out.println(conn.getResponseCode());*/
		return i;
	}

}
