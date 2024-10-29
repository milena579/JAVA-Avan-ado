package com.desktopapp;

import java.net.URL;
import java.util.ResourceBundle;

import com.desktopapp.model.MensagemData;
import com.desktopapp.model.UserData;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EscreverMsg{
     public static Scene CreateScene(UserData user) throws Exception{
        URL sceneUrl = EscreverMsg.class.getResource("EnviarMsg.fxml");
        FXMLLoader loader  = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        EscreverMsg controller = loader.getController();
        controller.setUser(user);
        controller.remetente.setText(user.getEmail());
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
    protected TextField remetente;

    @FXML
    protected TextField destinatario;

    @FXML
    protected TextArea texto;

    @FXML
    protected Button btnEnviarMsg;


    @FXML
    protected void enviarMsg(MouseEvent e) throws Exception{
        MensagemData mensagem = new MensagemData();

        mensagem.setRemetente(remetente.getText());
        mensagem.setMensagem(texto.getText());
        mensagem.setDestinatario(destinatario.getText());

        Context ctx = new Context();
        ctx.begin();
        ctx.save(mensagem);
        ctx.commit();

        var crrStage = (Stage) btnEnviarMsg.getScene().getWindow();
        crrStage.close();
        
        var stage = new Stage();
        var scene = MainSceneController.CreateScene(user);
        stage.setScene(scene);
        stage.show();
      
    }
}
