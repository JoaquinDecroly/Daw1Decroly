public class Agenda {
    private Contacto[] contactos;
    private int contador; // Para llevar el número de contactos añadidos

    public Agenda() {
        this.contactos = new Contacto[10]; // Array de tamaño 10
        this.contador = 0; // Inicializamos el contador
    }

    public boolean añadirContacto(Contacto c) {
        // Verificar si el contacto ya existe
        for (int i = 0; i < contador; i++) {
            if (contactos[i].getnombre().equalsIgnoreCase(c.getnombre())) {
                // El contacto ya existe, no se añade
                return false; // Indica que no se ha añadido
            }
        }

        // Verificar si hay espacio en el array
        if (contador < contactos.length) {
            // Si no existe, añadir el contacto
            contactos[contador] = c;
            contador++; // Incrementar el contador
            return true; // Indica que se ha añadido
        } else {
            System.out.println("No se puede añadir el contacto. La agenda está llena.");
            return false; // Indica que no se ha añadido
        }
    }

    public boolean eliminarContacto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i].getnombre().equalsIgnoreCase(nombre)) {
                // Desplazar contactos hacia la izquierda
                for (int j = i; j < contador - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                contactos[contador - 1] = null; // Limpiar la última posición
                contador--; // Decrementar el contador
                return true; // Indica que se ha eliminado
            }
        }
        return false; // Indica que no se encontró el contacto
    }

   
    public void listarContactos() {
        if (contador == 0) {
            System.out.println("No hay contactos en la agenda.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println("Nombre: " + contactos[i].getnombre() + ", Teléfono: " + contactos[i].gettelefono());
        }
    }

    public int buscaContacto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i].getnombre().equalsIgnoreCase(nombre)) {
                return i; // Retorna la posición del contacto
            }
        }
        return -1; // Indica que no se encontró el contacto
    }
}