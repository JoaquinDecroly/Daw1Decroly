import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Pelicula {
    private int codigo;
    private static int contadorPeli = 0;
    private String titulo;
    private Enum genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private String fechaAlquiler;
   
    // Constructor
    public Pelicula(int codigo, String titulo, Enum genero, LocalDate fechaRegistro) {
        this.codigo = contadorPeli;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.fechaBaja = LocalDate.now();
        this.fechaAlquiler = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Getters and Setters
    public int getCodigo() {
        return codigo;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Enum getGenero() {
        return genero;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

   

    public String getFechaAlquiler() {
        return fechaAlquiler;
    }

    //metodos

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append(", titulo=").append(titulo);
        sb.append(", genero=").append(genero);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", fechaBaja=").append(fechaBaja);
        sb.append(", fechaAlquiler=").append(fechaAlquiler);
        sb.append('}');
        return sb.toString();
    }
   


}
    

