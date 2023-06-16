package model;

import java.io.Serializable;

import database.DAO;

public class Contato implements DAO, Serializable{

    public int id;
    public Categoria categoria;
    public Pessoa pessoa;


    public Contato( ) {   }
    public Contato(int id, Categoria categoria, Pessoa pessoa) {
        this.id = id;
        this.categoria = categoria;
        this.pessoa = pessoa;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public Categoria getCategoria(int id) {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Pessoa getPessoa(int id) {
        return pessoa;
    }

    @Override
    public void gravar() {
    }
    @Override
    public void excluir() {
    }
    @Override
    public void ler() {
    }
    @Override
    public void atualizar() {
    }
    @Override

    public String toString() {
        return "Contato id = " + id + 
            ", categoria = " + categoria + 
            ", pessoa = " + pessoa;
    }

    

}
