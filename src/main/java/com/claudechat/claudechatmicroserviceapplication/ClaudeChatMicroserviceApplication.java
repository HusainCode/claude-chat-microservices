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


