package testExecution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class PrintOutput {
	public String scan(HttpURLConnection conn) throws Throwable{
		
		BufferedReader in = new BufferedReader(
		new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		/*System.out.println(response.toString());*/
		return response.toString();
		
	}
	
public String errorResponse(HttpURLConnection conn) throws Throwable{
		
	BufferedReader in = new BufferedReader(
			new InputStreamReader(conn.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			/*System.out.println(response.toString());*/
			return response.toString();
		
	}

}
