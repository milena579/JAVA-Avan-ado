package com.desktopapp;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class EditarProduto {
   public static Scene CreateScene() throws Exception{
        URL sceneUrl = CadastroProdutos.class.getResource("ProdutoCadastro.fxml");
        FXMLLoader loader  = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        return scene;
    }

    @FXML
    protected TextField editaNome;

    @FXML
    protected TextField editaTipo;

    @FXML
    protected TextField editaValor;
}
