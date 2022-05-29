
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
        
                TutorDAO nuevoTutorDAO = new TutorDAO();
                Tutor nuevoTutor = new Tutor();
                nuevoTutor.setCuentaUV(tfCuenta.getText());
                nuevoTutor.setNombre(tfNombre.getText());
                nuevoTutor.setApellidoPaterno(tfApellidoPaterno.getText());
                nuevoTutor.setApellidoMaterno(tfApellidoMaterno.getText());
                nuevoTutor.setCorreo(tfCorreo.getText());
                nuevoTutor.setPassword(tfPassword.getText());

                nuevoTutorDAO.registrarTutor(nuevoTutor);
                
            
    
    }
    
        

    @FXML
    private void btnCancelar(ActionEvent event) {
    }
   
}