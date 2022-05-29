/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import uv.fei.tutorias.bussinesslogic.PeriodoDAO;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.domain.Periodo;
import uv.fei.tutorias.domain.SesionTutoria;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class RegistrarController implements Initializable {

    @FXML
    private ComboBox cbPeriodoInicio;
    @FXML
    private ComboBox cbPeriodoFin;
    @FXML
    private ComboBox cbNumTutoria1;
    @FXML
    private ComboBox cbNumTutoria2;
    @FXML
    private ComboBox cbNumTutoria3;
    @FXML
    private DatePicker dpPrimeraSesion;
    @FXML
    private DatePicker dpSegundaSesion;
    @FXML
    private DatePicker dpTerceraSesion;

    
    ObservableList<String> opcionesComboPeriodoInicio;
    
    ObservableList<String> opcionesComboPeriodoFin;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cargarItems(cbNumTutoria1);
        this.cargarItems(cbNumTutoria2);
        this.cargarItems(cbNumTutoria3);
        this.cargarComboboxPeriodos();
    }    

    @FXML
    private void enviarInformacion(ActionEvent event) {
        
        Periodo periodo = new Periodo();
            PeriodoDAO periodoDao = new PeriodoDAO();
            
            String periodoInicio = cbPeriodoInicio.getValue().toString();
            String periodoFin = cbPeriodoFin.getValue().toString();
            
            if (periodoDao.comprobarSiExistePeriodo(periodoInicio, periodoFin)){
                
                int idPeriodoRegistrar = periodoDao.buscarFechasDelPeriodo(periodoInicio, periodoFin);
                
                // Registramos las fechas de cierre
                registrarSesion(dpPrimeraSesion, cbNumTutoria1, idPeriodoRegistrar);
                registrarSesion(dpSegundaSesion, cbNumTutoria2, idPeriodoRegistrar);
                registrarSesion(dpTerceraSesion, cbNumTutoria3, idPeriodoRegistrar);

            } else {
                System.out.println("Está mal");
            }
    }
    
    public void registrarSesion(DatePicker fechaReporte, ComboBox numeroTutoria, int idPeriodoRegistrar){
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaReporte.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        
        
        nuevaSesionTutoria.setNumTutoria(numeroTutoria.getValue().toString());
        nuevaSesionTutoria.setFechaCierreReportes(fecha);
        SesionTutoriaDAO.registrarFechaDeCierreDeReporte(nuevaSesionTutoria, idPeriodoRegistrar);
        
    }
    
    public void cargarItems(ComboBox combo){
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3");
        combo.setItems(list);
    }
    
    public void cargarComboboxPeriodos(){
        opcionesComboPeriodoInicio = FXCollections.observableArrayList();
        PeriodoDAO periodoDao = new PeriodoDAO();
        List<Periodo> periodos = periodoDao.consultarPeriodoTodosLosPeriodos();

        //opcionesComboPeriodo.add("Periodo escolar");
        for(Periodo periodo : periodos){
            opcionesComboPeriodoInicio.add(periodo.getFechaInicio());
        }
        
        cbPeriodoInicio.setItems(opcionesComboPeriodoInicio);
        
        //-------------------------------------------------
        
        opcionesComboPeriodoFin = FXCollections.observableArrayList();

        //opcionesComboPeriodo.add("Periodo escolar");
        for(Periodo periodo : periodos){
            opcionesComboPeriodoFin.add(periodo.getFechaFin());
        }
        
        cbPeriodoFin.setItems(opcionesComboPeriodoFin);

    }
    
}
