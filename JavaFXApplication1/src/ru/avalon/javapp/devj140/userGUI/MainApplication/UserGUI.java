/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.javapp.devj140.userGUI.MainApplication;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import ru.avalon.javapp.devj140.userGUI.BusinessLogic.CommandsName;

/**
 *
 * @author Home-PC
 */
public class UserGUI extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
      Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLUserGUI.fxml"));
            root = loader.load();
            //root = FXMLLoader.load(getClass().getResource("FXMLUserGUI.fxml"));
            //root.setStyle("-fx-background-color:#ffebcd;");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Authentication");
            FXMLUserGUIController f = loader.getController();
            f.setStage(stage);
            stage.show();
        }
        catch (IOException e){
            System.out.println("ERROR" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
       Common.sharedResource.writeCommand(CommandsName.STOP);
    }  
    
    
}
