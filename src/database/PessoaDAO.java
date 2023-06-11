package database;

import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PessoaDAO {

    public void save(Pessoa pessoa){
        String sql = "insert into pessoa(id, nome, telefone, email, dataAniversario) values (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, pessoa.getId());
            pstm.setString(2, pessoa.getNome());
            pstm.setString(3, pessoa.getTelefone());
            pstm.setString(4, pessoa.getEmail());
            pstm.setDate(5, pessoa.getDataAniversario());

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

        String sql = "Delete from pessoa where id = ?";

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

    public void update(Pessoa pessoa){
        String sql = "Update pessoa set nome = ?, telefone = ?,  email = ?, dataAniversario = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getTelefone());
            pstm.setString(3, pessoa.getEmail());
            pstm.setDate(4, pessoa.getDataAniversario());

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

    public List<Pessoa> Listar(){
        String sql = "Select * from pessoa";
        List<Pessoa> lista = new ArrayList<Pessoa>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rset.getInt("id"));
                pessoa.setNome(rset.getString("nome")); 
                pessoa.setTelefone(rset.getString("telefone"));
                pessoa.setEmail(rset.getString("email"));
                pessoa.setDataAniversario(rset.getDate("dataAniversario"));
                
                lista.add(pessoa);
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
