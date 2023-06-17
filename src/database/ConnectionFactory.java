package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String USERNAME = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PASSWORD = "ZlEobdSuoHG99er7N0ec";
    private static final String DATABASE_NAME = "railway";
    private static final String DATABASE_URL = "jdbc:mysql://containers.railway.app:5815/" + DATABASE_NAME;


    public static Connection createConnectionToMySQL() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }
    
}
