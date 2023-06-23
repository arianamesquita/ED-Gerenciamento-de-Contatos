package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import database.createList.DoublyLinkedLists.PessoaList;
import database.createList.NOs.PessoaNO;
import model.Pessoa;

public class PessoaDAO {

    public void save(Pessoa pessoa) {
        String sql = "insert into pessoa(id, nome, telefone, email, dataAniversario) values (?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, geraId());
            pstm.setString(2, pessoa.getNome());
            pstm.setString(3, pessoa.getTelefone());
            pstm.setString(4, pessoa.getEmail());
            pstm.setDate(5, pessoa.getDataAniversario());

            pstm.execute();

            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível adicionar!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeById(int id) {

        String sql = "Delete from pessoa where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível apagar!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeByName(String name) {

        String sql = "Delete from pessoa where nome = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, name);

            pstm.execute();

            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível apagar!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Pessoa pessoa) {
        String sql = "Update pessoa set nome = ?, telefone = ?,  email = ?, dataAniversario = ? where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getTelefone());
            pstm.setString(3, pessoa.getEmail());
            pstm.setDate(4, pessoa.getDataAniversario());
            pstm.setInt(5, pessoa.getId());

            pstm.execute();

            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Não foi possível atualizar!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public PessoaList List() {
        String sql = "Select * from pessoa";
        PessoaList lista = new PessoaList();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setId(rset.getInt("id"));
                pessoa.setNome(rset.getString("nome"));
                pessoa.setTelefone(rset.getString("telefone"));
                pessoa.setEmail(rset.getString("email"));
                pessoa.setDataAniversario(rset.getDate("dataAniversario"));

                lista.InsereNoFim(pessoa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    public static int geraId() {
        int count = 0;
        PessoaList pessoaList = new PessoaDAO().List();
        PessoaNO atual = pessoaList.getInicio();
        while (atual != null) {
            if (count < atual.getPessoa().getId()) {
                count = atual.getPessoa().getId();
            }
            atual = atual.getProximo();
        }
        return count + 1;
    }

    public Pessoa searchById(int id) {

        String sql = "Select * from pessoa where id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Pessoa pessoa = new Pessoa();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                pessoa.setId(id);
                pessoa.setNome(rset.getString("nome"));
                pessoa.setTelefone(rset.getString("telefone"));
                pessoa.setEmail(rset.getString("email"));
                pessoa.setDataAniversario(rset.getDate("dataAniversario"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pessoa;
    }

    public Pessoa searchByName(String name) {

        String sql = "Select * from pessoa where nome = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Pessoa pessoa = new Pessoa();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            rset = pstm.executeQuery();

            if (rset.next()) {
                pessoa.setId(rset.getInt("id"));
                pessoa.setNome(name);
                pessoa.setTelefone(rset.getString("telefone"));
                pessoa.setEmail(rset.getString("email"));
                pessoa.setDataAniversario(rset.getDate("dataAniversario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pessoa;
    }

}
