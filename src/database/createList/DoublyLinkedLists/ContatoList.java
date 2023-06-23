package database.createList.DoublyLinkedLists;

import database.createList.NOs.ContatoNO;
import model.Contato;

public class ContatoList {

    private Contato contato;

    private ContatoNO inicio;
    private ContatoNO fim;

    public ContatoList() {
        this.inicio = null;
        this.fim = null;
    }

    public void InsereNoFim(Contato contato) {
        ContatoNO atual = new ContatoNO(contato);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(Contato contato) {
        ContatoNO atual = new ContatoNO(contato);
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
        ContatoNO atual = getInicio();
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
        ContatoNO atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getContato().getPessoa() + " - " + atual.getContato().getCategoria());
            atual = atual.getProximo();
            System.out.println("\n");
        }
        System.out.println();
    }

    public ContatoNO getInicio() {
        return inicio;
    }

    public void setInicio(ContatoNO inicio) {
        this.inicio = inicio;
    }

    public ContatoNO getFim() {
        return fim;
    }

    public void setFim(ContatoNO fim) {
        this.fim = fim;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Contato = " + contato;
    }
}
