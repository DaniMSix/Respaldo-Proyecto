/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uv.gui.controladores;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uv.fei.tutorias.bussinesslogic.SesionTutoriaDAO;
import uv.fei.tutorias.bussinesslogic.TutorDAO;
import uv.fei.tutorias.bussinesslogic.TutoradoDAO;
import uv.fei.tutorias.domain.Tutorado;

/**
 * FXML Controller class
 *
 * @author DMS19
 */
public class ConsultarEstudianteController implements Initializable {

   
    @FXML
    private TableColumn colApellidoMaterno;

    @FXML
    private TableColumn colApellidoPaterno;

    @FXML
    private TableView tableTutorados;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TextField tfBuscar;
    @FXML
    private AnchorPane panelConsultarEstudiante;
    
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.inicializarTablaTutorados();
    }
    
    
    private void inicializarTablaTutorados() {
        colNombre.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("Nombre"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("ApellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory <Tutorado, String>("ApellidoMaterno"));

        TutoradoDAO tutorDao = new TutoradoDAO();
        ArrayList<Tutorado> tutorados;
        tutorados = tutorDao.obtenerTutoradosPorNombreCompleto();

        ObservableList<Tutorado> tablaTutorado = FXCollections.observableArrayList();
        for (Tutorado tutorado : tutorados) {
            tablaTutorado.add(tutorado);
        }
        
        tableTutorados.setItems(tablaTutorado);
    }

    @FXML
    private void salirVentana(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Cancelar");
        alert.setHeaderText("Confirmar cancelar registro");
        alert.setContentText("¿Esta seguro de que desea cancelar el registro?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) panelConsultarEstudiante.getScene().getWindow();
            stage.close();
        }
    }
    
    
    
}
