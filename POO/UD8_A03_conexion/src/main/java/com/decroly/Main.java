package com.decroly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.decroly.*;


public class Main {
    public static void main(String[] args) {
        String rutaArchivo = "resources/application.dat";

        // Leer credenciales desde el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String driver = br.readLine();
            String url = br.readLine();
            String schema = br.readLine();
            String usuario = br.readLine();
            String clave = br.readLine();


        } catch (IOException e) {
            System.err.println("Error al leer el archivo de credenciales: " + e.getMessage());
            return; // Salir si no se pueden leer las credenciales
        }

        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los Productos en el Inventario.");
            System.out.println("2. Buscar producto por referencia.");
            System.out.println("3. Buscar productos por tipo.");
            System.out.println("4. Buscar producto por cantidad.");
            System.out.println("5. Insertar un nuevo producto (no permitir referencias repetidas).");
            System.out.println("6. Eliminar Producto por referencia.");
            System.out.println("7. Actualizar producto.");
            System.out.println("8. Insertar un nuevo tipo de producto.");
            System.out.println("9. Salir.");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    List<String> productos = SQLAccessBase.getProductos();
                    if (productos.isEmpty()) {
                        System.out.println("No hay productos en el inventario.");
                    } else {
                        for (String p : productos) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "2":
                    System.out.print("Ingrese la referencia del producto: ");
                    String ref = scanner.nextLine();
                    List<String> productosPorReferencia = SQLAccessBase.getProductoByReferencia(ref);
                    if (productosPorReferencia.isEmpty()) {
                        System.out.println("No se encontró ningún producto con la referencia: " + ref);
                    } else {
                        for (String p : productosPorReferencia) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "3":
                    System.out.print("Ingrese el tipo del producto (valor entero): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    List<String> productosPorTipo = SQLAccessBase.getProductoByTipo(tipo);
                    if (productosPorTipo.isEmpty()) {
                        System.out.println("No se encontraron productos del tipo: " + tipo);
                    } else {
                        for (String p : productosPorTipo) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "4":
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    List<String> productosPorCantidad = SQLAccessBase.getProductoByCantidad(cantidad);
                    if (productosPorCantidad.isEmpty()) {
                        System.out.println("No se encontraron productos con la cantidad: " + cantidad);
                    } else {
                        for (String p : productosPorCantidad) {
                            System.out.println(p);
                        }
                    }
                    break;

                case "5":
                    System.out.print("Ingrese la referencia del nuevo producto: ");
                    String referencia = scanner.nextLine();
                    if (SQLAccessBase.existeReferencia(referencia)) {
                        System.out.println("La referencia ya existe. No se puede insertar el producto.");
                    } else {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la descripción del producto: ");
                        String descripcion = scanner.nextLine();

                        // Mostrar tipos de productos desde el enum Tipo
                        int tipoProducto;
                        do {
                            System.out.println("Tipos de productos disponibles:");
                            for (Tipo tipoEnum : Tipo.values()) {
                                System.out.println(tipoEnum.ordinal() + 1 + ". " + tipoEnum.name());
                            }
                            System.out.print("Seleccione un tipo de producto (número): ");
                            tipoProducto = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer

                            if (tipoProducto < 1 || tipoProducto > Tipo.values().length) {
                                System.out.println("Tipo de producto no válido. Por favor, intente de nuevo.");
                            }
                        } while (tipoProducto < 1 || tipoProducto > Tipo.values().length);

                        System.out.print("Ingrese la cantidad: ");
                        int nuevaCantidad = scanner.nextInt();
                        System.out.print("Ingrese el precio: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Ingrese el descuento: ");
                        int descuento = scanner.nextInt();
                        System.out.print("Ingrese el IVA: ");
                        int iva = scanner.nextInt();
                        System.out.print("¿Aplicar descuento? (true/false): ");
                        boolean aplicarDto = scanner.nextBoolean();
                        scanner.nextLine(); // Limpiar el buffer

                        // Insertar el producto usando el tipo seleccionado
                        SQLAccessBase.insertProducto(new Producto(referencia, nombre, descripcion, tipoProducto, nuevaCantidad, precio, descuento, iva, aplicarDto));
                        System.out.println("Producto insertado exitosamente.");
                    }
                    break;

                case "6":
                    System.out.print("Ingrese la referencia del producto a eliminar: ");
                    String referenciaEliminar = scanner.nextLine();
                    SQLAccessBase.deleteProductoByReferencia(referenciaEliminar);
                    System.out.println("Producto eliminado exitosamente.");
                    break;

                case "7":
                    System.out.print("Ingrese la referencia del producto a actualizar: ");
                    String referenciaActualizar = scanner.nextLine();
                    List<String> productoActualizar = SQLAccessBase.getProductoByReferencia(referenciaActualizar);
                    if (productoActualizar.isEmpty()) {
                        System.out.println("No se encontró ningún producto con la referencia: " + referenciaActualizar);
                    } else {
                        // Asumiendo que solo hay un producto por referencia
                        String[] datosProducto = productoActualizar.get(0).split(","); // Ajusta según el formato de tu toString
                        Producto p = new Producto(datosProducto[0], datosProducto[1], datosProducto[2], Integer.parseInt(datosProducto[3]), Integer.parseInt(datosProducto[4]), Double.parseDouble(datosProducto[5]), Integer.parseInt(datosProducto[6]), Integer.parseInt(datosProducto[7]), Boolean.parseBoolean(datosProducto[8]));

                        System.out.print("Ingrese el nuevo nombre (actual: " + p.getNombre() + "): ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese la nueva descripción (actual: " + p.getDesc() + "): ");
                        String nuevaDescripcion = scanner.nextLine();
                        System.out.print("Ingrese la nueva cantidad (actual: " + p.getCantidad() + "): ");
                        int nuevaCantidad = scanner.nextInt();
                        System.out.print("Ingrese el nuevo precio (actual: " + p.getPrecio() + "): ");
                        double nuevoPrecio = scanner.nextDouble();
                        System.out.print("Ingrese el nuevo descuento (actual: " + p.getDescuento() + "): ");
                        int nuevoDescuento = scanner.nextInt();
                        System.out.print("Ingrese el nuevo IVA (actual: " + p.getIva() + "): ");
                        int nuevoIva = scanner.nextInt();
                        System.out.print("¿Aplicar descuento? (true/false): ");
                        boolean nuevoAplicarDto = scanner.nextBoolean();
                        scanner.nextLine(); // Limpiar el buffer

                        SQLAccessBase.updateProducto(new Producto(referenciaActualizar, nuevoNombre, nuevaDescripcion, p.getTipo(), nuevaCantidad, nuevoPrecio, nuevoDescuento, nuevoIva, nuevoAplicarDto));
                        System.out.println("Producto actualizado exitosamente.");
                    }
                    break;

                case "8":
                    System.out.print("Ingrese el nombre del nuevo tipo de producto: ");
                    String nuevoTipoProducto = scanner.nextLine();
                    SQLAccessBase.insertarTipoProducto(nuevoTipoProducto);
                    System.out.println("Tipo de producto '" + nuevoTipoProducto + "' insertado exitosamente.");
                    break;

                case "9":
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!opcion.equals("9")); // Cambiado a !opcion.equals("9") para salir correctamente

        scanner.close(); // Cerrar el scanner al final
    }
}