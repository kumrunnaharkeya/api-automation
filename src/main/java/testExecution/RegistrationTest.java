package testExecution;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import lib.UrlConstants;
import methodExecution.RegistrationMethod;

public class RegistrationTest {

	RegistrationMethod registrationMethod = new RegistrationMethod();
	PrintOutput printOutput = new PrintOutput();
	final static Logger logger = Logger.getLogger(RegistrationTest.class);

	@Test(enabled=false)
	public void createUser() throws Throwable {
		URL url = new URL(UrlConstants.Registration.createUser);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		int i = registrationMethod.sendPost(conn);
		if (i == 201) {
			logger.info("user created");
			System.out.println(printOutput.scan(conn));
		} else if (i == 400) {
			logger.info("Bad Request");
			logger.error(printOutput.errorResponse(conn));

		} else if (i == 409) {
			logger.info("Conflict");
			logger.error(printOutput.errorResponse(conn));
		}else{
			logger.info(i);
			logger.error(printOutput.errorResponse(conn));
		}

	}

	@Test(enabled=true)
	public void verifyUser() throws Throwable {
		URL url = new URL(UrlConstants.Registration.createUser);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		int i = registrationMethod.sendPost(conn);
		if (i == 200) {
			System.out.println("OK");
			System.out.println(printOutput.scan(conn));
		} else if (i == 400) {
			System.out.println("Bad Request");
			System.out.println(printOutput.errorResponse(conn));

		} else if (i == 404) {
			System.out.println("Not Found");
			System.out.println(printOutput.errorResponse(conn));
		}else{
			logger.info(i);
			System.out.println(printOutput.errorResponse(conn));
		}

	}
}
