package database.createList;

import model.Categoria;

public class No {
    
    private final Categoria categoria;
    private No anterior;
    private No proximo;

    public No(Categoria categoria) {
        this.categoria = categoria;
        this.anterior = null;
        this.proximo = null;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    
}
