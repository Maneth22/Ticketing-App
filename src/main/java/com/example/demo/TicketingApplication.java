package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TicketingApplication extends Application {
    private static Stage  stg; //For New Stages
    //Opening Stage

    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        Parent rt=FXMLLoader.load(getClass().getResource("Scene-1.fxml"));
        primaryStage.setTitle("Ticketing System");                 //Title of application
        primaryStage.setScene(new Scene(rt,600,400));
        primaryStage.show();
    }

    public void newWindow(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}