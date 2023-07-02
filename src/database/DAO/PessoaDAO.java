package database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectionFactory;
import database.DoublyLinkedLists;
import model.Pessoa;

public class PessoaDAO implements InterfaceDAO<Pessoa, Integer> {

    @Override
    public void insert(Pessoa pessoa) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO pessoa (id, nome, telefone, email, data_nascimento) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setInt(1, pessoa.getId());
            stmt.setString(2, pessoa.getNome());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setDate(5, pessoa.getDataAniversario());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("UPDATE pessoa SET nome = ?, telefone = ?, email = ?, data_nascimento = ? WHERE id = ?")) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getTelefone());
            stmt.setString(3, pessoa.getEmail());
            stmt.setDate(4, pessoa.getDataAniversario());
            stmt.setInt(5, pessoa.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pessoa findById(Integer id) {
        Pessoa pessoa = null;
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pessoa WHERE id = ?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new Pessoa();
                    pessoa.setId(rs.getInt("id"));
                    pessoa.setNome(rs.getString("nome"));
                    pessoa.setTelefone(rs.getString("telefone"));
                    pessoa.setEmail(rs.getString("email"));
                    pessoa.setDataAniversario(rs.getDate("data_nascimento"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    @Override
    public DoublyLinkedLists<Pessoa> findAll() {
        DoublyLinkedLists<Pessoa> pessoas = new DoublyLinkedLists<>();
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pessoa");
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setDataAniversario(rs.getDate("data_nascimento"));
                pessoas.InsereNoFim(pessoa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pessoas;
    }
}
