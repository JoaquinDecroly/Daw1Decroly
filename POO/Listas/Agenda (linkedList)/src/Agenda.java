import java.util.LinkedList;
import java.util.Scanner;

public class Agenda {
    Scanner scanner = new Scanner(System.in);
    private LinkedList<Contacto> linkedList = new LinkedList<>();
    Agenda agenda = new Agenda();
    Contacto contacto;



void anadeElemento(Contacto contacto){
    System.out.println("Nombre: ");
    String nombre = scanner.nextLine();

    if (!agenda.equals(nombre)) {
        System.out.println("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Telefono: ");
        String telefono = scanner.nextLine();
        System.out.println("Correo: ");
        String correo = scanner.nextLine();
        Contacto c1 = new Contacto(nombre, telefono, Contacto.validaEmail(correo));
        agenda.anadeElemento(c1);
} else {
        System.out.println("El contacto ya existe");
    }
}

void eliminaElemento(String nombre){
    if (contacto.getNombre().equals(nombre)) {
        agenda.buscaContacto(linkedList, nombre);
        agenda.eliminaElemento(nombre);
        System.out.println("El contacto ha sido eliminado");
    } else {
        System.out.println("El contacto no existe");
    }
}

public boolean buscaContacto(LinkedList<Contacto> linkedList, String nombre) {
for (Contacto contacto : linkedList) {
    if (contacto.getNombre().equals(nombre)) {
        return true;
    }
}
   return false;
}
}

