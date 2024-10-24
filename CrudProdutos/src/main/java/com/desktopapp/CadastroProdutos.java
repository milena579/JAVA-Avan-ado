package com.desktopapp;

import java.net.URL;

import org.hibernate.mapping.List;

import com.desktopapp.model.ProdutoData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastroProdutos {
    public static Scene CreateScene() throws Exception{
        URL sceneUrl = CadastroProdutos.class.getResource("ProdutoCadastro.fxml");
        FXMLLoader loader  = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        return scene;
    }

    @FXML
    protected TextField nomeProd;

    @FXML
    protected TextField tipo;

    @FXML
    protected TextField valor;

    @FXML
    protected Button btnCadastrar;

    @FXML
    public void cadastrarProd(MouseEvent e) throws Exception {
        ProdutoData produto = new ProdutoData();
        produto.setName(nomeProd.getText());
        produto.setType(tipo.getText());
        produto.setValue(Float.parseFloat(valor.getText()));

        Context ctx = new Context();
        ctx.begin();
        ctx.save(produto);
        ctx.commit();

        var crrStage = (Stage) btnCadastrar.getScene().getWindow();
        crrStage.close();   

        var stage = new Stage();
        var scene = MainSceneController.CreateScene();
        stage.setScene(scene);
        stage.show();
    }
    
}
