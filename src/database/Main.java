package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao("127.0.0.1", "3306", "filmes", "root", "@ab1#cd2");
        conexao.Conecta();
        conexao.ExecuteQuery("select * from filmes");
        try {
            while(conexao.getResultSet().next()){
                System.out.println(conexao.getResultSet().getString("titulo"));
                
            }
        } catch (SQLException e) {
          
            e.printStackTrace();
        }



        try {  
            PreparedStatement stmt =conexao.getConnection().prepareStatement("INSERT INTO filmes(codigo,titulo,genero,produtora,datacompra) VALUES(?,?,?,?,?)");
            stmt.setString(1, "030");  
            stmt.setString(2, "um filme ai");  
            stmt.setString(3, "gene");  
            stmt.setString(4, "uma");  
            stmt.setDate(5, new java.sql.Date(new Date().getTime()));
            stmt.execute();  
            stmt.close();  

        } catch (SQLException u) {  
            throw new RuntimeException(u);  
    } 

        conexao.ExecuteQuery("select * from filmes");
        try {
            while(conexao.getResultSet().next()){
                System.out.println(conexao.getResultSet().getString("titulo"));
                
            }
        } catch (SQLException e) {
          
            e.printStackTrace();
        }
        conexao.Desconecta();
    }
    
}
