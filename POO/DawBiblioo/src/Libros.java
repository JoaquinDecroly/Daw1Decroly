public class Libros {
    // Creamos un objeto de la clase movimiento
    private String titulo;
    private String autor;
    private int nPag;
    private String isbn;
    private String edicion;
    private String editorial;
    private String fechaPubli;

    // constructor
  public Libros(String titulo, String autor, String isbn, String edicion, String editorial, int numPaginas, String fechaPublicacion){
    this.titulo = titulo; 
    this.autor = autor;
    this.nPag = nPag;
    this.isbn = isbn;
    this.edicion = edicion;
    this.editorial = editorial;
    this.fechaPubli = fechaPublicacion;
}

    // getter y setter
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

   public int getNPag(){
    return nPag >= 0 ? nPag : 0;
}

    public void setNPag(int nPag){
        if(nPag > 0){
             this.nPag = nPag;
        }else{
            System.out.println("El numero de paginas no puede ser negativo");
        }
       
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    public String getEdicion(){
        return edicion;
    }

    public void setEdicion(String edicion){
        this.edicion = edicion;
    }

    public String getEditorial(){
        return editorial;
    }

    public void setEditorial(String editorial){
        this.editorial = editorial;
    }

    public String getFechaPubli(){
        return fechaPubli;
    }

    public void setFechaPubli(String fechaPubli){
        this.fechaPubli = fechaPubli;
    }

    String infoLibro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String infoLibro() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}