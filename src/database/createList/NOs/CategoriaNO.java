package database.createList.NOs;

import model.Categoria;

public class CategoriaNO {

    private Categoria categoria;
    private CategoriaNO anterior;
    private CategoriaNO proximo;

    public CategoriaNO(Categoria categoria) {
        this.categoria = categoria;
        this.anterior = null;
        this.proximo = null;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public CategoriaNO getAnterior() {
        return anterior;
    }

    public void setAnterior(CategoriaNO anterior) {
        this.anterior = anterior;
    }

    public CategoriaNO getProximo() {
        return proximo;
    }

    public void setProximo(CategoriaNO proximo) {
        this.proximo = proximo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
