package com.desktopapp;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.awt.Desktop;
import java.net.URI;


public class MusicaController {
    public static Scene CreateScene() throws Exception{
        URL sceneUrl = MusicaController.class.getResource("LogadoMusica.fxml");
        FXMLLoader loader  = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        return scene;
    }

    @FXML 
    protected Button verMusica;
    
    @FXML
    protected void musica(MouseEvent e) throws Exception {
        try {
            URI link = new URI("https://youtu.be/2khRy7zAKyQ?si=-CfK0ZYqcd9GaUcm");
            Desktop.getDesktop().browse(link);
        } catch (Exception erro){
            System.err.println(erro);
        }
    }

}
