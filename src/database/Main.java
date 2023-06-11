package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.sql.Date;
import java.util.List;

import model.Categoria;
import model.Pessoa;

public class Main {
    public static void main(String[] args) {
/*        Conexao conexao = new Conexao("127.0.0.1", "3306", "gerenciamentocontatos",
                                             "root", "@ab1#cd2");
        conexao.Conecta();
      conexao.ExecuteQuery("select * from filmes");
        try {
            while (conexao.getResultSet().next()) {
                System.out.println(conexao.getResultSet().getString("titulo"));

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        try {
            PreparedStatement stmt = conexao.getConnection().prepareStatement(
                    "INSERT INTO filmes(codigo,titulo,genero,produtora,datacompra) VALUES(?,?,?,?,?)");
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
            while (conexao.getResultSet().next()) {
                System.out.println(conexao.getResultSet().getString("titulo"));

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        conexao.Desconecta();
    }*/

    CategoriaDAO novoNome = new CategoriaDAO();
    /*Categoria categoria = new Categoria(1, "amigos");
    novoNome.save(categoria);*/

    PessoaDAO pessoaDAO = new PessoaDAO();
    String str = "1985-10-07";
    Date date = Date.valueOf(str);
    Pessoa pessoa = new Pessoa("Ariana Mesquita", 1, "62993469911", "arianamesk@gmail.com", date);
    pessoaDAO.save(pessoa);

    List<Pessoa> lista;
    lista = pessoaDAO.Listar();
    System.out.println(lista);

    }
}
