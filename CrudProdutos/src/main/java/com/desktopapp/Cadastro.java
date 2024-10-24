package com.desktopapp;

import java.net.URL;

import com.desktopapp.model.UserData;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Cadastro {
    public static Scene CreateScene() throws Exception{
        URL sceneUrl = Cadastro.class.getResource("Cadastro.fxml");
        FXMLLoader loader  = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        return scene;
    }

    @FXML
    protected Button btnCadastrar;

    @FXML
    protected TextField nomeLogin;

    @FXML
    protected PasswordField senhaCadastro;
    

    @FXML
    public void cadastrar(MouseEvent e) throws Exception{

        UserData user = new UserData();
        user.setName(nomeLogin.getText());
        user.setPassword(senhaCadastro.getText());

        Context ctx = new Context();
        ctx.begin();
        ctx.save(user);
        ctx.commit();

        var crrStage = (Stage) btnCadastrar.getScene().getWindow();
        crrStage.close();
        
        var stage = new Stage();
        var scene = MainController.CreateScene();
        stage.setScene(scene);
        stage.show();
    }
}
