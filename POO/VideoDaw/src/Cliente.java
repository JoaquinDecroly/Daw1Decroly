import java.time.LocalDate;

public class Cliente {
    private String dni;
    private String nombre;
    private int numS;
    private static int contadorCl = 0;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;

    //array
    private Pelicula [] peliculasAlquiladas;

    // Constructor
    public Cliente(String dni, String nombre, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.numS = contadorCl++;
        this.fechaNacimiento = LocalDate.now();
        this.peliculasAlquiladas = new Pelicula[0];
        
    }

   

    // Getters and Setters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumS() {
        return numS;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    
    //metodos
  

    private boolean validardni (String dni) {
       while (dni != null) {
    String pattern = "^\\d{8}[A-Z]$";
    if (dni.matches(pattern)) {
        return true;
    } else {
       System.out.println("DNI no válido");
    }
    }
    return false;  
    }

    public void agregarPelicula(Pelicula pelicula) {
    Pelicula[] nuevasPeliculas = new Pelicula[peliculasAlquiladas.length + 1];
    System.arraycopy(peliculasAlquiladas, 0, nuevasPeliculas, 0, peliculasAlquiladas.length);
    nuevasPeliculas[peliculasAlquiladas.length] = pelicula;
    this.peliculasAlquiladas = nuevasPeliculas;
    }

    public void eliminarPelicula(Pelicula pelicula) {
        if (peliculasAlquiladas != null) {
            int index = -1;
            for (int i = 0; i < peliculasAlquiladas.length; i++) {
                if (peliculasAlquiladas[i].equals(pelicula)) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                Pelicula[] nuevasPeliculas = new Pelicula[peliculasAlquiladas.length - 1];
                System.arraycopy(peliculasAlquiladas, 0, nuevasPeliculas, 0, index);
                System.arraycopy(peliculasAlquiladas, index + 1, nuevasPeliculas, index, peliculasAlquiladas.length - index - 1);
                this.peliculasAlquiladas = nuevasPeliculas;
            }
        }
    }


    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", numS=" + numS + ", fechaNacimiento=" + fechaNacimiento
                + ", fechaBaja=" + fechaBaja + ", peliculasAlquiladas=" + peliculasAlquiladas + "]";
    }

    
}