/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class RegistrarFechasDeCierreParaLaEntregaDelReporteController implements Initializable {

    @FXML
    private ComboBox cbPeriodo;
    @FXML
    private DatePicker dpPrimeraSesion;
    @FXML
    private DatePicker dpSegundaSesion;
    @FXML
    private DatePicker dpTerceraSesion;
    @FXML
    private ComboBox cbNumTutoria1;
    @FXML
    private ComboBox cbNumTutoria2;
    @FXML
    private ComboBox cbNumTutoria3;
    @FXML
    private AnchorPane panelFechaEntregaReporte;

    Stage stage;
    
    ObservableList<String> opcionesComboPeriodo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargarItems(cbNumTutoria1);
        this.cargarItems(cbNumTutoria2);
        this.cargarItems(cbNumTutoria3);
    }    

    @FXML
    private void cancelarRegistro(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar");
        alert.setHeaderText("Confirmar cancelar registro");
        alert.setContentText("¿Esta seguro de que desea cancelar el registro?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) panelFechaEntregaReporte.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void enviarInformacion(ActionEvent event) {
        registrarSesion(dpPrimeraSesion, cbNumTutoria1);
        registrarSesion(dpSegundaSesion, cbNumTutoria2);
        registrarSesion(dpTerceraSesion, cbNumTutoria3);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Información registrada");
        alert.setHeaderText("Se a registrado con éxito la información");
        alert.showAndWait();

        if (alert.showAndWait().get() == ButtonType.OK) {
            //Cambiar por menú principal
            stage = (Stage) panelFechaEntregaReporte.getScene().getWindow();
            stage.close();
        }
    }
    
    public void registrarSesion(DatePicker fechaReporte, ComboBox numeroTutoria){
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaReporte.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
        nuevaSesionTutoria.setFechaCierreReportes(fecha);
        nuevaSesionTutoria.setNumTutoria(numeroTutoria.getValue().toString());
        SesionTutoriaDAO.registrarCierreDeReporte(nuevaSesionTutoria);
    }
    
    public void cargarItems(ComboBox combo){
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3");
        combo.setItems(list);
    }
    
    public void cargarComboboxPeriodos(){
        //opcionesComboPeriodo = FXCollections.observableArrayList();
        PeriodoDAO periodoDao = new PeriodoDAO();
        
        ArrayList<Periodo> periodos = (ArrayList<Periodo>) periodoDao.consultarPeriodoTodosLosPeriodos();
        opcionesComboPeriodo.add("Periodos");
        for(Periodo periodo : periodos){
            opcionesComboPeriodo.add(periodo.getFechaInicio());
        }
    

    }
}
