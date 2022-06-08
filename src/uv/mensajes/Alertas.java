/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.mensajes;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertas {
    
    public static void mostrarAlertaCamposVacios(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Atencion");
        alert.setHeaderText("Campos vacios");
        alert.setContentText("Introduzca los campos necesarios para el inicio de sesion");
        alert.showAndWait();
    }
    
    public static void mostrarAlertaErrorConexionDB(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Atencion");
        alert.setHeaderText("Perdida de conexión");
        alert.setContentText("No se pudo conectar con la base de datos, por favor intente mas tarde");
        alert.showAndWait();        
    }
    
    public static void mostrarAlertaUsuarioIncorrecto(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Atencion");
        alert.setHeaderText("No se encontró el usuario");
        alert.setContentText("No se encontró el usuario ingresado, por favor verifique.");
        alert.showAndWait();
    }
    
}
