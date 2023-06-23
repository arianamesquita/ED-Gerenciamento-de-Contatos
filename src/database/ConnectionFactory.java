package database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 
 * nosso connector está na pasta lib já, na versão do MySQL 8.0.31, se sua versão for outra tem que alterar lá para rodar
 * 
 */
public class ConnectionFactory {

    private static final String USERNAME = "root"; // nome de usuário - precisa trocar para rodar no seu
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PASSWORD = "Peheje5u$"; // senha do usuário - precisa trocar para rodar no seu
    private static final String DATABASE_NAME = "railway"; // nome do banco de dados, precisa ser esse no seu
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/" + DATABASE_NAME; 
                        // precisa mudar para a sua porta se estiver usando outra aqui no database_url


    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName(DRIVER);
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }

}
