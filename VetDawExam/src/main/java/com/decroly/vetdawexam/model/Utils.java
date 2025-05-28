package com.decroly.vetdawexam.model;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    // propietario
    public static void exportarprop(List<Persona> propietario, String nombreArchivo) {
        try (FileOutputStream file = new FileOutputStream(nombreArchivo);
             ObjectOutputStream oos = new ObjectOutputStream(file)) {

            oos.writeObject(new ArrayList<>(propietario));
            System.out.println("Archivo exportado en: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void importarprop(ListView<Persona> propietario, String nombreArchivo) {
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<Persona> propietarios = (List<Persona>) ois.readObject();
            ObservableList<Persona> items = propietario.getItems();
            items.clear();
            items.addAll(propietarios);
            System.out.println("Importación exitosa desde: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al importar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // mascota
    public static void exportarmasc(List<Mascota> mascota, String nombreArchivo) {
        try (FileOutputStream file = new FileOutputStream(nombreArchivo);
             ObjectOutputStream oos = new ObjectOutputStream(file)) {

            oos.writeObject(new ArrayList<>(mascota));
            System.out.println("Archivo exportado en: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void importarmasc(ListView<Mascota> mascota, String nombreArchivo) {
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<Mascota> mascotas = (List<Mascota>) ois.readObject();
            ObservableList<Mascota> items = mascota.getItems();
            items.clear();
            items.addAll(mascotas);
            System.out.println("Importación exitosa desde: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al importar: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    //consultas
    public static void exportarcons(List<Consulta> consulta, String nombreArchivo) {
        try (FileOutputStream file = new FileOutputStream(nombreArchivo);
             ObjectOutputStream oos = new ObjectOutputStream(file)) {

            oos.writeObject(new ArrayList<>(consulta));
            System.out.println("Archivo exportado en: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al exportar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void importarcons(ListView<Consulta> consulta, String nombreArchivo) {
        try (FileInputStream fis = new FileInputStream(nombreArchivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<Consulta> consultas = (List<Consulta>) ois.readObject();
            ObservableList<Consulta> items = consulta.getItems();
            items.clear();
            items.addAll(consultas);
            System.out.println("Importación exitosa desde: " + new File(nombreArchivo).getAbsolutePath());

        } catch (Exception e) {
            System.err.println("Error al importar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
