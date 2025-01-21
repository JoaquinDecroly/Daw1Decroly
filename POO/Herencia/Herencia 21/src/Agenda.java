public class Agenda {
    private Contacto[] contactos;
    private int contador;

    public boolean añadirContacto(Contacto c) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(c.getNombre())) {
                return false;
            }
        }
        if (contador < contactos.length) {
            contactos[contador] = c;
            contador++;
            return true;
        } else {
            System.out.println("No se puede añadir el contacto. La agenda está llena.");
            return false;
        }
    }

    public boolean eliminarContacto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < contador - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                contactos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public void listarContactos() {
        if (contador == 0) {
            System.out.println("No hay contactos en la agenda.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println(contactos[i].toString());
        }
    }

    public int buscaContacto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }
}
