package database.createList;

import model.Contato;

public class NoContato {

    private Contato contato;
    private NoContato anterior;
    private NoContato proximo;

    public NoContato(Contato contato) {
        this.contato = contato;
        this.anterior = null;
        this.proximo = null;
    }


    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public NoContato getAnterior() {
        return anterior;
    }

    public void setAnterior(NoContato anterior) {
        this.anterior = anterior;
    }

    public NoContato getProximo() {
        return proximo;
    }

    public void setProximo(NoContato atual) {
        this.proximo = atual;
    }

    
}
