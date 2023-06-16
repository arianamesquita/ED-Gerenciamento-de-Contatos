package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.createList.CategoriaList;
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
        String sql = "Update categoria set nome = ? where id = ?";

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



}
