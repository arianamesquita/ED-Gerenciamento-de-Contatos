package database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectionFactory;
import database.DoublyLinkedLists;
import model.Categoria;

public class CategoriaDAO implements InterfaceDAO<Categoria, Integer> {

    @Override
    public void insert(Categoria categoria) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO categoria (id, nome) VALUES (?, ?)")) {
            stmt.setInt(1, categoria.getId());
            stmt.setString(2, categoria.getNome());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Categoria categoria) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("UPDATE categoria SET nome = ? WHERE id = ?")) {
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM categoria WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Categoria findById(Integer id) {
        Categoria categoria = null;
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categoria WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setNome(rs.getString("nome"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public DoublyLinkedLists<Categoria> findAll() {
        DoublyLinkedLists<Categoria> categorias = new DoublyLinkedLists<>();
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categoria");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categorias.InsereNoFim(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }
}



