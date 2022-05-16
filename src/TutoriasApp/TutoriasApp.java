package TutoriasApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class TutoriasApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarFechaDeSesionDeTutoria.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/ConsultarEstudiante.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarFechasDeSesionDeTutoria.fxml"));
        //RegistrarFechasDeSesionDeTutoria
        
        /*
        SesionTutoriaDAO SesionTutoriaDAO = new SesionTutoriaDAO();
                SesionTutoria nuevaSesionTutoria = new SesionTutoria();
                
                //String date = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                
                nuevaSesionTutoria.setFechaCierreReportes(date.getValue().toString());
                SesionTutoriaDAO.registrarSesionTutoria(nuevaSesionTutoria);
            
                JOptionPane.showMessageDialog(null, "Fecha registrada");
        */
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
