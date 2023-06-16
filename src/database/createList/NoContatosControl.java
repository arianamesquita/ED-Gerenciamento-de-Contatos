package database.createList;

import controller.ContatosController;

public class NoContatosControl {
    
    private ContatosController contatoController;
    private NoContatosControl anterior;
    private NoContatosControl proximo;

    public NoContatosControl(ContatosController contatoController) {
        this.contatoController = contatoController;
        this.anterior = null;
        this.proximo = null;
    }

    public ContatosController getContato() {
        return contatoController;
    }

    public void setContato(ContatosController contato) {
        this.contatoController = contato;
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
