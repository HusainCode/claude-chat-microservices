package com.claudechat.claudechatmicroserviceapplication;

import javafx.stage.FileChooser;
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



/// Most important things for building a JavaFX GUI:
///
/// Stage: The main application window (Stage stage)
///
/// Scene: Holds all UI elements (Scene scene)
///
/// Layouts: Arrange controls (VBox, HBox, GridPane)
///
/// Controls: Buttons, TextFields, Labels, etc.
///
/// Events: Use .setOnAction for handling user actions
///
// the main entry  point

@SpringBootApplication
public class ClaudeChatMicroserviceApplication extends Application {

    private final TextArea chatArea = new TextArea();
    private final TextField textField = new TextField();


    public static void main(String[] args) {SpringApplication.run(ClaudeChatMicroserviceApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage stage){
        chatArea.setEditable(false); // makes the text area read only!
        Button sendBtn = new Button("Send");
        Button downloadBtn = new Button("Download Chat Script"); // Download chat script

        downloadBtn.setOnAction(e -> sendMessage(chatArea, textField));



        textField.setOnAction(e -> {

            String message = textField.getText();
            chatArea.appendText("Hi" + message);
            textField.clear();

            // TODO Call AWS Bedrock
            String bedrockResponse = "";
            chatArea.appendText("ChatBoot" + bedrockResponse + "\n");

            stage.show();

        });


        VBox root = new VBox(10, chatArea, textField);
        Scene scene = new Scene(root,400,300);
        stage.setScene(scene);
        stage.setTitle("Smart Chat");
        stage.show();

    }


    private void sendMessage(TextArea chatArea, TextField textField){
        String text = textField.getText();
        if (!text.isEmpty()){
            chatArea.appendText("Hello" + text + "\n");
        }
    }
    // Helper method
    private void downloadTest(Stage stage){


        downloadBtn.setOnAction( event -> {
            String chatScript = ""; // Empty till typing

        });


    }
}


