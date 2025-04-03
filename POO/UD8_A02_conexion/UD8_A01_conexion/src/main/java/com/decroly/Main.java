package com.decroly;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseCredentials credentials = new DatabaseCredentials;
        CredentialManager.writeCredentials("resources/productos.dat", credentials);

        // Leer credenciales desde el archivo
        DatabaseCredentials loadedCredentials = CredentialManager.readCredentials("credentials.dat");

        if (loadedCredentials != null) {
            // Usar las credenciales para conectarse a la base de datos
            SQLDataBaseManager dbManager = new SQLDataBaseManager();
            try (Connection connection = dbManager.getConnection(loadedCredentials)) {
                System.out.println("Conexión exitosa a la base de datos.");
                // Aquí puedes implementar el menú y las funcionalidades
            } catch (SQLException e) {
                e.printStackTrace();
                // Manejo de errores de conexión
            }
        } else {
            System.out.println("No se pudieron cargar las credenciales.");
        }
    }
    //Menú de opciones
        System.out.println("Bienvenido al sistema de gestión de inventario.");
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case "1":
                    System.out.println("Mostrando todos los Productos en el Inventario...");
                    SQLAccessBase.getProductos();
                    break;
                case "2":
                    System.out.println("Mostrando todos los Productos en el Inventario...");
                    SQLAccessBase.getProductos();
                    System.out.println("Ingrese la referencia del producto: ");
                    String ref = scanner.nextLine();
                    System.out.println("Buscando producto por referencia...");
                    try{
                        Thread.sleep(1000);
                            SQLAccessBase.getProductoByReferencia(ref);
                    } catch (InterruptedException e) {
                      e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("Mostrando todos los Productos en el Inventario...");
                    SQLAccessBase.getProductos();
                    System.out.println("Ingrese el tipo del producto: (valor entero) ");
                    int tipe = scanner.nextInt();
                    System.out.println("Buscando productos por tipo...");
                    try{
                        Thread.sleep(1000);
                        SQLAccessBase.getProductoByTipo(tipe);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "4":
                    System.out.println("Mostrando todos los Productos en el Inventario...");
                    SQLAccessBase.getProductos();
                    System.out.println("Ingrese la cantidad del producto: ");
                    int cant = scanner.nextInt();
                    System.out.println("Buscando producto por cantidad...");
                    try{
                        Thread.sleep(1000);
                        SQLAccessBase.getProductoByCantidad(cant);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "5":
                    System.out.println("Insertando un nuevo producto...");
                    // Lógica para insertar un nuevo producto
                    break;
                case "6":
                    System.out.println("Eliminando Producto por referencia...");
                    // Lógica para eliminar producto por referencia
                    break;
                case "7":
                    System.out.println("Actualizando producto...");
                    // Lógica para actualizar producto
                    break;
                case "8":
                    System.out.println("Insertando un nuevo tipo de producto...");
                    // Lógica para insertar un nuevo tipo de producto
                    break;
                case "9":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (!opcion.equals("9"));

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\nBienvenido al sistema de gestión de inventario.");
        System.out.println("Por favor, seleccione una opción:");
        System.out.println("1. Mostrar todos los Productos en el Inventario.");
        System.out.println("2. Buscar producto por referencia.");
        System.out.println("3. Buscar productos por tipo.");
        System.out.println("4. Buscar producto por cantidad.");
        System.out.println("5. Insertar un nuevo producto (no permitir referencias repetidas).");
        System.out.println("6. Eliminar Producto por referencia.");
        System.out.println("7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto).");
        System.out.println("8. Insertar un nuevo tipo de producto.");
        System.out.println("9. Salir.");
    }

    }
}
