package com.desktopapp;

import java.io.IOException;
import java.net.URL;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
 
public class MainSceneController {
     
    public static Scene CreateScene() throws Exception
    {
        URL sceneUrl = MainSceneController.class.getResource("main-scene.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected AnchorPane menu;

    @FXML
    protected AnchorPane tela;

    @FXML 
    protected Button verItem;

    @FXML
    protected Button addItem;



    @FXML
    public void addItem(MouseEvent e) throws  Exception{

        VBox item =  FXMLLoader.load(CadastroProdutos.class.getResource("ProdutoCadastro.fxml"));
        tela.setTopAnchor(item, 0.0);
        tela.setBottomAnchor(item, 0.0);
        tela.setLeftAnchor(item, 0.0);
        tela.setRightAnchor(item, 0.0);

        tela.getChildren().setAll(item);

    }

    @FXML
    public void verItem(MouseEvent e) throws Exception{
        VBox itens =  FXMLLoader.load(VerProduto.class.getResource("VerProduto.fxml"));
        tela.setTopAnchor(itens, 0.0);
        tela.setBottomAnchor(itens, 0.0);
        tela.setLeftAnchor(itens, 0.0);
        tela.setRightAnchor(itens, 0.0);

        tela.getChildren().setAll(itens);
    }

    
}