import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CuentaBancaria cuenta;
            
            System.out.println("Bienvenido a DawBank");
            
            String iban = obtenerIbanValido(sc);
            
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

// MOVIMIENTOS
// ------------------------------
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
    String DNI = null;
    validarDni(scanner);

    String nombre = null;
    validarNombre(scanner);
        
    String fechaNacimiento = null;
    validarFechaNacimiento(scanner);
   
    String telefono = null;
    validarMovil(scanner);
    
    String email = null;
    validarCorreo(scanner);

    System.out.print("Ingrese la dirección del cliente: ");
    String direccion = scanner.nextLine();

    return new Cliente(DNI, nombre, fechaNacimiento, telefono, email, direccion);
}


//VALIDADORES
// ---------------------------
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

    //validar telefono
    public static String validarTelefono(Scanner scanner){
        String telefono;
        while (true) {
            System.out.println("Introduzca el telefono: ");
            telefono = scanner.nextLine();
            if (validarTelefono(telefono)) {
                return telefono;
                }
                System.out.println("Teléfono inválido. Por favor, inténtelo de nuevo.");
    }

}
    private static boolean validarTelefono(String telefono) {
        return telefono.matches("^\\d{9}$");
    }



    //validar nombre
    public static String validarNombre(Scanner scanner){
        String nombre;
        while (true) {
            System.out.println("Ingrese su nombre: ");
            nombre = scanner.nextLine();
            if (validarNombre(nombre)) {
                return nombre;
                }
                System.out.println("Nombre inválido. Por favor, inténtelo de nuevo.");
                }
    }
    private static boolean validarNombre(String nombre) {
        return nombre.matches("(?<!\\S)([A-Z][a-z]*)(\\s+[a-z]+)*");
        }

    //validar movil
    public static String validarMovil(Scanner scanner){
        String telefono;
        while (true) {
            System.out.println("Ingrese su telefono: ");
            telefono = scanner.nextLine();
            if (validarMovil(telefono)) {
                return telefono;
            }
            System.out.println("Telefono inválido. Por favor, inténtelo de nuevo.");
        }
    }
    private static boolean validarMovil(String telefono) {
        return telefono.matches("^[679]\\d{8}$");
        }

    //validar dni
    public static String validarDni(Scanner scanner){
        String DNI;
        while (true) {
            System.out.println("Ingrese su dni: ");
            DNI = scanner.nextLine();
        if (validarDni(DNI)) {
            return DNI;
        }
        System.out.println("DNI inválido. Por favor, inténtelo de nuevo.");
        }
    }
    private static boolean validarDni(String dni) {
        return dni.matches("^[0-9]{8}[A-Z]$");
    }


    //validar fechaNacimiento
private static String validarFechaNacimiento(Scanner scanner) {
    String fechaNacimiento;
    while (true) {
        System.out.print("Ingrese la fecha de nacimiento (dd/MM/yyyy): ");
        fechaNacimiento = scanner.nextLine();
        if (validarFecha(fechaNacimiento)) {
            return fechaNacimiento;
        }
        System.out.println("Fecha de nacimiento inválida. Por favor, inténtelo de nuevo.");
    }
}

private static boolean validarFecha(String fechaNacimiento) {
    String[] fecha = fechaNacimiento.split("/");
    if (fecha.length != 3) {
        return false;
    }
    int dia = Integer.parseInt(fecha[0]);
    int mes = Integer.parseInt(fecha[1]);
    int anio = Integer.parseInt(fecha[2]);
    return dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && anio >= 1900 && anio <= 2023;
}

}




