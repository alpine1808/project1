package config;

public class DatabaseConfig {
	private static final String DB_RESIDENT_URL = "jdbc:mysql://project1-project1-software-test.d.aivencloud.com:21020/defaultdb?useSSL=true&requireSSL=true";
    private static final String ADMIN = "avnadmin";
    private static final String PASS_ADMIN = "AVNS_iAKL8E3UsZND4X4LBOF";
	public static String getDbResidentUrl() {
		return DB_RESIDENT_URL;
	}
	public static String getAdmin() {
		return ADMIN;
	}
	public static String getPassAdmin() {
		return PASS_ADMIN;
	}
}
