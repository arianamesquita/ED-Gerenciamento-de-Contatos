package database.createList;

import model.Categoria;

public class CategoriaList {

    Categoria categoria;

    private No inicio;
    private No fim;

    public CategoriaList() {
        this.inicio = null;
        this.fim = null;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    
    @Override
    public String toString() {
        return "Categoria = " + categoria;
    }

    public void InsereNoFim(Categoria categoria) {
        No atual = new No(categoria);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(Categoria categoria) {
        No atual = new No(categoria);
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
        No atual = getInicio();
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
        No atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getCategoria().getNome() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public Categoria buscarPorID(int id) {
        No atual = getInicio();
        while (atual != null) {
            if (atual.getCategoria().getId() == id){
                return atual.getCategoria();
            }
            atual = atual.getProximo();
        }
        return null;
    }

}