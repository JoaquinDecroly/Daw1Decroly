import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

public abstract class Articulo {
    protected String cod;
    protected String titulo;
    protected LocalDate fechaRegistro;
    protected LocalDate fechaBaja;
    protected LocalDateTime fechaAlquiler; // Change to LocalDateTime
    protected boolean isAlquilada; // Add isAlquilada variable


    public Articulo(String cod, String titulo, LocalDate fechaRegistro) {
        this.cod = cod;
        this.titulo = titulo;
        this.fechaRegistro = fechaRegistro;
    }

    public String getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public boolean isAlquilada() {
        return isAlquilada; // Implement the method to return the state of isAlquilada
    }


    @Override
    public String toString() {
        return "Código: " + cod + ", Título: " + titulo + ", Fecha Registro: " + fechaRegistro +
                (fechaBaja != null ? ", Fecha Baja: " + fechaBaja : "");
    }

    public void devolverArticulo(Cliente cliente, Articulo articulo) throws DevolucionExcedidaException {
    // Verificar si el artículo está alquilado
    if (!articulo.isAlquilada()) {
        throw new IllegalArgumentException("El artículo no está alquilado.");
    }

    // Calcular la duración del alquiler
    LocalDateTime ahora = LocalDateTime.now();
    Duration duracion = Duration.between(articulo.getFechaAlquiler(), ahora);
    long horasTranscurridas = duracion.toHours();

    // Verificar si se excede el tiempo máximo de 48 horas
    if (horasTranscurridas > 48) {
        throw new DevolucionExcedidaException("Se ha excedido el tiempo máximo de alquiler (48 horas).");
    }

    // Devolver el artículo
    articulo.devolverArticulo(cliente, articulo); // Marcar el artículo como no alquilado
    cliente.devolver(articulo); // Eliminar el artículo de la lista de artículos alquilados del cliente

    System.out.println("Artículo devuelto exitosamente.");
}

public void alquilar(LocalDateTime fechaAlquiler) {
    if (isAlquilada()) {
        throw new IllegalArgumentException("El artículo ya está alquilado.");
    }
    this.fechaAlquiler = fechaAlquiler; // Establecer la fecha de alquiler
    this.isAlquilada = true; // Marcar como alquilado
}

    public void devolver() {
        this.fechaAlquiler = null; // Ensure this is set correctly
        this.isAlquilada = false; // Mark as not rented

}

    Temporal getFechaAlquiler() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
