package model;

import java.util.Date;

public class Pessoa {
    
    public String nome;
    public int id;
    public String telefone;
    public String email;
    public Date dataAniversario;


    public Pessoa( ) {  }
    public Pessoa(String nome, int id, String telefone, String email, Date dataAniversario) {
        this.nome = nome;
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.dataAniversario = dataAniversario;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDataAniversario() {
        return dataAniversario;
    }
    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }


    @Override
    public String toString() {
        return "Id = " + id + 
                ", nome = " + nome + 
                ", telefone = " + telefone + 
                ", email = " + email +
                ", dataAniversario = " + dataAniversario;
    }
    
}
