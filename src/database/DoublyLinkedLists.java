package database;

public class DoublyLinkedLists<T> {

    private NO<T> inicio;
    private NO<T> fim;

    public DoublyLinkedLists() {
        this.inicio = null;
        this.fim = null;
    }

    public void InsereNoFim(T data) {
        NO<T> atual = new NO<>(data);
        if (getInicio() == null) {
            setInicio(atual);
        } else {
            getFim().setProximo(atual);
            atual.setAnterior(getFim());
        }
        setFim(atual);
    }

    public void InsereNoInicio(T data) {
        NO<T> atual = new NO<>(data);
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

    public void ApagaData(T data) {
        NO<T> atual = getInicio();
        while (atual != null) {
            if (atual.getData().equals(data)) {
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
        System.out.println("O dado '" + data + "' não foi encontrado na lista.");
    }

    public void imprimir() {
        NO<T> atual = getInicio();
        while (atual != null) {
            System.out.print(atual.getData() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }


    public NO<T> getInicio() {
        return inicio;
    }

    public void setInicio(NO<T> inicio) {
        this.inicio = inicio;
    }

    public NO<T> getFim() {
        return fim;
    }

    public void setFim(NO<T> fim) {
        this.fim = fim;
    }
}
