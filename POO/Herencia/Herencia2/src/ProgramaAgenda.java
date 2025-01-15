import java.util.Scanner;

public class ProgramaAgenda {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String option = "";
    

    do {
        System.out.println("1. Anadir contacto a la agenda");
        System.out.println("2. Eliminar contacto de la agenda");
        System.out.println("3. Buscar contacto en la agenda");
        System.out.println("4. Listar agenda");
        option = scanner.nextLine();
        switch (option) {
            case "1":
           System.out.println("Nombre: ");
           String name = scanner.nextLine();

            Agenda.agregarContacto(name);
            break;
            case "2":
            System.out.println("Nombre del contacto a eliminar: ");
            String name2 = scanner.nextLine();
            Agenda.eliminarContacto(name2);
            Agenda.recolocarArrayContactos(contacto);
            break;

            case "3":
            System.out.println("Nombre del contacto a buscar: ");
            String name3 = scanner.nextLine();
            Agenda.buscarContacto(name3);
            break;

            case "4":
            Agenda.listarAgenda();
    } 
}while (!option.equals("0"));
}
}
