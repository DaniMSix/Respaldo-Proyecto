/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class RegistrarFechasDeSesionDeTutoriaController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField tfPrimero;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void enviar(ActionEvent event) {
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
        nuevaSesionTutoria.setNumTutoria(tfPrimero.getText());
        nuevaSesionTutoria.setFechaTutoria(date);
        SesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);
        
            
        JOptionPane.showMessageDialog(null, "Fecha registrada");
    }
    
}
