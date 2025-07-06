package com.claudechat.claudechatmicroserviceapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



// the main entry  point

@SpringBootApplication
public class ClaudeChatMicroserviceApplication extends Application {

    private TextArea chatArea = new TextArea();
    private TextField textField = new TextField();


    public static void main(String[] args) {SpringApplication.run(ClaudeChatMicroserviceApplication.class, args);

    }

    @Override
    public void start(Stage stage){

    }
}


