package model;

public class Categoria {

    private String categorias;

    
    public Categoria( ) {  }
    public Categoria(String categorias) {
        this.categorias = categorias;
    }


    public String getCategorias() {
        return categorias;
    }
    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }


    @Override
    public String toString() {
        return "Categorias = " + categorias;
    }
       
}
