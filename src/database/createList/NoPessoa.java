package database.createList;

import model.Pessoa;

public class NoPessoa {

    private final Pessoa pessoa;
    private NoPessoa anterior;
    private NoPessoa proximo;

    public NoPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.anterior = null;
        this.proximo = null;
    }

    public NoPessoa getAnterior() {
        return anterior;
    }

    public void setAnterior(NoPessoa anterior) {
        this.anterior = anterior;
    }

    public NoPessoa getProximo() {
        return proximo;
    }

    public void setProximo(NoPessoa proximo) {
        this.proximo = proximo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    
}
