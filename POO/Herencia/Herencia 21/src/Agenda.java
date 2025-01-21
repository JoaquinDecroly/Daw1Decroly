public class Agenda {
private Contacto[] contactos; // Array de contactos
private int contador; // Contador de contactos añadidos

public Agenda() {
this.contactos = new Contacto[10]; // Inicializar el array con tamaño 10
this.contador = 0; // Inicializar el contador
}

public boolean añadirContacto(Contacto c) {
// Verificar si el contacto ya existe
for (int i = 0; i < contador; i++) {
if (contactos[i].getNombre().equalsIgnoreCase(c.getNombre())) {
return false; // El contacto ya existe
}
}

// Añadir el nuevo contacto si hay espacio
if (contador < contactos.length) {
contactos[contador] = c; // Añadir contacto al array
contador++; // Incrementar el contador
return true;
} else {
System.out.println("No se puede añadir el contacto. La agenda está llena.");
return false;
}
}

public boolean eliminarContacto(String nombre) {
for (int i = 0; i < contador; i++) {
if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
// Desplazar los contactos hacia la izquierda
for (int j = i; j < contador - 1; j++) {
contactos[j] = contactos[j + 1];
}
contactos[contador - 1] = null; // Limpiar la última posición
contador--; // Decrementar el contador
return true; // Contacto eliminado
}
}
return false; // No se encontró el contacto
}

public void listarContactos() {
if (contador == 0) {
System.out.println("No hay contactos en la agenda.");
return;
}
for (int i = 0; i < contador; i++) {
System.out.println(contactos[i].toString()); // Mostrar información del contacto
}
}

public int buscaContacto(String nombre) {
for (int i = 0; i < contador; i++) {
if (contactos[i].getNombre().equalsIgnoreCase(nombre)) {
return i; // Retornar la posición del contacto
}
}
return -1; // No se encontró el contacto
}
}
