package com.decroly.vetdawexam;

import com.decroly.vetdawexam.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class HelloController {
    
    @FXML
    private Circle cerrarButton0, cerrarButton1, cerrarButton2;
    // ----------------
    
    @FXML
    private VBox propietario;

    
    @FXML
    private TextField dnipropietario;
    
    @FXML
    private Button anadirButtonprop;

    @FXML
    private Button importarButtonprop;

    @FXML
    private Button exportarButtonprop;

    @FXML
    private TextField nombrepropietario;

    @FXML
    private TextField apellidopropietario;

    @FXML
    private TextField telefonopropietario;

    @FXML
    private TextField direccionpropietario;

    @FXML
    private TextField emailpropietario;

    @FXML
    private ListView<Persona> listViewpropietario;

    ObservableList<Persona> propietarios = FXCollections.observableArrayList();
    
    // ----------------------------------------------

    @FXML
    private VBox mascota;


    @FXML
    private Button anadirButtonmasc;

    @FXML
    private Button editarButtonmasc;

    @FXML
    private Button importarButtonmasc;

    @FXML
    private Button exportarButtonmasc;
    
    @FXML
    private TextField pasaportemascota;

    @FXML
    private TextField nombremascota;

    @FXML
    private TextField pesomascota;

    @FXML
    private TextField fechamascota;

    @FXML
    private ComboBox<Persona> comboboxpropietariomascota;

    @FXML
    private ComboBox<Tipo> comboboxtipomascota;

    @FXML
    private ListView<Mascota> listViewmascota;

    
    ObservableList<Mascota> mascotas = FXCollections.observableArrayList();

    // ----------------------------------------------

    @FXML
    private VBox consulta;

    @FXML
    private TextField duracionconsulta;

    @FXML
    private TextField observacionesconsulta;

    @FXML
    private TextField fechaconsulta;

    @FXML
    private ComboBox<Mascota> comboboxmascotaconsulta;

    @FXML
    private ListView<Consulta> listViewconsulta;

    ObservableList<Consulta> consultas = FXCollections.observableArrayList();

    // ----------------------------------------------
    // ----------------------------------------------
    @FXML
    public void initialize(){
        comboboxpropietariomascota.getItems().setAll((Persona) new Persona(dnipropietario.getText(), nombrepropietario.getText(), telefonopropietario.getText()));
        listViewpropietario.setItems(propietarios);
        listViewpropietario.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (!(newVal == null)) {
                dnipropietario.setText(newVal.getDni());
                nombrepropietario.setText(newVal.getNombre());
                apellidopropietario.setText(newVal.getApellido());
                telefonopropietario.setText(newVal.getTelefono());
                direccionpropietario.setText(newVal.getDireccion());
                emailpropietario.setText(newVal.getEmail());
            }
        });
        
        comboboxtipomascota.getItems().setAll(Tipo.values());
        listViewmascota.setItems(mascotas);
        listViewmascota.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (!(newVal == null)) {
                pasaportemascota.setText(newVal.getPasaporte());
                nombremascota.setText(newVal.getNombre());
                pesomascota.setText(newVal.getPeso());
                fechamascota.setText(String.valueOf(fechamascota.getText()));
                comboboxpropietariomascota.getSelectionModel().select((Persona) newVal.getPersonas());
                comboboxtipomascota.getSelectionModel().select(newVal.getTipos());
            }
        });
//        comboboxmascotaconsulta.getItems().setAll(new Mascota( pasaportemascota.getText(), nombremascota.getText(), fechamascota.getText())); //El fecha mascota es null
        
        
        listViewconsulta.setItems(consultas);
        listViewconsulta.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (!(newVal == null)) {
                fechaconsulta.setText(newVal.getFecha());
                duracionconsulta.setText(String.valueOf(Double.valueOf(newVal.getDuracion())));
                observacionesconsulta.setText(newVal.getObservaciones());
                comboboxmascotaconsulta.getSelectionModel().select((Mascota) newVal.getMascota());
            }
        });
    }





    @FXML
    private void handleAddPropietario(){
        String dnipropietarioField = dnipropietario.getText();
        String nombrepropietarioField = nombrepropietario.getText();
        String apellidopropietarioField = apellidopropietario.getText();
        String telefonopropietarioField = telefonopropietario.getText();
        String direccionpropietarioField = direccionpropietario.getText();
        String emailpropietarioField = emailpropietario.getText();

        if (!(dnipropietarioField.isEmpty() || nombrepropietarioField.isEmpty() || apellidopropietarioField.isEmpty() || telefonopropietarioField.isEmpty() || direccionpropietarioField.isEmpty() || emailpropietarioField.isEmpty())) {
            Persona propietario = new Persona(dnipropietarioField, nombrepropietarioField, apellidopropietarioField, telefonopropietarioField, direccionpropietarioField, emailpropietarioField);
            showAlert("Exito", "cliente creado");
            propietarios.add(propietario);

            dnipropietario.clear();
            nombrepropietario.clear();
            apellidopropietario.clear();
            telefonopropietario.clear();
            direccionpropietario.clear();
            emailpropietario.clear();
            
            comboboxpropietariomascota.getSelectionModel().clearSelection();
        }
    }
    @FXML
        private void handleAddMascota(){
            String pasaportemascotaField = pasaportemascota.getText();
            String nombremascootaField = nombremascota.getText();
            String pesomascotaField = pesomascota.getText();
            String fechamascotaField = fechamascota.getText();
            Persona persona = comboboxpropietariomascota.getValue();
            Tipo tipo = comboboxtipomascota.getValue();

            if (!(pasaportemascotaField.isEmpty() || nombremascootaField.isEmpty() || pesomascotaField.isEmpty() || fechamascotaField.isEmpty() || persona == null || tipo == null)) {
                Mascota mascota = new Mascota(pasaportemascotaField, nombremascootaField, pesomascotaField, fechamascotaField, new LinkedList<Persona>(), tipo);
                showAlert("Exito", "mascota creada");
                mascotas.add(mascota);
                listViewmascota.refresh();

                pasaportemascota.clear();
               nombremascota.clear();
                pesomascota.clear();
                fechamascota.clear();
                comboboxpropietariomascota.getSelectionModel().clearSelection();
                comboboxtipomascota.getSelectionModel().clearSelection();
            }
        }
    @FXML
    private void handleAddConsulta(){
        String fechaconsultaField = fechaconsulta.getText();
        Double duracionconsultaField = Double.valueOf(duracionconsulta.getText());
        String observacionesconsultaField = observacionesconsulta.getText();
        Mascota mascota = comboboxmascotaconsulta.getValue();

        if (!(fechaconsultaField == null || duracionconsultaField == 0.0 || observacionesconsultaField.isEmpty() || mascota == null)) {
            Consulta consulta = new Consulta(fechaconsultaField, duracionconsultaField, observacionesconsultaField, new LinkedList<Mascota>());
            showAlert("Exito", "consulta creada");
            mascotas.add(mascota);
            listViewmascota.refresh();

            pasaportemascota.clear();
            nombremascota.clear();
            pesomascota.clear();
            fechamascota.clear();
            comboboxpropietariomascota.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void handleEditMascotaConsulta() {
        Mascota seleccionado = mascotaSeleccionado();
        if (seleccionado != null) {
            String nuevopasaportemascotaField = pasaportemascota.getText();
            String nuevonombremascotaField = nombremascota.getText();
            String nuevopesomascotaField = pesomascota.getText();
            String nuevofechamascotaField = fechamascota.getText();
            Mascota nuevamascota = comboboxmascotaconsulta.getValue();

            if (!(nuevopasaportemascotaField.isEmpty() || nuevonombremascotaField.isEmpty() || nuevopesomascotaField.isEmpty() || nuevofechamascotaField.isEmpty() ||  nuevamascota == null)) {
                seleccionado.setNombre(nuevonombremascotaField);
                seleccionado.setPeso(nuevopesomascotaField);
                showAlert("Exito", "Cambios añadidos, solo cambios en nombre y peso");
                listViewmascota.refresh();

                pasaportemascota.clear();
                nombremascota.clear();
                pesomascota.clear();
                fechamascota.clear();
                comboboxmascotaconsulta.getSelectionModel().clearSelection();

            }else{
                showAlert("Error", "los campos no pueden estar vacíos");
            }
        }else{
            showAlert("Error", "no hay ningún cliente seleccionado");
        }
    }

 
//personas
    @FXML
    private void handleImportprop() {
        Utils.importarprop(listViewpropietario, "propietarios.dat");
        listViewpropietario.refresh();
    }

    @FXML
    private void handleExportprop() {
        List<Persona> propietarios = listViewpropietario.getItems();
        Utils.exportarprop(propietarios, "propietarios.dat");
    }

    // mascotas
    @FXML
    private void handleImportmasc() {
        Utils.importarmasc(listViewmascota, "mascotas.dat");
        listViewmascota.refresh();
    }

    @FXML
    private void handleExportmasc() {
        List<Mascota> mascotas = listViewmascota.getItems();
        Utils.exportarmasc(mascotas, "mascotas.dat");
    }

    // consultas
    @FXML
    private void handleImportcons() {
        Utils.importarcons(listViewconsulta, "consultas.dat");
        listViewconsulta.refresh();
    }

    @FXML
    private void handleExportcons() {
        List<Consulta> consultas = listViewconsulta.getItems();
        Utils.exportarcons(consultas, "consultas.dat");
    }
  



    @FXML
    private void switchToPersona(){
        propietario.setDisable(false);
        mascota.setDisable(true);
        consulta.setDisable(true);
    }

    @FXML
    private void switchToConsulta(){
        propietario.setDisable(true);
        mascota.setDisable(true);
        consulta.setDisable(false);
    }

    @FXML
    private void switchToMascota(){
        propietario.setDisable(true);
        mascota.setDisable(false);
        consulta.setDisable(true);
    }
    


    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    

    

    private Mascota mascotaSeleccionado() {
        Mascota mascotaSeleccionado = listViewmascota.getSelectionModel().getSelectedItem();
        if (mascotaSeleccionado != null) {
            editarButtonmasc.setDisable(false);
        } else {
            editarButtonmasc.setDisable(true);
        }
        return mascotaSeleccionado;
    }

   
    }