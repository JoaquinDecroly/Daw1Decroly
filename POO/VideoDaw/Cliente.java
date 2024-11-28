import java.time.LocalDate;

public class Cliente {
    private String dni;
    private String nombre;
    private String numSocio; // Cambiado a String para seguir el formato S-0001
    private static int contadorSocio = 1; // Iniciar en 1 para que el primer socio sea S-0001
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    public static Pelicula[] peliculasAlquiladas; // Array para almacenar películas alquiladas
    private int maxPeliculas = 10; // Capacidad máxima de películas alquiladas

    // Constructor
    public Cliente(String dni, String nombre, LocalDate fechaNacimiento) {
        if (isDniValido(dni) && !nombre.isEmpty()) {
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = "S-" + String.format("%04d", contadorSocio++); // Generar código único
        this.fechaNacimiento = fechaNacimiento;
        this.peliculasAlquiladas = new Pelicula[maxPeliculas]; // Inicializar el array
    }
}

    // Getters

    public String getDni() {
    return dni;
}
    public String getNombre() {
        return nombre;
    }

    
    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public Pelicula[] getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    
public void mostrarInfoCliente() {
    System.out.println("DNI: " + dni);
    System.out.println("Nombre: " + nombre);
    System.out.println("Número de Socio: " + numSocio);
    System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
    System.out.println("Películas Alquiladas:");
    mostrarPeliculasAlquiladas();
}


    public void mostrarPeliculasAlquiladas() {
        for (Pelicula pelicula : peliculasAlquiladas) {
            if (pelicula != null) {
                pelicula.mostrarInfoPelicula(); 
        }
    }
}

   
    public boolean isDniValido(String dni) {
        return dni != null && dni.matches("[A-Z]{1}//d{9}");
    }

 public void devolverPelicula(Pelicula pelicula) {
        for (Pelicula peliculasAlquilada : peliculasAlquiladas) {
            if (peliculasAlquilada != null && peliculasAlquilada.getCod().equals(pelicula.getCod())) {
                System.out.println("Película devuelta: " + pelicula.getTítulo());
                return;
            }
        }
    System.out.println("La película no está alquilada por este cliente.");
}

     public void alquilarPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) { 
                peliculasAlquiladas[i] = pelicula;
                return;
            }
        }
        System.out.println("No se pueden alquilar más películas.");
    }

  
   
    
   
    private void registrarPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) { 
                peliculasAlquiladas[i] = pelicula; 
                return;
            }
        }
        System.out.println("No se pueden registrar más películas.");
    }


    
}