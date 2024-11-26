import java.time.LocalDate;

public class Cliente {
    private String dni;
    private String nombre;
    private String numSocio; // Cambiado a String para seguir el formato S-0001
    private static int contadorSocio = 1; // Iniciar en 1 para que el primer socio sea S-0001
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas; // Array para almacenar películas alquiladas
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

    // Getters


    public String getDni) {
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

    // Método para mostrar información del cliente
    public void mostrarInfoCliente() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de Socio: " + numSocio);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Películas Alquiladas: ");
        mostrarPeliculasAlquiladas();
    }

    // Método para mostrar las películas alquiladas
    public void mostrarPeliculasAlquiladas() {
        for (Pelicula pelicula : peliculasAlquiladas) {
            if (pelicula != null) {
                pelicula.mostrarInfoPelicula(); // Asumiendo que Pelicula tiene este método
            }
        }
    }

    // Método para alquilar una película
    public void alquilarPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) { // Buscar un espacio vacío
                peliculasAlquiladas[i] = pelicula;
                return;
            }
        }
        System.out.println("No se pueden alquilar más películas.");
    }

    // Método para devolver una película
    public void devolverPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] != null && peliculasAlquiladas[i].getCodigo().equals(pelicula.getCodigo())) {
                peliculasAlquiladas[i].devolver(); // Llamar al método devolver de la clase Pelicula
                peliculasAlquiladas[i] = null; // Eliminar la película del array de películas alquiladas
                
                // Actualizar el array de películas registradas
                // Suponiendo que tienes un método para registrar películas
                registrarPelicula(pelicula);
                
                System.out.println("Película devuelta: " + pelicula.getTitulo());
                return;
            }
        }
        System.out.println("La película no está alquilada por este cliente.");
    }
    
    // Método para registrar la película en el array de películas registradas
    private void registrarPelicula(Pelicula pelicula) {
        // Aquí puedes implementar la lógica para agregar la película al array de películas registradas
        // Por ejemplo, si tienes un array de películas registradas, puedes agregar la película
        // Asegúrate de que el array tenga espacio suficiente
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) { // Buscar un espacio vacío
                peliculasAlquiladas[i] = pelicula; // Registrar la película
                return;
            }
        }
        System.out.println("No se pueden registrar más películas.");
    }
    private boolean isDniValido(String dni) {
        return dni != null && dni.matches("[A-Z]{1}//d{9}");
    }

    
}