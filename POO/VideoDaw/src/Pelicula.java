import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private int cod;
    private static int contadorP = 0;
    private Genero genero;
    private DateTimeFormatter fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDate fechaAlquiler;
    public static boolean isAlquilado;

    //constructor 
   public Pelicula(int cod, Genero genero, DateTimeFormatter formatter, boolean isAlquilado) {
    this.cod = contadorP++;
    this.genero = genero;
    this.fechaRegistro = formatter;
    this.fechaBaja = null;
    this.fechaAlquiler = null;
    isAlquilado = false;
}

    //getter y setter
    public int getCod() {
        return cod;
    }

    public Genero getGenero() {
        return genero;
    }

    public DateTimeFormatter getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean getIsAlquilado() {
        return isAlquilado;
    }

    public void setIsAlquilado(){
        isAlquilado = true;
    }
    //metodos
    public String mostrarInfoPelicula() {
        String info = String.format("Pelicula - Cod= %s  Genero= %s  FechaRegistro= %s FechaBaja= %s FechaAlquiler= %s",
         this.cod, this.genero, this.fechaRegistro, this.fechaBaja, this.fechaAlquiler);
         return info;
    }

   
 
}    
