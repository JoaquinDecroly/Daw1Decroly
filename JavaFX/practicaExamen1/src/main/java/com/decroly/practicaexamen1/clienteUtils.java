package com.decroly.practicaexamen1;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class clienteUtils {

    public static void exportar(List<Cliente> cliente, String nombreArchivo) {
        try (FileOutputStream file = new FileOutputStream(nombreArchivo);
             ObjectOutputStream oos = new ObjectOutputStream(file)) {

            oos.writeObject(new ArrayList<>(cliente));
            System.out.println("Archivo exportado en: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void importar(ListView<Cliente> cliente, String nombreArchivo) {
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<Cliente> clientes = (List<Cliente>) ois.readObject();
            ObservableList<Cliente> items = cliente.getItems();
            items.clear();
            items.addAll(clientes);
            System.out.println("Importación exitosa desde: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al importar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
