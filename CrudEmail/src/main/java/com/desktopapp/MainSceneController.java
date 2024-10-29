package com.desktopapp;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.desktopapp.model.MensagemData;
import com.desktopapp.model.UserData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class MainSceneController implements Initializable {
    
    public static Scene CreateScene(UserData user) throws Exception
    {
        URL sceneUrl = MainSceneController.class.getResource("main-scene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        MainSceneController controller = loader.getController();
        controller.setUser(user);
        controller.nomeUser.setText("Olá, " + user.getName());
        loader.setController(controller);
        return scene;
    }
    
    private UserData user;

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    @FXML
    protected AnchorPane menu;

    @FXML
    protected Text nomeUser;

    @FXML
    protected AnchorPane tela;

    @FXML 
    protected Button sair;

    @FXML
    protected Button novaMensagem;

    @FXML 
    protected TableView<BotoesMsg> caixaEntrada;
    
    @FXML
    protected TableColumn<BotoesMsg, Long> id;

    @FXML
    protected TableColumn<BotoesMsg, String> remetente;

    @FXML
    protected TableColumn<BotoesMsg, String>mensagem;

    @FXML
    protected TableColumn<BotoesMsg, Button> verMsg;

    @FXML
    protected TableColumn<BotoesMsg, Button> excluirMsg;

    @FXML
    public void novaMsg(MouseEvent e) throws Exception{
        var crrStage = (Stage) novaMensagem.getScene().getWindow();
        crrStage.close();
        
        var stage = new Stage();
        var scene = EscreverMsg.CreateScene(user);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void logout(MouseEvent e) throws Exception{
        var crrStage = (Stage) sair.getScene().getWindow();
        crrStage.close();
        
        var stage = new Stage();
        var scene = MainController.CreateScene();
        stage.setScene(scene);
        stage.show();
    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        remetente.setCellValueFactory(new PropertyValueFactory<>("remetente"));
        mensagem.setCellValueFactory(new PropertyValueFactory<>("mensagem"));

        caixaEntrada.setItems(listaMensagens());
    }

    protected ObservableList<BotoesMsg> listaMensagens() {
        Context ctx = new Context();
        ctx.begin();
        List<MensagemData> lista = ctx.findAll(MensagemData.class);

        List<BotoesMsg> buttons = lista.stream().map(n -> {
            BotoesMsg btn = new BotoesMsg(n, caixaEntrada, this);
            return btn;
        })
        .collect(Collectors.toList());

        return FXCollections.observableArrayList(
            buttons
        );
    }
    
}