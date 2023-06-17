package database.createList.NOs;

import model.Contato;

public class ContatoNO {

    private Contato contato;
    private ContatoNO anterior;
    private ContatoNO proximo;

    public ContatoNO(Contato contato) {
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

    public ContatoNO getAnterior() {
        return anterior;
    }

    public void setAnterior(ContatoNO anterior) {
        this.anterior = anterior;
    }

    public ContatoNO getProximo() {
        return proximo;
    }

    public void setProximo(ContatoNO atual) {
        this.proximo = atual;
    }
    
}
