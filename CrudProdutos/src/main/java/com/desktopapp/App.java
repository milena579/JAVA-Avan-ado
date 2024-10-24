package com.desktopapp;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import com.desktopapp.model.UserData;

public class App extends Application{
    public static void main(String[] args) {
        UserData user = new UserData();
        user.setName("mile");
        user.setPassword("123");

        Context ctx = new Context();
        ctx.begin();
        ctx.save(user);
        ctx.commit();

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = MainController.CreateScene();
        primaryStage.setScene(scene);
        primaryStage.show();

    }  
}
 