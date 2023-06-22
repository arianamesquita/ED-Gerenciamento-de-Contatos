package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.createList.DoublyLinkedLists.CategoriaList;
import model.Categoria;

public class CategoriaDAO{

    public void save(Categoria categoria){
        String sql = "insert into categoria(id, nome) values (?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, categoria.getId());
            pstm.setString(2, categoria.getNome());

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

        String sql = "Delete from categoria where id = ?";

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

    public void update(Categoria categoria){
        String sql = "Update categoria set nome = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, categoria.getNome());
            pstm.setInt(2, categoria.getId());

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

    public CategoriaList Listar(){
        String sql = "Select * from categoria";
        CategoriaList lista = new CategoriaList();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Categoria categoria = new Categoria();

                categoria.setId(rset.getInt("id"));
                categoria.setNome(rset.getString("nome")); 

                lista.InsereNoFim(categoria);

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
        public Categoria ler(int id) {
            String sql = "SELECT * FROM categoria WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Categoria categoria;


        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

      

            if (rset.next()) {
                int ide = rset.getInt("id");
                String nome = rset.getString("nome");
                categoria = new Categoria(ide, nome);

            } 
              return categoria;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
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



}
