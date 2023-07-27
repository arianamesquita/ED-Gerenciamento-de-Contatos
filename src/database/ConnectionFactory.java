package database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 
 * nosso connector está na pasta lib já, na versão do MySQL 8.0.31, se sua versão for outra tem que alterar lá para rodar
 * 
 */
public class ConnectionFactory {

  
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_STRING ="jdbc:mysql://aws.connect.psdb.cloud/gerenciamentocontatos";
    private static final String USER = "usgf19luqniwgcv5uvb7";
    private static final String PASSWORD ="pscale_pw_A"+"P8zyMIsxZ"+"EVS4gsPbE8"+"p105P4GiYn51G"+"QAJZAwH1GX";



    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName(DRIVER);
        return DriverManager . getConnection (URL_STRING,USER,PASSWORD);

    }

}
