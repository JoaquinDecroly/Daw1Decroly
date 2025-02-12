import java.time.LocalDate;
import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CuentaBancaria cuenta;
            
            System.out.println("Bienvenido a DawBank");
            
            String iban = obtenerIbanValido(sc);
            // Crear la cuenta bancaria
            cuenta = new CuentaBancaria(iban, crearCliente(sc));
            
            int opcion;
            do {
                opcion = mostrarMenu(sc);
                procesarOpcion(opcion, cuenta, sc);
            } while (opcion != 8);
        }
    }

    private static int mostrarMenu(Scanner scanner) {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    private static void procesarOpcion(int opcion, CuentaBancaria cuenta, Scanner scanner) {
        scanner.nextLine(); 
        switch (opcion) {
            case 1:
                cuenta.mostrarDatos();
                break;
            case 2:
                System.out.println("IBAN: " + cuenta.getIban());
                break;
            case 3:
                System.out.println("Titular: " + cuenta.getCliente().getNombre());
                break;
            case 4:
                System.out.println("Saldo: " + cuenta.getSaldo());
                break;
            case 5:
                realizarIngreso(cuenta, scanner);
                break;
            case 6:
                realizarRetirada(cuenta, scanner);
                break;
            case 7:
                System.out.println("Historial de movimientos:");
                cuenta.mostrarMovimientos();
                break;
            case 8:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }


//tipos de movimiento
    private static void realizarIngreso(CuentaBancaria cuenta, Scanner scanner) {
        System.out.print("Ingrese la cantidad a ingresar: ");
        double cantidadIngreso = scanner.nextDouble();
        try {
            cuenta.ingresar(cantidadIngreso);
            cuenta.AvisarHaciendaException(cantidadIngreso); 
        } catch (AvisarHaciendaException e) {
            System.err.println("Movimiento de 3000€ o superior. Avise a Hacienda: " + e.getMessage());
           e.printStackTrace();
        }
    }

    private static void realizarRetirada(CuentaBancaria cuenta, Scanner scanner) {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidadRetirada = scanner.nextDouble();
        try {
            cuenta.retirar(cantidadRetirada);
            cuenta.SaldoNegativoException(cantidadRetirada); 
        } catch (SaldoNegativoException e) {
           System.err.println("Saldo inferior o igual a límite de -50€. Error: " + e.getMessage());
           e.printStackTrace();
        }
    }

    

//crear cliente
    private static Cliente crearCliente(Scanner scanner) {
    System.out.print("Ingrese el DNI del cliente: ");
    String DNI = scanner.nextLine();

    System.out.print("Ingrese el nombre del cliente: ");
    String nombre = scanner.nextLine();
        
    LocalDate fechaNacimiento = LocalDate.now();
    while (!fechaNacimiento.equals(LocalDate.now())) {
    try {
        System.out.print("Ingrese la fecha de nacimiento : ");
        fechaNacimiento = LocalDate.parse(scanner.nextLine());
        Persona.validarFechaNacimiento(fechaNacimiento);
    
    } catch (FechaException e) {
        System.err.println("Fecha de Nacimiento no válida. Error: " + e.getMessage());
        e.printStackTrace();
    }
}
    System.out.print("Ingrese el teléfono del cliente: ");
    String telefono = scanner.nextLine();

    System.out.print("Ingrese el email del cliente: ");
    String email = scanner.nextLine();

    System.out.print("Ingrese la dirección del cliente: ");
    String direccion = scanner.nextLine();

    return new Cliente(DNI, nombre, fechaNacimiento, telefono, email, direccion);
}



//validador iban
private static String obtenerIbanValido(Scanner scanner) {
        String iban;
        while (true) {
            System.out.print("Ingrese el IBAN (formato: XX0000000000000000000000): ");
            iban = scanner.nextLine();
            if (validarIban(iban)) {
                return iban;
            }
            System.out.println("IBAN inválido. Por favor, inténtelo de nuevo.");
        }
    }
    private static boolean validarIban(String iban) {
        return iban.matches("[A-Z]{2}\\d{22}");
    }

    //validar email
    public static String validarCorreo(Scanner scanner){
        String email;
        while (true) {
            System.out.println("Ingrese su correo: ");
            email = scanner.nextLine();
            if (validarCorreo(email)) {
                return email;
            }
            System.out.println("Correo inválido. Por favor, inténtelo de nuevo.");
        }
    }
    private static boolean validarCorreo(String email) {
       return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

}
