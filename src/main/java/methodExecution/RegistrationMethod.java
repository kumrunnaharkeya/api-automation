package methodExecution;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import lib.PostRequest;
import lib.UrlConstants;
import lib.VerificationToken;

public class RegistrationMethod {
	PostRequest postRequest = new PostRequest();
	
	private int sendGet() throws Throwable{
		URL obj = new URL(UrlConstants.Registration.verifyUser+VerificationToken.NewUser.token);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		con.setRequestProperty("token",VerificationToken.NewUser.token );
		int responseCode = con.getResponseCode();
		return responseCode;
	}
	
	
	public int sendPost(HttpURLConnection conn) throws Throwable{
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String urlParameters = "{\"email\": \"dgz66039@dsiay.com\",\"password\": \"1234\",\"redirectUrl\": \"string\"}";
		

		// Send post request
		postRequest.postRequest(conn, urlParameters);
		int responseCode = conn.getResponseCode();
		return responseCode;
		
		/*System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());*/
	}

}
