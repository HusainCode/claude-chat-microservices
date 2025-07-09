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


    // This is the entery point
    @Override
    public void start(Stage stage){
        chatArea.setEditable(false); // makes the text area read only!
        Button sendBtn = new Button("Send");
        Button downloadBtn = new Button("Download Chat Script"); // Download chat script


        // Event handlers
        sendBtn.setOnAction(e -> sendMessage(chatArea, textField));
        textField.setOnAction(e -> sendMessage()); // Enter key send message when clicked
        downloadBtn.setOnAction(e -> downloadScript(stage));

        // Build the layout
        VBox root = new VBox(10, chatArea,textField,sendBtn,downloadBtn);


        // Set up the scene
        Scene scene = new Scene(root,400,300);
        stage.setScene(scene);
        stage.setTitle("Smart Chat");
        stage.show();


        textField.setOnAction(e -> {

            String message = textField.getText();
            chatArea.appendText("Hi" + message);
            textField.clear();

            // TODO Call AWS Bedrock
            String bedrockResponse = "";
            chatArea.appendText("ChatBoot" + bedrockResponse + "\n");

            stage.show();

        });




    }


    private void sendMessage(TextArea chatArea, TextField textField){
        String text = textField.getText();
        if (!text.isEmpty()){
            chatArea.appendText("Hello" + text + "\n"); // append message
            textField.clear(); // clear out the message
        }
    }

    private void downloadScript(Stage stage) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Chat Script");
        fileChooser.setInitialFileName("Chat-script.txt"); // default name

        File file = fileChooser.showSaveDialog(stage):
        if ( file != null){
            try (FileWriter writer = new FileWriter(file)){
                writer.write(chatArea.getText()); // save chat tex
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}


