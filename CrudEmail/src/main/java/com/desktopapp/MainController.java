package com.desktopapp;

import java.net.URL;

import com.desktopapp.model.UserData;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.desktopapp.MainSceneController;

public class MainController {

    public static Scene CreateScene() throws Exception {
        URL sceneUrl = MainController.class.getResource("MainController.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    protected Button btLogar;

    @FXML
    protected CheckBox verSenha;

    @FXML
    protected TextField login;

    @FXML
    protected PasswordField senha;

    @FXML 
    protected Button btnCadastro;

    @FXML
    protected void logarUsuario(MouseEvent e) throws Exception {
        Context ctx = new Context();
        
        var users = ctx.find(UserData.class,
                "SELECT u FROM UserData u WHERE u.name = :arg0",
                login.getText());
        if (users.size() == 0) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Usuário não está cadastrado!",
                    ButtonType.OK);
            alert.showAndWait();
            return;
        }
        var user = users.get(0);

        if (!senha.getText().equals(user.getPassword())) {
            Alert alert = new Alert(
                    AlertType.ERROR,
                    "Senha incorreta!",
                    ButtonType.OK);
            alert.showAndWait();
            return;
        }

        var crrStage = (Stage) btLogar.getScene().getWindow();
        crrStage.close();
        
        var stage = new Stage();
        var scene = MainSceneController.CreateScene(user);
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML void cadastrarUser(MouseEvent e) throws Exception{
        var crrStage = (Stage) btnCadastro.getScene().getWindow();
        crrStage.close();
        
        var stage = new Stage();
        var scene = Cadastro.CreateScene();
        stage.setScene(scene);
        stage.show();
    }

}
