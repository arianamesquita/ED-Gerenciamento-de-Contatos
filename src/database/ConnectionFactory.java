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



    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName(DRIVER);
        return DriverManager . getConnection (
  "jdbc:mysql://aws.connect.psdb.cloud/gerenciamentocontatos" ,
  "o8jpkz82igyfispi96rk" ,
  "pscale_pw_cP6v7B3g44j911IXCH4USCDsCmO4zu1IzYZ3499Ji5U" );

    }

}
