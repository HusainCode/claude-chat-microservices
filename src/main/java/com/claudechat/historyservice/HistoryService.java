package com.claudechat.historyservice;

public class HistoryService {


    private String user;
    private String message;

    public HistoryService(String user, String message) {
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
        return "HistoryService{" + "user='" + user + '\'' +  ", message='" + message + '\'' + '}';
    }
}
