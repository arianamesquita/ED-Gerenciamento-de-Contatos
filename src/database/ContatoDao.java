package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.createList.DoublyLinkedLists.ContatoList;
import database.createList.NOs.ContatoNO;
import model.Categoria;
import model.Contato;

/**
 * inclui algumas coisas, depois q vi q falou q tava pronto, mas acho q ficou bom, desculpa se não..
 * 
 * save --> salva um contato
 * removeById --> deleta através do id qualquer coisa muda pra contato se for melhor
 * update --> atualiza a categoria do contato
 * List --> lista os contatos
 * searchById --> busca o contato através do id
 * geraId --> gerando um id para novo contato
 * 
 */
public class ContatoDao {

    public void save(Contato contato){
        String sql = "insert into contatos(id, idPessoa, idCategoria) values (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, geraId());
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
                JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
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

    public void update(Contato contato, Categoria categoria){
        String sql = "Update contatos set idCategoria = ? where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, categoria.getId());
            pstm.setInt(1, contato.getId());

            pstm.execute();

            if (pstm.getUpdateCount()>0) 
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
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

                contato = new Contato(rset.getInt("id"), 
                        categoriaDAO.searchById(rset.getInt("idCategoria")), 
                        pessoaDAO.searchById(rset.getInt("idPessoa")));
     
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

    public void searchById(int id){

        String sql = "Select * from contatos where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

            if (pstm.getUpdateCount()>0) 
                JOptionPane.showMessageDialog(null, "Encontrado com sucesso!");
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

    public static int geraId() {
        int count = 0;
        ContatoList contatoList =  new ContatoDao().Listar();
        ContatoNO atual = contatoList.getInicio();
        while(atual!= null ){
            if (count < atual.getContato().getId()) {
                count = atual.getContato().getId();
            }
            atual = atual.getProximo();
        }
        return count + 1;
    }
    
}
