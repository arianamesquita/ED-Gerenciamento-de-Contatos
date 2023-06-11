package model;

import java.io.Serializable;
import database.DAO;

public class Categoria implements DAO, Serializable{

    private int id;
    private String nome;

    
    public Categoria( ) {  }
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "Categorias = " + nome;
    }

    @Override
	public void gravar() {	}

	@Override
	public void excluir() { 	}

	@Override
	public void ler() { 	}

	@Override
	public void atualizar() {	}

       
}
