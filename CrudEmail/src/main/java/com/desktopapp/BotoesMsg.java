package com.desktopapp;

import org.h2.table.Table;

import com.desktopapp.implementations.DatabaseMensagemRepository;
import com.desktopapp.model.MensagemData;
import com.desktopapp.repositories.MensagemRepository;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class BotoesMsg extends MensagemData  {
    private Button btnDeletar;

    public Button getBtnDeletar() {
        return btnDeletar;
    }

    public void setBtnDeletar(Button btnDeletar) {
        this.btnDeletar = btnDeletar;
    }

    private Button btnVisualizar;

    public Button getBtnVisualizar() {
        return btnVisualizar;
    }

    public void setBtnVisualizar(Button btnVisualizar) {
        this.btnVisualizar = btnVisualizar;
    }
    
    public BotoesMsg (MensagemData mensagem, TableView<BotoesMsg> tbMensagem, MainSceneController controller ){
        MensagemRepository repo = new DatabaseMensagemRepository();
        
        this.setId((mensagem.getId()));
        this.setRemetente(mensagem.getRemetente());
        // this.setDestinatario(controller.getDestinatario());
        this.setMensagem(mensagem.getMensagem());

        this.btnDeletar =  new Button();
        this.btnDeletar.setText("❌");
        this.btnDeletar.setOnAction((ActionEvent event) -> {
            repo.delete(mensagem);
            tbMensagem.setItems(controller.listaMensagens());
        });
    }
}
