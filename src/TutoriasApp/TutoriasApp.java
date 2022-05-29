package TutoriasApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TutoriasApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarFechasDeSesionDeTutoria.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/ConsultarEstudiante.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarTutorAcademicoGUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/RegistrarFechasDeCierreParaLaEntregaDelReporte.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/uv/gui/interfaces/Registrar.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
