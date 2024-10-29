package com.desktopapp;

import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CaixadeEntrada {
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = CaixadeEntrada.class.getResource("Mensagens.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        return scene;
    }
}
