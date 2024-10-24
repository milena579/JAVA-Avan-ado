package com.desktopapp;

import java.net.URL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.List;

import com.desktopapp.model.ProdutoData;

public class VerProduto implements Initializable{
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = VerProduto.class.getResource("VerProduto.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected TableView<ProdutoAcoes> produto;

    @FXML
    protected TableColumn<ProdutoAcoes, Long> id;

    @FXML
    protected TableColumn<ProdutoAcoes, String> nome;

    @FXML
    protected TableColumn<ProdutoAcoes, String> tipo;

    @FXML
    protected TableColumn<ProdutoAcoes, Float> valor;

    @FXML
    protected TableColumn<ProdutoAcoes, Button> editar;

    @FXML
    protected TableColumn<ProdutoAcoes, Button> deletar;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        //Context consulta  = new Context();
        //var retornoTipo = consulta.createQuery(ProdutoData.class, "SELECT prod FROM ProdutoData prod").setMaxResults(20).getResultList();

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nome.setCellValueFactory(new PropertyValueFactory<>("name"));
        tipo.setCellValueFactory(new PropertyValueFactory<>("type"));
        valor.setCellValueFactory(new PropertyValueFactory<>("value"));
        editar.setCellValueFactory(new PropertyValueFactory<>("btnDeletar"));
        deletar.setCellValueFactory(new PropertyValueFactory<>("btnDeletar"));

        //var itemsTabela = FXCollections.observableArrayList(retornoTipo);

        produto.setItems(listaProdutos());
    }

    protected ObservableList<ProdutoAcoes> listaProdutos(){
        Context ctx = new Context();
        ctx.begin();

        
        List<ProdutoData> lista = ctx.findAll(ProdutoData.class);

        List<ProdutoAcoes> buttons = lista.stream().map(n -> {
            ProdutoAcoes btn = new ProdutoAcoes(n, produto, this);
            return btn;
        })

        .collect(Collectors.toList());

        return FXCollections.observableArrayList(
            buttons
        );
    }
}   