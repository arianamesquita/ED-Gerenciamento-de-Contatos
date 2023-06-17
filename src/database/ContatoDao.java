package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.createList.DoublyLinkedLists.CategoriaList;
import database.createList.DoublyLinkedLists.ContatoList;
import database.createList.DoublyLinkedLists.PessoaList;
import model.Contato;
public class ContatoDao {

    public void save(Contato contato){
        String sql = "insert into contatos(id, idPessoa, idCategoria) values (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, contato.getId());
            pstm.setInt(2, contato.getPessoa().getId());
            pstm.setInt(3, contato.getCategoria().getId());

            pstm.execute();

            if (pstm.getUpdateCount()>0) 
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar!");
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void removeById(int id){

        String sql = "Delete from contatos where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

            if (pstm.getUpdateCount()>0) 
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Não foi possível apagar!");
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void update(Contato contato){
        String sql = "Update contatos set categoria = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, contato.getCategoria().getId());

            pstm.execute();

            if (pstm.getUpdateCount()>0) 
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            else
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar!");
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public ContatoList Listar(){
        String sql = "Select * from contatos";
        ContatoList lista = new ContatoList();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Contato contato = new Contato();

                PessoaDAO pessoaDAO = new PessoaDAO();
                CategoriaDAO categoriaDAO = new CategoriaDAO();

                PessoaList pessoaList = pessoaDAO.Listar();
                CategoriaList categoriaList = categoriaDAO.Listar();

                contato = new Contato(rset.getInt("id"), 
                        categoriaList.buscarPorID(rset.getInt("idCategoria")), 
                        pessoaList.buscarPorID(rset.getInt("idPessoa")));
     
                lista.InsereNoFim(contato);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return lista;
    }
    
}
