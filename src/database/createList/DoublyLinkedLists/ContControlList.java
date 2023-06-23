package database.createList.DoublyLinkedLists;

import controller.ContatoController;
import database.createList.NOs.ContControlNO;

public class ContControlList {
    
    private ContatoController controller;

    private ContControlNO inicio;
    private ContControlNO fim;

    public ContControlList() {
        this.inicio = null;
        this.fim = null;
    }

    public void InsereNoFim(ContatoController controller) {
        ContControlNO atual = new ContControlNO(controller);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(ContatoController controller) {
        ContControlNO atual = new ContControlNO(controller);
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

    public void ApagaContatoController(ContatoController controller) {
        ContControlNO atual = getInicio();
        while (atual != null) {
            if (atual.getContato() == controller) {
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
        System.out.println("A categoria '" + controller + "' não foi encontrada na lista.");
    }

    public void imprimir() {
        ContControlNO atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getContato().getContato().getPessoa().getNome() + "-> " +
                    atual.getContato().getContato().getPessoa().getTelefone());
            atual = atual.getProximo();
            System.out.println("\n");
        }
        System.out.println();
    }

    public ContatoController getController() {
        return controller;
    }

    public void setController(ContatoController controller) {
        this.controller = controller;
    }

    public ContControlNO getInicio() {
        return inicio;
    }

    public void setInicio(ContControlNO inicio) {
        this.inicio = inicio;
    }

    public ContControlNO getFim() {
        return fim;
    }

    public void setFim(ContControlNO fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "ContControlList [controller=" + controller + ", inicio=" + inicio + ", fim=" + fim + "]";
    }

}
