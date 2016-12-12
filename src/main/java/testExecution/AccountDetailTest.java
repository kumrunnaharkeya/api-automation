package testExecution;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import lib.UrlConstants;
import methodExecution.AccountDetailMethod;


public class AccountDetailTest {
	
	AccountDetailMethod accountDetailMethod = new AccountDetailMethod();
	PrintOutput printOutput = new PrintOutput();
	final static Logger logger = Logger.getLogger(AccountDetailTest.class);
	
	
	@Test
	public void verifyAccountDetails() throws Throwable {
		
		URL url = new URL(UrlConstants.AccountDetail.accountDetai);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		// get response code
		int i = accountDetailMethod.getAll(conn);
		System.out.println(i);

		if (i == 200) {
			logger.info("OK");
			logger.info(printOutput.scan(conn));
			

		} else if (i == 400) {
			logger.info("Bad Request");
			logger.error(printOutput.errorResponse(conn));

		} else if (i == 401) {
			logger.info("Unauthorized");
			logger.error(printOutput.errorResponse(conn));

		} else if (i == 403) {
			logger.info("Forbidden");
			logger.error(printOutput.errorResponse(conn));
		}
		else{
			logger.info(i);
			logger.error(printOutput.errorResponse(conn));
		}
	}

}
