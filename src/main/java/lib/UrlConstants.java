package lib;

public class UrlConstants {
	//user registration api
	public static class Registration{
		public static final String createUser ="http://localhost:8081/ec-auth/accounts";
		public static final String verifyUser ="http://localhost:8081/ec-auth/accounts/verify?token=";
	}
	
	//return account detail api
	public static class AccountDetail{
		public static final String accountDetai ="http://localhost:8081/ec-auth/accounts";
	}

}
