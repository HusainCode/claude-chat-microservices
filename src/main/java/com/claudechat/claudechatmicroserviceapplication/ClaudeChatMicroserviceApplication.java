package com.claudechat.claudechatmicroserviceapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage; // the main window for the app
import java.io.File;  // Represents file paths, used with FileChoose
import java.io.IOException; // Exception handling for file I/O operations
import java.io.FileWriter; // Writes character data to files


// the main entry  point

@SpringBootApplication
public class ClaudeChatMicroserviceApplication extends Application {

    private TextArea chatArea = new TextArea();
    private TextField textField = new TextField();


    public static void main(String[] args) {SpringApplication.run(ClaudeChatMicroserviceApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage stage){
        chatArea.setEditable(false); // makes the text area read only!


        textField.setOnAction(e -> {

            String message = textField.getText();
            chatArea.appendText("Hi" + message);
            textField.clear();

            // TODO Call AWS Bedrock
            String bedrockReesponse = "";
            chatArea.appendText("ChatBoot" + bedrockReesponse + "\n");

        });


        VBox root = new VBox(10, chatArea, textField);
        Scene scene = new Scene(root,400,300);
        stage.setScene(scene);
        stage.setTitle("Smart Chat");
        stage.show();



    }
}


