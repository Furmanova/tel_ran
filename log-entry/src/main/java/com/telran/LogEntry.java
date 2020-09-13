package com.telran;

public class LogEntry {
    String userName;
    String url;

    @Override
    public String toString() {
        return "LogEntry{" +
                "userName='" + userName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public LogEntry(String userName, String url) {
        this.userName = userName;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

        public String getUrl() {
        return url;
    }


}
