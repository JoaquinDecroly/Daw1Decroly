package com.decroly.practicaexamen1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class HelloController {
    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidoField;

    @FXML
    private TextField telefonoField;

    @FXML
    private ComboBox<Estudio> combobox;

    @FXML
    private ListView<Cliente> listView;


    @FXML
    private Button anadirButton;

    @FXML
    private Button editarButton;

    @FXML
    private Button eliminarButton;

    @FXML
    private Button importarButton;

    @FXML
    private Button exportarButton;

    //    lista
    ObservableList<Cliente> list = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        combobox.getItems().setAll(Estudio.values());
        listView.setItems(list);
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (!(newVal == null)) {
                nombreField.setText(newVal.getNombre());
                apellidoField.setText(newVal.getApellido());
                telefonoField.setText(newVal.getTelefono());
                combobox.getSelectionModel().select(newVal.getEstudio());
                combobox.setPromptText("Estudio");
            }
        });
    }

    @FXML
    private void handleAdd() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String telefono = telefonoField.getText();
        Estudio estudioField = combobox.getValue();

        if (!(nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || estudioField == null)) {
            Cliente cliente = new Cliente(nombre, apellido, telefono, estudioField);
            showAlert("Exito", "cliente creado");
            list.add(cliente);
            listView.refresh();

            nombreField.clear();
            apellidoField.clear();
            telefonoField.clear();
            combobox.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void handleEdit() {
        Cliente seleccionado = clienteSeleccionado();
        if (seleccionado != null) {
            String nuevoNombre = nombreField.getText();
            String nuevoApellido = apellidoField.getText();
            String nuevoTelefono = telefonoField.getText();
            Estudio nuevoEstudio = combobox.getValue();

            if (!(nuevoNombre.isEmpty() || nuevoApellido.isEmpty() || nuevoTelefono.isEmpty() || nuevoEstudio == null)) {
                seleccionado.setNombre(nuevoNombre);
                seleccionado.setApellido(nuevoApellido);
                seleccionado.setTelefono(nuevoTelefono);
                seleccionado.setEstudio(nuevoEstudio);
                showAlert("Exito", "Cambios añadidos");
                listView.refresh();

                nombreField.clear();
                apellidoField.clear();
                telefonoField.clear();
                combobox.getSelectionModel().clearSelection();

            }else{
                showAlert("Error", "los campos no pueden estar vacíos");
            }
        }else{
            showAlert("Error", "no hay ningún cliente seleccionado");
        }
    }

    @FXML
    private void handleRemove() {
        Cliente seleccionado = clienteSeleccionado();
        if (seleccionado != null) {
            list.remove(seleccionado);
            showAlert("Exito", "Cliente eliminado");
            listView.refresh();

            nombreField.clear();
            apellidoField.clear();
            telefonoField.clear();
            combobox.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void handleImport() {
        clienteUtils.importar(listView, "clientes.dat");
        listView.refresh();
    }

    @FXML
    private void handleExport() {
        List<Cliente> clientes = listView.getItems();
        clienteUtils.exportar(clientes, "clientes.dat");
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Cliente clienteSeleccionado() {
        Cliente productoSeleccionado = listView.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            eliminarButton.setDisable(false);
            editarButton.setDisable(false);
        } else {
            eliminarButton.setDisable(true);
            editarButton.setDisable(true);
        }
        return productoSeleccionado;
    }
}
