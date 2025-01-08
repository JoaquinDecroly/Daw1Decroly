import java.time.LocalDate;

public class Inventario {
    private Tipo tipo = Tipo.PERRO;
    private Estado estado = Estado.ACTIVO;
    private Color color = Color.DESCONOCIDO;
    private int edad = 0;
    private String nombre = "";
    private final LocalDate fechaNacimiento;
    private final LocalDate fechaMuerte;
    private int contM;

    public Mascotas[] mascotas;

    public Inventario(String nombre, int edad, Color color, Estado estado, Tipo tipo, LocalDate fechaNacimiento, LocalDate fechaMuerte, Mascotas[] mascotas) {
        this.fechaNacimiento = fechaNacimiento;
        this.fechaMuerte = fechaMuerte;
        this.edad = calcularEdad(fechaNacimiento);
        this.tipo = tipo;
        this.estado = estado;
        this.nombre = nombre;
        this.contM = 0;
    
    }
    

    //getters y setters
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Color getColor() {
        return color;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public LocalDate getFechaMuerte() {
        return fechaMuerte;
    }
    public Mascotas[] getMascotas() {
        return mascotas;
    }
    public void setMascotas(Mascotas[] mascotas) {
        this.mascotas = mascotas;
    }




//metodos
    public int calcularEdad(LocalDate fechaNacimiento) {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    public void agregarMascota(Mascotas mascota) {
        if (contM < mascotas.length) {
            mascotas[contM] = mascota;
            contM++;
        } else {
            System.out.println("No hay espacio para agregar mas mascotas");
        }
    }

    public void eliminarMascota(Mascotas mascota){
        int index = -1;
        for (int i = 0; i < contM; i++) {
            if (mascotas[i].equals(mascota)) {
                index = i;
                break;
            }
        }
        
        
        if (index == -1) {
            System.out.println("No se encontró la mascota a eliminar");
            return;
        }

       
    }
    public void recolocarArrayyMacotas(Mascotas mascota){
        int index = -1;
        //desplazar elementos a la izq.
        for (int i = index; i < contM; i++) {
            mascotas[i] = mascotas[i + 1];
        }
        //último elemento es null
        mascotas[contM -1] = null;
        contM--;
    }
    public void vaciarInventarioMascotas() {
        for (int i = 0; i < mascotas.length; i++) {
            mascotas[i] = null;
            contM++;
            
        }
    }
    public void mostrarInventarioMacotas(){
        for (int i = 0; i < mascotas.length; i++) {
            String info = "";
            info = String.format("Macota" + i++ + "{ , Nombre= %s, Tipo= %s, estado= %s, fechaNacimiento= %s, edad= %s,");
        }
    }
    
    
    }


