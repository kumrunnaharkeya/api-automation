package lib;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;

public class PostRequest {
	public DataOutputStream postRequest(HttpURLConnection conn, String urlParameters) throws Throwable {
		// Send post request
		conn.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
		return wr;

	}
}
