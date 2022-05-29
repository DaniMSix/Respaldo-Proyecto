package uv.gui.controladores;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        
    }
    
    public String convertirDatePickerToString(DatePicker datepicker){
        String nuevoString = datepicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return nuevoString;
    }

    @FXML
    void enviar(ActionEvent event){
        
        // Registramos el periodo
        PeriodoDAO periodoDao = new PeriodoDAO();
        Periodo nuevoPeriodo = new Periodo();
        
        String periodoInicio = dpPeriodoInicio.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String periodoFin = dpPeriodoFin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        nuevoPeriodo.setFechaInicio(periodoInicio);
        nuevoPeriodo.setFechaFin(periodoFin);
        
        periodoDao.registrarPeriodo(nuevoPeriodo);
        
        // Registramos el idPeriodo
        int idPeriodoRegistrar = periodoDao.buscarFechasDelPeriodo(periodoInicio, periodoFin);
        
        
        
        // Registramos las fechas de sesión 
        registrarSesion(dpPrimeraSesion, cbNumeroTutoria1, idPeriodoRegistrar);
        registrarSesion(dpSegundaSesion, cbNumeroTutoria2, idPeriodoRegistrar);
        registrarSesion(dpTerceraSesion, cbNumeroTutoria3, idPeriodoRegistrar);
        
        
}

    
    public void registrarSesion(DatePicker fechaTutoria, ComboBox numeroTutoria, int idPeriodoRegistrar){
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
        SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
        String fecha = fechaTutoria.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        nuevaSesionTutoria.setFechaTutoria(fecha);
        nuevaSesionTutoria.setNumTutoria(numeroTutoria.getValue().toString());
        nuevaSesionTutoria.setIdPeriodo(idPeriodoRegistrar);
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