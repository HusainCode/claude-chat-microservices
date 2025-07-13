package com.claudechat.claudeconnector;


// import spring and AWS SDK classes
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;



/**
 * CloudConnector exposes a simple REST API to  JavaFX app or any client
 * When we send a POST to /api/ai with a chat prompt, it calls AWS Bedrock and returns the AI’s response.
 */

// marked as a controller  to handle http requests
@RestController
@RequestMapping("/api/ai") // the path to all the end points in this class
public class CloudConnector {

    private final BedrockRuntimeClient bedrockClient = BedrockRuntimeClient.create();

    @PostMapping
    public String chatWithBot(@RequestBody String prompt){

        String modelId = "anthropic.claude-v2"; // Or another Bedrock model

        InvokeModelRequest request = InvokeModelRequest.builder()
                .modelId(modelId)
                .body(software.amazon.awssdk.core.SdkBytes.fromUtf8String("{\"prompt\": \"" + prompt + "\"}"))
                .contentType("application/json")
                .accept("application/json")
                .build();


        InvokeModelResponse response = bedrockClient.invokeModel(request);
        return response.body().asUtf8String();


    }
}
