package com.claudechat.chatapi;

import java.util.ArrayList;
import java.util.List;

public class ChatApi {

    private List<String> messageLog = new ArrayList<>();

    public void sendMessage(String user, String message) {
        // TODO: implement message sending
        String entry = String.format("[%s]: %s", user, message);
        messageLog.add(entry);
        System.out.println("Sent: " + entry);
    }

    public List<String> getMessageLog() {
        return messageLog;
    }

    public int getMessageCount() {
        return messageLog.size();
    }
}
