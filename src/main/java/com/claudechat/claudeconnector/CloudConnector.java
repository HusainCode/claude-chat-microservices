package com.claudechat.claudeconnector;

import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.services.bedrockruntime.BedrockRuntimeClient;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelRequest;
import software.amazon.awssdk.services.bedrockruntime.model.InvokeModelResponse;

@RestController
@RequestMapping
public class CloudConnector {

    private final BedrockRuntimeClient bedrockClient = BedrockRuntimeClient.create();
    public String chatWithBot(@RequestBody String prompt){
        String modelID = ""; // pick modle
        InvokeModelRequest request = InvokeModelRequest.builder()
                .modelId(modelID)
                .body("{\") // stopd here


    }
}
