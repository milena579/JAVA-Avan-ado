package com.desktopapp;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;

import com.desktopapp.implementations.DatabaseProductRepository;
import com.desktopapp.model.ProdutoData;

import com.desktopapp.repositories.ProductRepository;

public class ProdutoAcoes extends ProdutoData{

    private Button btnDeletar;
    public Button getBtnDeletar() {
        return btnDeletar;
    }
    public void setBtnDeletar(Button btnDeletar) {
        this.btnDeletar = btnDeletar;
    }

    private Button btnEditar;
    public Button getBtnEditar() {
        return btnEditar;
    }
    public void setBtnEditar(Button btnEditar) {
        this.btnEditar = btnEditar;
    }

    
    public ProdutoAcoes (ProdutoData produto, TableView<ProdutoAcoes> tbProd, VerProduto controller ){

        ProductRepository repo = new DatabaseProductRepository();

        this.setId(produto.getId());
        this.setName(produto.getName());
        this.setType(produto.getType());
        this.setValue(produto.getValue());

        this.btnDeletar = new Button();
        this.btnDeletar.setText("❌");
        this.btnDeletar.setOnAction((ActionEvent event) -> {
            repo.delete(produto);
            tbProd.setItems(controller.listaProdutos());
        });


        this.btnEditar = new Button();
        this.btnEditar.setText("✏️");
        this.btnEditar.setOnAction((ActionEvent event) -> {
            try {
                var crrStage = (Stage) btnEditar.getScene().getWindow();
                crrStage.close();


            } catch (Exception e) {
                // TODO: handle exception
            }
            repo.update(produto);
            tbProd.setItems(controller.listaProdutos());
        });
    }
}
