package database;

public class NO<T> {

    private T data;
    private NO<T> anterior;
    private NO<T> proximo;

    public NO(T data) {
        this.data = data;
        this.anterior = null;
        this.proximo = null;
    }

    public T getData() {
        return data;
    }

    public NO<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NO<T> anterior) {
        this.anterior = anterior;
    }

    public NO<T> getProximo() {
        return proximo;
    }

    public void setProximo(NO<T> proximo) {
        this.proximo = proximo;
    }

    public void setData(T data) {
        this.data = data;
    }
}

