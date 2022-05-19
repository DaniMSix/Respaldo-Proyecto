/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.dataaccess.DataBaseConnection;
import uv.fei.tutorias.domain.Tutor;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class RegistrarTutorAcademicoGUIController implements Initializable {

    @FXML
    private Button btGuardar;

    @FXML
    private TextField tfApellidoMaterno;

    @FXML
    private TextField tfApellidoPaterno;

    @FXML
    private TextField tfCorreo;

    @FXML
    private TextField tfCuenta;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfPassword;

    Stage stage;
    @FXML
    private AnchorPane panelTutor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enviarInformacion(ActionEvent event) throws SQLException {
        DataBaseConnection dbConection = new DataBaseConnection();
        try (Connection connection=dbConection.getConnection()){
    
            if (tfCuenta.getText().equals("") || tfNombre.getText().equals("") || tfApellidoPaterno.getText().equals("") || tfApellidoMaterno.getText().equals("") || tfCorreo.getText().equals("") || tfPassword.getText().equals("") || tfCuenta.getText().equals("")) {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Campos vacíos");
                alert.setHeaderText("No se puede dejar ningún campo vacío");
                alert.setContentText("Escriba en todos los campos correspondientes");
                alert.showAndWait();

            } else {

                TutorDAO nuevoTutorDAO = new TutorDAO();
                Tutor nuevoTutor = new Tutor();
                nuevoTutor.setCuentaUV(tfCuenta.getText());
                nuevoTutor.setNombre(tfNombre.getText());
                nuevoTutor.setApellidoPaterno(tfApellidoPaterno.getText());
                nuevoTutor.setApellidoMaterno(tfApellidoMaterno.getText());
                nuevoTutor.setCorreo(tfCorreo.getText());
                nuevoTutor.setPassword(tfPassword.getText());

                nuevoTutorDAO.registrarTutor(nuevoTutor);
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Información registrada");
                alert.setHeaderText("Se a registrado con éxito la información");
                alert.showAndWait();
            
            if (alert.showAndWait().get() == ButtonType.OK) {
                //Cambiar por menú principal
                stage = (Stage) panelTutor.getScene().getWindow();
                stage.close();
            }
            }
    }catch (SQLException ex) {
        Alert alert = new Alert(AlertType.WARNING);
             alert.setTitle("Error");
             alert.setHeaderText("Error en conexion con la base de datos");
             alert.setContentText("El sistema presenta dificultades para realizar la conexion con la base de datos, por favor intente mas tarde.");
             alert.showAndWait(); 
    }
    
    
    }
    
        

    @FXML
    private void btnCancelar(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancelar");
        alert.setHeaderText("Confirmar cancelar registro");
        alert.setContentText("¿Esta seguro de que desea cancelar el registro?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) panelTutor.getScene().getWindow();
            stage.close();
        }

    }
    }
