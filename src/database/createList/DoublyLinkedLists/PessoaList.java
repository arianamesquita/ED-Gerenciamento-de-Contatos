package database.createList.DoublyLinkedLists;

import database.createList.NOs.PessoaNO;
import model.Pessoa;

public class PessoaList {

    private Pessoa pessoa;

    private PessoaNO inicio;
    private PessoaNO fim;

    public PessoaList() {
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public String toString() {
        return "Pessoa = " + pessoa;
    }

    public void InsereNoFim(Pessoa pessoa) {
        PessoaNO atual = new PessoaNO(pessoa);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(Pessoa pessoa) {
        PessoaNO atual = new PessoaNO(pessoa);
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

    public void ApagaCategoria(Pessoa pessoa) {
        PessoaNO atual = getInicio();
        while (atual != null) {
            if (atual.getPessoa().equals(pessoa)) {
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
        System.out.println("A pessoa " + pessoa + "' não foi encontrada na lista.");
    }

    public void imprimir() {
        PessoaNO atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getPessoa().getNome() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public Pessoa buscarPorID(int id) {
        PessoaNO atual = getInicio();
        while (atual != null) {
            if (atual.getPessoa().getId() == id) {
                return atual.getPessoa();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public PessoaNO getInicio() {
        return inicio;
    }

    public void setInicio(PessoaNO inicio) {
        this.inicio = inicio;
    }

    public PessoaNO getFim() {
        return fim;
    }

    public void setFim(PessoaNO fim) {
        this.fim = fim;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
