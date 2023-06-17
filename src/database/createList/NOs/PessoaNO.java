package database.createList.NOs;

import model.Pessoa;

public class PessoaNO {

    private final Pessoa pessoa;
    private PessoaNO anterior;
    private PessoaNO proximo;

    public PessoaNO(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.anterior = null;
        this.proximo = null;
    }

    public PessoaNO getAnterior() {
        return anterior;
    }

    public void setAnterior(PessoaNO anterior) {
        this.anterior = anterior;
    }

    public PessoaNO getProximo() {
        return proximo;
    }

    public void setProximo(PessoaNO proximo) {
        this.proximo = proximo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
}
