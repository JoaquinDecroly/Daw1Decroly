import java.util.LinkedList;

public class Agenda {
    private LinkedList<Contacto> linkedList = new LinkedList<>();
        Contacto contacto;


public boolean añadirContacto (Contacto c) {
    if (linkedList.contains(c)) {
        return false;
    }
    linkedList.add(c);
    return true;
}

public boolean eliminarContacto(String nombre) {
    for (Contacto contacto : linkedList) {
        if (contacto.getNombre().equalsIgnoreCase(nombre)) {
            linkedList.remove(contacto);
            return true;
        }
    }
    return false;
}

public void numeroContactos () {
    System.out.println(linkedList.size());
}

public void listarContactos() {
    if (linkedList.isEmpty()) {
        System.out.println("No hay contactos en la agenda.");
        return;
    }
    for (Contacto contacto : linkedList) {
        System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono() + ", Correo: " + contacto.getCorreo());
    }
}

public int buscaContacto(String nombre) {
    int index = 0;
    for (Contacto contacto : linkedList) {
        if (contacto.getNombre().equalsIgnoreCase(nombre)) {
            return index;
        }
        index++;
    }
    return -1;
}}

