/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.Periodo;
import uv.fei.tutorias.domain.SesionTutoria;
import uv.mensajes.Alertas;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class ModificarFechasDeSesionDeTutoriaController implements Initializable {

    @FXML
    private DatePicker dpPrimeraSesion;
    @FXML
    private DatePicker dpSegundaSesion;
    @FXML
    private DatePicker dpTerceraSesion;
    @FXML
    private ComboBox cbNumeroTutoria1;
    @FXML
    private ComboBox cbNumeroTutoria2;
    @FXML
    private ComboBox cbNumeroTutoria3;
    @FXML
    private ComboBox comboPeriodoInicio;
    @FXML
    private ComboBox comboPeriodoFin;
    @FXML
    private AnchorPane modificarSesionTutoria;
    
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargarItems(cbNumeroTutoria1);
        this.cargarItems(cbNumeroTutoria2);
        this.cargarItems(cbNumeroTutoria3);
    }    

    @FXML
    private void guardarInformacion(ActionEvent event) {
        
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo nuevoPeriodo = new Periodo();
        
        String periodoInicio = (String) comboPeriodoInicio.getValue();
        String periodoFin = (String) comboPeriodoFin.getValue();
        
        nuevoPeriodo.setFechaInicio(periodoInicio);
        nuevoPeriodo.setFechaFin(periodoFin);
        
    }
    
    public void modificarSesion(DatePicker fechaTutoria, ComboBox numeroTutoria, int idPeriodoRegistrar){
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaTutoria.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        nuevaSesionTutoria.setFechaTutoria(fecha);
        nuevaSesionTutoria.setNumTutoria(numeroTutoria.getValue().toString());
        nuevaSesionTutoria.setIdPeriodo(idPeriodoRegistrar);
        SesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);
        
    }

    @FXML
    private void cancelarModificacion(ActionEvent event) {
        Optional<ButtonType> respuesta = Alertas.mostrarAlertaBoton(Alert.AlertType.ERROR, "Cancelar", "Confirmar cancelar registro",
                "¿Esta seguro de que desea cancelar el registro?");
        if (respuesta.get() == ButtonType.OK) {
                stage = (Stage) modificarSesionTutoria.getScene().getWindow();
                stage.close();
        }
    }
    
    public void cargarItems(ComboBox combo){
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3");
        combo.setItems(list);
    }
}
