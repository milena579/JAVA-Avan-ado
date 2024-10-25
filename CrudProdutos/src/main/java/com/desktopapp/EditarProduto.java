package com.desktopapp;

import java.net.URL;

import com.desktopapp.model.ProdutoData;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditarProduto {
   public static Scene CreateScene(ProdutoData produto) throws Exception{
        URL sceneUrl = EditarProduto.class.getResource("EditarProduto.fxml");
        FXMLLoader loader  = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        EditarProduto controller = loader.getController();

        controller.editaNome.setText(produto.getName());
        controller.editaTipo.setText(produto.getType());
        controller.editaValor.setText(String.valueOf(produto.getValue()));

        controller.setProduto(produto);
        return scene;
    }

    @FXML
    protected TextField editaNome;

    @FXML
    protected TextField editaTipo;

    @FXML
    protected TextField editaValor;

    @FXML 
    protected Button atualizaProd;

    protected ProdutoData produto;
    
    public ProdutoData getProduto() {
        return produto;
    }

    public void setProduto(ProdutoData produto) {
        this.produto = produto;
    }

    @FXML
    public void atualizar(MouseEvent e) throws Exception{
        
        Context ctx = new Context();
        ctx.begin();

        produto.setName(editaNome.getText());
        produto.setType(editaTipo.getText());
        produto.setValue(Float.parseFloat(editaValor.getText()));
        
        ctx.update(produto);
        ctx.commit();

        var crrStage = (Stage) atualizaProd.getScene().getWindow();
        crrStage.close();   
    }
}
