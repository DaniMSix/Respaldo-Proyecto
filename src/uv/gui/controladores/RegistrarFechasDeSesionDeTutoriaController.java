package uv.gui.controladores;

import java.net.URL;
import java.time.format.DateTimeFormatter;
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

public class RegistrarFechasDeSesionDeTutoriaController implements Initializable{

    @FXML
    private DatePicker dpPeriodoFin;

    @FXML
    private DatePicker dpPeriodoInicio;

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
    
    Stage stage;
    @FXML
    private AnchorPane panelFechaSesionTutoria;

    @FXML
    void CancelarRegistro(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancelar");
        alert.setHeaderText("Confirmar cancelar registro");
        alert.setContentText("¿Esta seguro de que desea cancelar el registro?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) panelFechaSesionTutoria.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    void enviar(ActionEvent event) {
        
        //if (dpPeriodoFin.getValue().val() || dpPeriodoInicio.getValue().equals("") || dpPrimeraSesion.getValue().equals("") || dpSegundaSesion.getValue().equals("") || dpTerceraSesion.getValue().equals("") ) {
        //} else{
        // Registramos el periodo
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo nuevoPeriodo = new Periodo();
        
        String periodoInicio = dpPeriodoInicio.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String periodoFin = dpPeriodoFin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        nuevoPeriodo.setFechaInicio(periodoInicio);
        nuevoPeriodo.setFechaFin(periodoFin);
        
        periodoDao.registrarPeriodo(nuevoPeriodo);
        
        
        // Registramos las fechas de sesión
        registrarSesion(dpPrimeraSesion, cbNumeroTutoria1);
        registrarSesion(dpSegundaSesion, cbNumeroTutoria2);
        registrarSesion(dpTerceraSesion, cbNumeroTutoria3);
            
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Información registrada");
        alert.setHeaderText("Se a registrado con éxito la información");
        alert.showAndWait();

        if (alert.showAndWait().get() == ButtonType.OK) {
            //Cambiar por menú principal
            stage = (Stage) panelFechaSesionTutoria.getScene().getWindow();
            stage.close();
        }
        
    }
    
    public void registrarSesion(DatePicker fechaTutoria, ComboBox numeroTutoria){
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaTutoria.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        nuevaSesionTutoria.setFechaTutoria(fecha);
        nuevaSesionTutoria.setNumTutoria(numeroTutoria.getValue().toString());
        SesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cargarItems(cbNumeroTutoria1);
        this.cargarItems(cbNumeroTutoria2);
        this.cargarItems(cbNumeroTutoria3);
    }
    
    public void cargarItems(ComboBox combo){
        ObservableList<String> list = FXCollections.observableArrayList("1","2","3");
        combo.setItems(list);
    }

}