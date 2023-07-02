package model;

import java.io.Serializable;

public class Contato implements Serializable {

    private int id;
    private Categoria categoria;
    private Pessoa pessoa;

    public Contato() {
    }

    public Contato(int id, Categoria categoria, Pessoa pessoa) {
        this.id = id;
        this.categoria = categoria;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }
    public int getIdPessoa(){
        return pessoa.getId();
    }

    public int getIdCategoria(){
        return categoria.getId();
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
    public String toString() {
        return "Contato id = " + id +
                ", categoria = " + categoria +
                ", pessoa = " + pessoa;
    }

}
