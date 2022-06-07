
package uv.gui.controladores;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.domain.Tutor;
import uv.mensajes.Alertas;


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

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void enviarInformacion(ActionEvent event) {
        if (tfCuenta.getText().equals("") || tfNombre.getText().equals("") || tfApellidoPaterno.getText().equals("") || tfApellidoMaterno.getText().equals("") || tfCorreo.getText().equals("") || tfPassword.getText().equals("") || tfCuenta.getText().equals("")) {
                Alertas.mostrarAlerta(Alert.AlertType.WARNING, "Campos vacios",
                        "No puede dejar campos vacíos", "Escriba en todos los campos correspondientes");

            } else {

        
                TutorDAO nuevoTutorDAO = new TutorDAO();
                Tutor nuevoTutor = new Tutor();
                nuevoTutor.setCuentaUV(tfCuenta.getText());
                nuevoTutor.setNombre(tfNombre.getText());
                nuevoTutor.setApellidoPaterno(tfApellidoPaterno.getText());
                nuevoTutor.setApellidoMaterno(tfApellidoMaterno.getText());
                nuevoTutor.setCorreo(tfCorreo.getText());
                nuevoTutor.setPassword(tfPassword.getText());
                try {
                nuevoTutorDAO.registrarTutor(nuevoTutor);
                Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.INFORMATION, "Información registrada", 
                        "Se a registrado con éxito la información", null);
                if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelTutor.getScene().getWindow();
                stage.close();
                }
                
                } catch (SQLException e) {
                Alertas.mostrarAlerta(Alert.AlertType.CONFIRMATION, "Error", "Error en conexion con la base de datos",
                "El sistema presenta dificultades para realizar la conexion con la base de datos, por favor intente mas tarde.");
            }
            }
            
    
    }
    
        

    @FXML
    private void btnCancelar(ActionEvent event) {
        Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.ERROR, "Cancelar", "Confirmar cancelar registro",
                "¿Esta seguro de que desea cancelar el registro?");
        if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) panelTutor.getScene().getWindow();
                stage.close();
        }
    }
   
}