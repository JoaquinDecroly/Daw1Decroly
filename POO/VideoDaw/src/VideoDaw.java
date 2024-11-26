import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class VideoDaw {
    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;
    private int numPeliculas;
    private int numClientes;

    // Constructor
    public VideoDaw(String CIF, String direccion, LocalDate fechaAlta) {
        if (!isCIFValido(CIF)) {
            this.CIF = "CIF no válido";
        } else {
            this.CIF = CIF;
        }
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.peliculasRegistradas = new Pelicula[100]; // Capacidad máxima de 100 películas
        this.clientesRegistrados = new Cliente[100]; // Capacidad máxima de 100 clientes
        this.numPeliculas = 0;
        this.numClientes = 0;
    }

    // Método para validar el CIF
    private boolean isCIFValido(String CIF) {
        String regex = "^[A-Z]{1}[0-9]{7}[A-Z]{1}$"; // Ejemplo de regex para CIF
        return Pattern.matches(regex, CIF);
    }

    // Mostrar información del videoclub
    public void mostrarInfoVideoClub() {
        System.out.println("CIF: " + CIF);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de Alta: " + fechaAlta);
    }

    // Mostrar películas registradas
    public void mostrarPeliculasRegistradas() {
        for (int i = 0; i < numPeliculas; i++) {
            System.out.println(peliculasRegistradas[i]);
        }
    }

    // Mostrar clientes registrados
    public void mostrarClientesRegistrados() {
        for (int i = 0; i < numClientes; i++) {
            System.out.println(clientesRegistrados[i]);
        }
    }

    // Alquilar película
    public boolean alquilarPelicula(Pelicula p, Cliente c) {
        if (p.isAlquilada()) {
            System.out.println("La película ya está alquilada.");
            return false;
        } else {
            p.setAlquilada(true);
            c.addPeliculaAlquilada(p);
            System.out.println("Película alquilada con éxito.");
            return true;
        }
    }

    // Devolver película
    public boolean devolverPelicula(Pelicula p, Cliente c) {
        if (!p.isAlquilada()) {
            System.out.println("La película no está alquilada.");
            return false;
        }

        long horasAlquiladas = ChronoUnit.HOURS.between(c.getFechaAlquiler(p), LocalDate.now());
        if (horasAlquiladas > 48) {
            System.out.println("Advertencia: Ha excedido el tiempo máximo de 48 horas.");
        }

        Pelicula.set(false);
        c.removePeliculaAlquilada(p);
        System.out.println("Película devuelta con éxito.");
        return true;
    }

    // Dar de baja a un cliente
    public boolean darBajaCliente(Cliente c) {
        for (int i = 0; i < numClientes; i++) {
            if (clientesRegistrados[i].equals(c)) {
                clientesRegistrados[i] = clientesRegistrados[numClientes - 1]; // Reemplazar con el último
                clientesRegistrados[numClientes - 1] = null; // Eliminar la referencia
                numClientes--;
                System.out.println("Cliente dado de baja con éxito.");
                return true;
            }
        }
        System.out.println("Cliente no encontrado.");
        return false;
    }

  
    public boolean registrarCliente(Cliente c) {
        for (int i = 0; i < numClientes; i++) {
            if (clientesRegistrados[i].equals(c)) {
                System.out.println("Cliente ya registrado.");
                return false;
            }
        }
        if (numClientes < clientesRegistrados.length) {
            clientesRegistrados[numClientes++] = c;
            System.out.println("Cliente registrado con éxito.");
            return true;
        } else {
            System.out.println("No se pueden registrar más clientes.");
            return false;
        }
    }
    // Registrar una película
    public boolean registrarPelicula(Pelicula p) {
        for (int i = 0; i < numPeliculas; i++) {
            if (peliculasRegistradas[i].equals(p)) {
                System.out.println("Película ya registrada.");
                return false;
            }
        }
        if (numPeliculas < peliculasRegistradas.length) {
            peliculasRegistradas[numPeliculas++] = p;
            System.out.println("Película registrada con éxito.");
            return true;
        } else {
            System.out.println("No se pueden registrar más películas.");
            return false;
    }
}

