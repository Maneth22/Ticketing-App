package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import static javafx.application.Platform.exit;

public class TicketingMainController implements Initializable {

    int price=0;
    String Message="";
    String Num1,Num2,Num3;
    ArrayList Tickets=new ArrayList<String>();

    Queue Day1=new Queue(3);
    Queue Day2=new Queue(1000);
    Queue Day3=new Queue(1000);



    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    CheckBox day1;
    @FXML
    CheckBox day2;
    @FXML
    CheckBox day3;
    @FXML
    Label error;

    public void setDay1(Queue day) {
        for (int i=1001;i<2001;i++){
            day.enqueue(i);
        }

    }
    public void setDay2(Queue day) {
        for (int i=2001;i<3001;i++){
            day.enqueue(i);
        }

    }
    public void setDay3(Queue day) {
        for (int i=3001;i<4001;i++){
            day.enqueue(i);
        }

    }

    public void order(ActionEvent event) throws IOException {

        if (day1.isSelected() || day2.isSelected() || day3.isSelected()){
            if (Day1.isEmpty()||Day2.isEmpty()|| Day3.isEmpty()){
                error.setText("Tickets have been sold out for the Selected Day/Days");
            }
            else {

                if (day1.isSelected() && !(Day1.isEmpty())){
                    Num1=String.valueOf(Day1.peek());
                    Tickets.add(Num1);
                    Day1.dequeue();

                }
                if (day2.isSelected() && !(Day2.isEmpty())){
                    Num2=String.valueOf(Day2.peek());
                    Tickets.add(Num2);
                    Day2.dequeue();

                }
                if (day3.isSelected() && !(Day3.isEmpty())){
                    Num3=String.valueOf(Day3.peek());
                    Tickets.add(Num3);
                    Day3.dequeue();

                }


                day1.setSelected(false);
                day2.setSelected(false);
                day3.setSelected(false);

                error.setText("");

                for (int i=0;i<Tickets.size();i++){
                    Message= (String) Tickets.get(i) +" "+ Message;
                    price= Tickets.size()*750;
                }
                String StrPrice=String.valueOf(price);
                System.out.println(StrPrice);
                System.out.println(StrPrice+" "+Message);

                writeFile("price.txt",StrPrice);
                writeFile("message.txt",Message);

                TicketingApplication m= new TicketingApplication();
                m.newWindow("scene-2.fxml");

            }



            Tickets.clear();
            Message="";




        }
        else {
            error.setText("Please select a Day");
        }



        label1.setText(String.valueOf(Day1.size()));
        label2.setText(String.valueOf(Day2.size()));
        label3.setText(String.valueOf(Day3.size()));






    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDay1(Day1);
        setDay2(Day2);
        setDay3(Day3);



    }
    public void writeFile(String file,String name) throws IOException {
        BufferedWriter writer= new BufferedWriter(new FileWriter(file));
        writer.write(name);
        writer.close();
    }


}