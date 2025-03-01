package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import config.DatabaseConfig;

public class MySQLConnection {
    public static Connection getResidentConnection() throws SQLException {
        return DriverManager.getConnection(DatabaseConfig.getDbResidentUrl(), DatabaseConfig.getAdmin(), DatabaseConfig.getPassAdmin());
    }
}