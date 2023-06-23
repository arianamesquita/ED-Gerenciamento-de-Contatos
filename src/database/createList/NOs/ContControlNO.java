package database.createList.NOs;

import controller.ContatoController;

public class ContControlNO {

    private ContatoController contatoController;
    private ContControlNO anterior;
    private ContControlNO proximo;

    public ContControlNO(ContatoController contatoController) {
        this.contatoController = contatoController;
        this.anterior = null;
        this.proximo = null;
    }

    public ContatoController getContato() {
        return contatoController;
    }

    public void setContato(ContatoController contato) {
        this.contatoController = contato;
    }

    public ContControlNO getAnterior() {
        return anterior;
    }

    public void setAnterior(ContControlNO anterior) {
        this.anterior = anterior;
    }

    public ContControlNO getProximo() {
        return proximo;
    }

    public void setProximo(ContControlNO proximo) {
        this.proximo = proximo;
    }

}
