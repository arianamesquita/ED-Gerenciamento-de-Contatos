package database.createList;

import model.Categoria;
import model.Contato;

public class ContatoList {

    Contato contato;

    private NoContato inicio;
    private NoContato fim;

    public ContatoList() {
        this.inicio = null;
        this.fim = null;
    }

    public NoContato getInicio() {
        return inicio;
    }

    public void setInicio(NoContato inicio) {
        this.inicio = inicio;
    }

    public NoContato getFim() {
        return fim;
    }

    public void setFim(NoContato fim) {
        this.fim = fim;
    }

    
    @Override
    public String toString() {
        return "Contato = " + contato;
    }

    public void InsereNoFim(Contato contato) {
        NoContato atual = new NoContato(contato);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(Contato contato) {
        NoContato atual = new NoContato(contato);
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

    public void ApagaContato(Contato contato) {
        NoContato atual = getInicio();
        while (atual != null) {
            if (atual.getContato().equals(contato)) {
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
        System.out.println("O contato '" + contato + "' não foi encontrada na lista.");
    }

    public void imprimir() {
        NoContato atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getContato().getPessoa() + " - " + atual.getContato().getCategoria());
            atual = atual.getProximo();
            System.out.println("\n");
        }
        System.out.println();
    }

}


