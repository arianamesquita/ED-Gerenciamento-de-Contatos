package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.createList.DoublyLinkedLists.CategoriaList;
import database.createList.NOs.CategoriaNO;
import model.Categoria;

public class CategoriaDAO {

    public void save(String categoriaNome) {
        String sql = "insert into categoria(id, nome) values (?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, geraId());
            pstm.setString(2, categoriaNome);

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

        String sql = "Delete from categoria where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
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

        String sql = "Delete from categoria where nome = ?";

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

    public void update(Categoria categoria, String novoNome) {
        String sql = "Update categoria set nome = ? where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, novoNome);
            pstm.setInt(2, categoria.getId());

            pstm.execute();

            if (pstm.getUpdateCount() > 0)
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
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

    public CategoriaList Listar() {
        String sql = "Select * from categoria";
        CategoriaList lista = new CategoriaList();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Categoria categoria = new Categoria();

                categoria.setId(rset.getInt("id"));
                categoria.setNome(rset.getString("nome"));

                lista.InsereNoFim(categoria);

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

    public Categoria searchById(int id) {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Categoria categoria = new Categoria();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                categoria.setNome(rset.getString("nome"));
                categoria.setId(id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
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

        return categoria;
    }

    public Categoria searchByName(String name) {
        String sql = "SELECT * FROM categoria WHERE nome = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Categoria categoria = new Categoria();

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            rset = pstm.executeQuery();

            if (rset.next()) {
                categoria.setNome(rset.getString("nome"));
                categoria.setId(rset.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
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

        return categoria;
    }

    public static int geraId() {
        int count = 0;
        CategoriaList categoriaList = new CategoriaDAO().Listar();
        CategoriaNO atual = categoriaList.getInicio();
        while (atual != null) {

            if (count < atual.getCategoria().getId()) {
                count = atual.getCategoria().getId();
            }
            atual = atual.getProximo();
        }
        return count + 1;
    }

}
