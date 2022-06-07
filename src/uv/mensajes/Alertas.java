/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uv.mensajes;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertas {
    
    public static void mostrarAlerta(Alert.AlertType tipoAlerta, String titulo, String encabezado, String contenido) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
    
    public static Optional<ButtonType> mostrarAlertaBoton(Alert.AlertType tipoAlerta, String titulo, String encabezado, String contenido){
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(encabezado);
        alerta.setContentText(contenido);
        return alerta.showAndWait();
    }
    
}
