import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        // Verificar conexión a la base de datos
        if (SQLManager.getConecction() != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Error al conectar con la base de datos.");
            return;
        }

        Cuentas cuentas = new Cuentas(); // Inicializar lista cuentas

        CuentaBancaria cuentaActual = null;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Bienvenido a su banco de confianza");
            System.out.println("\nPrimero debe crear una cuenta bancaria.");
            System.out.println("Pulse 0 si desea crear una nueva cuenta");
            System.out.println("Pulse 1 si desea usar una cuenta existente");
            String opcion0 = sc.nextLine();
            
            if (opcion0.equals("0")) {
                cuentaActual = crearCuenta(sc);
            }
            if (opcion0.equals("1")) {
                cuentaActual = cambiarCuenta(sc);
            }
            

            String opcion1;
            do {
                System.out.println("\n--- Menú Bancario ---");
                System.out.println("1. Crear cuenta bancaria");
                System.out.println("2. Cambiar de cuenta");
                System.out.println("3. Depositar dinero");
                System.out.println("4. Retirar dinero");
                System.out.println("5. Transferir dinero a otra cuenta (bizum)");
               
                System.out.println("6. Consultar cuentas bancarias");
                System.out.println("7. Eliminar cuenta bancaria"); 
                System.out.println("8. Consultar saldo de cuenta");
                System.out.println("9. Consultar movimientos de cuenta");
                System.out.println("10. Salir");
                System.out.print("Seleccione una opción: ");
                opcion1 = sc.nextLine();

                switch (opcion1) {
                    case "1":
                        cuentaActual = crearCuenta(sc);
                        break;
                    case "2":
                        cuentaActual = cambiarCuenta(sc);
                        break;
                    case "3":
                        if (cuentaActual != null) {
                            depositarDinero(sc, cuentaActual);
                        } else {
                            System.out.println("Primero debe seleccionar una cuenta.");
                        }
                        break;
                    case "4":
                        if (cuentaActual != null) {
                            retirarDinero(sc, cuentaActual);
                        } else {
                            System.out.println("Primero debe seleccionar una cuenta.");
                        }
                        break;
                    case "5":
                        if (cuentaActual != null) {
                            transferirDinero(sc, cuentaActual);
                        } else {
                            System.out.println("Primero debe seleccionar una cuenta.");
                        }
                        break;
                    case "6":
                        consultarCuentas();
                        break;
                    case "7":
                        eliminarCuenta(sc);
                        break;
                    case "8":
                        System.out.println("Proporcione el iban de la cuenta: ");
                        String iban0 = sc.nextLine();
                        for (CuentaBancaria cuentaBancaria : cuentas.getCuentas()) {
                            if (cuentaBancaria.getIban().equals(iban0)) {
                                Map<String, Double> saldo = SQLAccessBase.getSaldoFromVista(iban0);
                            }
                        }
                        break;
                    case "9":
                        System.out.println("Proporcione el iban de la cuenta: ");
                        String iban = sc.nextLine();
                        for (CuentaBancaria cuentaBancaria : cuentas.getCuentas()) {
                            if (cuentaBancaria.getIban().equals(iban)) {
                                List<Movimientos> movimientos = SQLAccessBase.getMovimientosFromCuenta(iban);
                            }
                        }
                        break;
                    case "10":
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (!opcion1.equals("10"));
        }
    }


    private static void eliminarCuenta(Scanner sc) {
        System.out.print("Ingrese el IBAN de la cuenta a eliminar: ");
        String iban = sc.nextLine();
        if (!SQLAccessBase.getCuentasBancarias().isEmpty()) {
            SQLAccessBase.eliminarCuentaBancaria(iban);
        }
    }

    private static CuentaBancaria crearCuenta(Scanner sc) {
        while (true) {
            String iban = obtenerIbanValido(sc);
            String titular = validarNombre(sc);

            try {
                List<CuentaBancaria> cuentas = SQLAccessBase.getCuentasBancarias();

                for (CuentaBancaria cuenta : cuentas) {
                    if (cuenta.getIban().equals(iban)) {
                        System.out.println("La cuenta ya existe.");
                        return cuenta;// Devuelve la cuenta existente
                    }
                }

                CuentaBancaria nuevaCuenta = new CuentaBancaria(iban, titular, 0);
                SQLAccessBase.addCuentaBancaria(nuevaCuenta);
                System.out.println("Cuenta creada exitosamente.");
                return nuevaCuenta;
            } catch (Exception e) {
                crearCuenta(sc);
            }
        
        }
    }

    private static CuentaBancaria cambiarCuenta(Scanner sc) {
        System.out.print("Ingrese el IBAN de la cuenta a seleccionar: ");
        String iban = sc.nextLine();
        List<CuentaBancaria> cuentas = SQLAccessBase.getCuentasBancarias();
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getIban().equals(iban)) {
                System.out.println("Cuenta seleccionada: " + cuenta);
                return cuenta;
            }
        }
        System.out.println("Cuenta no encontrada.");
        return null;
    }

    private static void depositarDinero(Scanner sc, CuentaBancaria cuenta) {
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = sc.nextDouble();
        sc.nextLine();
        cuenta.depositar(cantidad);
        System.out.println("Depósito realizado exitosamente.");
    }

    private static void retirarDinero(Scanner sc, CuentaBancaria cuenta) {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = sc.nextDouble();
        sc.nextLine();
        cuenta.retirar(cantidad);
    }

    private static void transferirDinero(Scanner sc, CuentaBancaria cuentaOrigen) {
        System.out.print("Ingrese el IBAN de la cuenta destino: ");
        String ibanDestino = sc.nextLine();
        System.out.print("Ingrese la cantidad a transferir: ");
        double cantidad = sc.nextDouble();
        sc.nextLine();

        List<CuentaBancaria> cuentas = SQLAccessBase.getCuentasBancarias();
        for (CuentaBancaria cuentaDestino : cuentas) {
            if (cuentaDestino.getIban().equals(ibanDestino)) {
                cuentaOrigen.transferir(cantidad, cuentaDestino);
                System.out.println("Transferencia realizada exitosamente.");
                return;
            }
        }
        System.out.println("Cuenta destino no encontrada.");
    }

    private static void consultarCuentas() {
        List<CuentaBancaria> cuentas = SQLAccessBase.getCuentasBancarias();
        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
        } else {
            System.out.println("\n--- Cuentas Bancarias ---");
            for (CuentaBancaria cuenta : cuentas) {
                System.out.println(cuenta);
            }
        }
    }
    
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

    public static String validarNombre(Scanner scanner){
        String nombre;
        while (true) {
            System.out.println("Ingrese su nombre (Aaaaaaaa Aaaaaaaa): ");
            nombre = scanner.nextLine();
            if (validarNombre(nombre)) {
                return nombre;
            }
            System.out.println("Nombre inválido. Por favor, inténtelo de nuevo.");
        }
    }
    private static boolean validarNombre(String nombre) {
        return nombre.matches("(?<!\\S)([A-Z][a-z]*)(\\s+[A-Z][a-z]*)*");
    }


}
    



    
