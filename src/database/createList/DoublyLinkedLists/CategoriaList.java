package database.createList.DoublyLinkedLists;

import database.createList.NOs.CategoriaNO;
import model.Categoria;

public class CategoriaList {

    Categoria categoria;

    private CategoriaNO inicio;
    private CategoriaNO fim;

    public CategoriaList() {
        this.inicio = null;
        this.fim = null;
    }

    public void InsereNoFim(Categoria categoria) {
        CategoriaNO atual = new CategoriaNO(categoria);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(Categoria categoria) {
        CategoriaNO atual = new CategoriaNO(categoria);
        if (getInicio() == null) {
            setInicio(atual);
            setFim(atual);

        } else {
            atual.setProximo(getInicio());
            getInicio().setAnterior(atual);
            setInicio(atual);
        }
    }

    public void ApagaNoFim() {
        if (getInicio() == null) {
            System.out.println("A lista está vazia.");
        } else if (getInicio() == getFim()) {
            setInicio(null);
            setFim(null);
        } else {
            setFim(getFim().getAnterior());
            getFim().setProximo(null);
        }
    }

    public void ApagaNoInicio() {
        if (getInicio() == null) {
            System.out.println("A lista está vazia.");
        } else if (getInicio() == getFim()) {
            setInicio(null);
            setFim(null);
        } else {
            setInicio(getInicio().getProximo());
            getInicio().setAnterior(null);
        }
    }

    public void ApagaCategoria(Categoria categoria) {
        CategoriaNO atual = getInicio();
        while (atual != null) {
            if (atual.getCategoria().equals(categoria)) {
                if (atual == getInicio()) {
                    ApagaNoInicio();
                } else if (atual == getFim()) {
                    ApagaNoFim();
                } else {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());

                }
                return;
            }
            atual = atual.getProximo();
        }
        System.out.println("A categoria '" + categoria + "' não foi encontrada na lista.");
    }

    public void imprimir() {
        CategoriaNO atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getCategoria().getNome() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public Categoria buscarPorID(int id) {
        CategoriaNO atual = getInicio();
        while (atual != null) {
            if (atual.getCategoria().getId() == id) {
                return atual.getCategoria();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public CategoriaNO getInicio() {
        return inicio;
    }

    public void setInicio(CategoriaNO inicio) {
        this.inicio = inicio;
    }

    public CategoriaNO getFim() {
        return fim;
    }

    public void setFim(CategoriaNO fim) {
        this.fim = fim;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categoria = " + categoria;
    }

}