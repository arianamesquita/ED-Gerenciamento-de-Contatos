package database;

import model.Pessoa;

import java.util.Date;

public class PessoaDAO extends Pessoa{
    public PessoaDAO(String nome, int id, String telefone, String email, Date dataAniversario) {
        super(nome, id, telefone, email, dataAniversario);
    }
    
}
