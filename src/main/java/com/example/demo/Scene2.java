package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene2 implements Initializable {
    ReadWrite n=new ReadWrite();
    @FXML
    Label msg;
    @FXML
    AnchorPane scene2;




    public void Exit(ActionEvent event) {
        Stage stage;
        stage=(Stage) scene2.getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String Message;
        String StrPrice;
        try {
            Message = n.readFile("message.txt");
            StrPrice= n.readFile("price.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        msg.setText("Your Ticket Numbers are :\n "+ Message+"\n Price: "+StrPrice+".00");
    }
}
