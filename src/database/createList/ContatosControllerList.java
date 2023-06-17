package database.createList;

import controller.ContatosController;

public class ContatosControllerList {
    private ContatosController controller;

    private NoContatosControl inicio;
    private NoContatosControl fim;

    public ContatosControllerList() {
        this.inicio = null;
        this.fim = null;
    }

    public ContatosController getController() {
        return controller;
    }

    public void setController(ContatosController controller) {
        this.controller = controller;
    }


    public NoContatosControl getInicio() {
        return inicio;
    }

    public void setInicio(NoContatosControl inicio) {
        this.inicio = inicio;
    }

    public NoContatosControl getFim() {
        return fim;
    }

    public void setFim(NoContatosControl fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return "ContatosControllerList [controller=" + controller + ", inicio=" + inicio + ", fim=" + fim + "]";
    }

    public void InsereNoFim(ContatosController controller) {
        NoContatosControl atual = new NoContatosControl(controller);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(ContatosController controller) {
        NoContatosControl atual = new NoContatosControl(controller);
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

    public void ApagaContatoController(ContatosController controller) {
        NoContatosControl atual = getInicio();
        while (atual != null) {
            if (atual.getContato()==controller) {
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
        System.out.println("A categoria '" +controller + "' não foi encontrada na lista.");
    }

    public void imprimir() {
        NoContatosControl atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getContato().getContato().getPessoa().getNome() + "-> " +
            atual.getContato().getContato().getPessoa().getTelefone());
            atual = atual.getProximo();
            System.out.println("\n");
        }
        System.out.println();
    }



}
