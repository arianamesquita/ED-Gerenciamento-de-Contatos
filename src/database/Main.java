package database;

import java.sql.Date;

import controller.ContatoController;
import controller.FiltroController;
import database.createList.DoublyLinkedLists.ContatoList;
import database.createList.DoublyLinkedLists.ContControlList;
import database.createList.NOs.ContatoNO;

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
    //Categoria categoria = new Categoria(11, "melhores amigos");
    //novoNome.save(categoria);
    //novoNome.Listar();

    PessoaDAO pessoaDAO = new PessoaDAO();
    String str = "1992-07-10";
    Date date = Date.valueOf(str);
    //Pessoa pessoa = new Pessoa("Hayana", 13, "17996966699", "hayeva@teste.com", date);
    //pessoaDAO.save(pessoa);
    //pessoaDAO.Listar();

    ContatoDao novoContato = new ContatoDao();
    ContatoList contatoList = novoContato.Listar();
    //Contato contato = new Contato(1, novoNome, pessoa);
    //novoContato.save(contato);
    //contatoList.imprimir();
    ContControlList contatos = new ContControlList();
    ContatoNO atual = contatoList.getInicio();
    //contatos.imprimir();

    while(atual!=null){
        contatos.InsereNoFim(new ContatoController(atual.getContato()));
        atual = atual.getProximo();
    }

    //contatos.imprimir();

    FiltroController filtro = new FiltroController();

    filtro.quickSort(contatos);

    contatos.imprimir();
    



    /*List<Pessoa> lista;
    lista = pessoaDAO.Listar();
    System.out.println(lista);*/

    }
}
