package database.createList;

import model.Pessoa;

public class PessoaList {

    Pessoa pessoa;

    private NoPessoa inicio;
    private NoPessoa fim;

    public PessoaList() {
        this.inicio = null;
        this.fim = null;
    }

    public NoPessoa getInicio() {
        return inicio;
    }

    public void setInicio(NoPessoa inicio) {
        this.inicio = inicio;
    }

    public NoPessoa getFim() {
        return fim;
    }

    public void setFim(NoPessoa fim) {
        this.fim = fim;
    }

    
    @Override
    public String toString() {
        return "Pessoa = " + pessoa;
    }

    public void InsereNoFim(Pessoa pessoa) {
        NoPessoa atual = new NoPessoa(pessoa);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(Pessoa pessoa) {
        NoPessoa atual = new NoPessoa(pessoa);
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
        NoPessoa atual = getInicio();
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
        NoPessoa atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getPessoa().getNome() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    public Pessoa buscarPorID(int id) {
        NoPessoa atual = getInicio();
        while (atual != null) {
            if (atual.getPessoa().getId() == id){
                return atual.getPessoa();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    
}
