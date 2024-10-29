package com.desktopapp;

import java.net.URL;
import java.util.ResourceBundle;

import com.desktopapp.model.UserData;

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
    protected TableView caixaEntrada;
    
    @FXML
    protected TableColumn id;

    @FXML
    protected TableColumn remetente;

    @FXML
    protected TableColumn mensagem;

    @FXML
    protected TableColumn verMsg;

    @FXML
    protected TableColumn excluirMsg;

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
        id.setCellFactory(new PropertyValueFactory<>("id"));
        // VBox item =  FXMLLoader.load(VerMensagem.class.getResource("VerMensagem.fxml"));
        // tela.setTopAnchor(item, 0.0);
        // tela.setBottomAnchor(item, 0.0);
        // tela.setLeftAnchor(item, 0.0);
        // tela.setRightAnchor(item, 0.0);

        // tela.getChildren().setAll(item);
    }
    
}