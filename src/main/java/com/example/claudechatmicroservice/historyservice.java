package com.example.claudechatmicroservice.historyservice;

public class His {
    private String user;
    private String message;

    public ChatHistory(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatHistory{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
