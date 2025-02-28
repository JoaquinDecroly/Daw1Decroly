import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GestionVideoDaw {
    private String CIF;
    private String direccion;
    private LocalDateTime fechaAlta;
    private ArrayList<Articulo> articulosRegistrados;
    private ArrayList<Cliente> clientesRegistrados;

    public GestionVideoDaw(String CIF, String direccion, LocalDateTime fechaAlta) {
        this.CIF = CIF;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.articulosRegistrados = new ArrayList<>();
        this.clientesRegistrados = new ArrayList<>();
    }

    public String getCIF() {
        return CIF;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void registrarArticulo(Articulo articulo) {
        articulosRegistrados.add(articulo);
    }

    public void registrarCliente(Cliente cliente) throws ClienteDuplicadoException {
        for (Cliente c : clientesRegistrados) {
            if (c.getDni().equals(cliente.getDni())) {
            throw new ClienteDuplicadoException("Error: El cliente con DNI " + cliente.getDni() + " ya está registrado.");

            }
        }
        clientesRegistrados.add(cliente);
    }

    public Cliente buscarClientePorDNI(String dni) {
        for (Cliente cliente : clientesRegistrados) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public Articulo buscarArticuloPorCod(String cod) {
        for (Articulo articulo : articulosRegistrados) {
            if (articulo.getCod().equals(cod)) {
                return articulo;
            }
        }
        return null;
    }

    public void alquilarArticulo(Cliente cliente, Articulo articulo) throws ArticuloYaAlquiladoException {
        if (articulo.isAlquilada()) {
            throw new ArticuloYaAlquiladoException("Error: El artículo ya está alquilado.");

        }
        articulo.alquilar(LocalDateTime.now());
        cliente.alquilar(articulo);
    }

    public void devolverArticulo(Cliente cliente, Articulo articulo) throws DevolucionExcedidaException {
        if (!articulo.isAlquilada()) {
            throw new IllegalArgumentException("Error: El artículo no está alquilado.");

        }

        Duration duracion = Duration.between(articulo.getFechaAlquiler(), LocalDateTime.now());
        long horasTranscurridas = duracion.toHours();

        if (horasTranscurridas > 48) {
            throw new DevolucionExcedidaException("Error: Se ha excedido el tiempo máximo de alquiler (48 horas).");

        }

        articulo.devolver();
        cliente.devolver(articulo);
    }

    public void darBajaCliente(String dni) throws ClienteNoEncontradoException {
        Cliente cliente = buscarClientePorDNI(dni);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Error: Cliente no encontrado.");

        }
        clientesRegistrados.remove(cliente);
    }

    public void darBajaArticulo(String cod) throws ArticuloNoEncontradoException {
        Articulo articulo = buscarArticuloPorCod(cod);
        if (articulo == null) {
            throw new ArticuloNoEncontradoException("Error: Artículo no encontrado.");

        }
        articulosRegistrados.remove(articulo);
    }

    public void mostrarInfoVideoClub() {
        System.out.println("CIF: " + CIF + ", Dirección: " + direccion + ", Fecha Alta: " + fechaAlta);
    }

    public void mostrarArticulosRegistrados() {
        System.out.println("Artículos registrados:");
        if (articulosRegistrados.isEmpty()) {
            System.out.println("No hay artículos registrados.");
        } else {
            for (Articulo articulo : articulosRegistrados) {
                System.out.println(articulo);
            }
        }
    }

    public void mostrarClientesRegistrados() {
        System.out.println("Clientes registrados:");
        if (clientesRegistrados.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientesRegistrados) {
                System.out.println(cliente);
            }
        }
    }
}
