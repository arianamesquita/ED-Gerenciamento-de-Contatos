package database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectionFactory;
import database.DoublyLinkedLists;
import model.Contato;

public class ContatoDAO implements InterfaceDAO<Contato, Integer> {

    @Override
    public void insert(Contato contato) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO contatos (id, idPessoa, idCategoria) VALUES (?, ?, ?)")) {
            stmt.setInt(1, contato.getId());
            stmt.setInt(2, contato.getIdPessoa());
            stmt.setInt(3, contato.getIdCategoria());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Contato contato) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("UPDATE contatos SET idPessoa = ?, idCategoria = ? WHERE id = ?")) {
            stmt.setInt(1, contato.getIdPessoa());
            stmt.setInt(2, contato.getIdCategoria());
            stmt.setInt(3, contato.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM contatos WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contato findById(Integer id) {
        Contato contato = null;
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contatos WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    contato = new Contato();
                    contato.setId(rs.getInt("id"));
                    contato.setPessoa(new PessoaDAO().findById(rs.getInt("idPessoa")));
                    contato.setCategoria(new CategoriaDAO().findById(rs.getInt("idCategoria")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contato;
    }

    @Override
    public DoublyLinkedLists<Contato> findAll() {
        DoublyLinkedLists<Contato> contatos = new DoublyLinkedLists<>();
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contatos");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setPessoa(new PessoaDAO().findById(rs.getInt("idPessoa")));
                contato.setCategoria(new CategoriaDAO().findById(rs.getInt("idCategoria")));
                contatos.InsereNoFim(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contatos;
    }
}
