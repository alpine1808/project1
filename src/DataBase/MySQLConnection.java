package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    private static final String DB_URL = "jdbc:mysql://project1-project1-software-test.d.aivencloud.com:21020/defaultdb?useSSL=true&requireSSL=true";
    private static final String USER = "avnadmin";
    private static final String PASS = "AVNS_iAKL8E3UsZND4X4LBOF";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}