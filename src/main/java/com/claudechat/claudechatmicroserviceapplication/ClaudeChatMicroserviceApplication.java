package com.claudechat.claudechatmicroserviceapplication;

import javafx.stage.FileChooser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

@SpringBootApplication
public class ClaudeChatMicroserviceApplication extends Application {

    private final TextArea chatArea = new TextArea();
    private final TextField textField = new TextField();
    private final TextField nameField = new TextField("Your Name");

    public static void main(String[] args) {
        SpringApplication.run(ClaudeChatMicroserviceApplication.class, args);
        launch(args);
    }

    // This is the entry point
    @Override
    public void start(Stage stage) {
        chatArea.setEditable(false); // makes the text area read only!
        Button sendBtn = new Button("Send");
        Button downloadBtn = new Button("Download Chat Script");

        // Event handlers
        sendBtn.setOnAction(e -> sendMessage());
        textField.setOnAction(e -> sendMessage()); // Enter key sends message
        downloadBtn.setOnAction(e -> {
            try {
                downloadScript(stage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Build the layout (add name field)
        VBox root = new VBox(10, new Label("Name:"), nameField, chatArea, textField, sendBtn, downloadBtn);

        // Set up the scene
        Scene scene = new Scene(root, 400, 350);
        stage.setScene(scene);
        stage.setTitle("Smart Chat");
        stage.show();
    }

    // Use the name from nameField in your chat
    private void sendMessage() {
        String userName = nameField.getText().trim();
        String text = textField.getText().trim();
        if (!text.isEmpty() && !userName.isEmpty()) {
            chatArea.appendText(userName + ": " + text + "\n");
            textField.clear();
            // Fake AI response for now
            chatArea.appendText("ChatBot: (reply here)\n");
        }
    }

    private void downloadScript(Stage stage) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Chat Script");
        fileChooser.setInitialFileName("Chat-script.txt"); // default name

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(chatArea.getText()); // save chat text
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
