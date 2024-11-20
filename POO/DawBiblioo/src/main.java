public class main {
    public static void main(String[] args) {
        Libros libro = new Libros("El Señor de los Anillos", "J.R.R. Tolkien", 1000);
        System.out.println(libro.getTitulo());
        System.out.println();
    }
}

class Libros {
    private String titulo;
    private String autor;
    private int paginas;

    public Libros(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIsbn'");
    }

    

   
    
}