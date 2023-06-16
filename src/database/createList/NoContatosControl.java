package database.createList;

import controller.ContatosController;

public class NoContatosControl {
    
    private ContatosController contato;
    private NoContatosControl anterior;
    private NoContatosControl proximo;

    public NoContatosControl(ContatosController contato) {
        this.contato = contato;
        this.anterior = null;
        this.proximo = null;
    }

    public ContatosController getContato() {
        return contato;
    }

    public void setContato(ContatosController contato) {
        this.contato = contato;
    }

    public NoContatosControl getAnterior() {
        return anterior;
    }

    public void setAnterior(NoContatosControl anterior) {
        this.anterior = anterior;
    }

    public NoContatosControl getProximo() {
        return proximo;
    }

    public void setProximo(NoContatosControl proximo) {
        this.proximo = proximo;
    }



}
