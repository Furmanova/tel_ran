package com.telran;

import java.util.Objects;

public class LogEntry {
    String userName;
    String url;

    public LogEntry(String userName, String url) {
        this.userName = userName;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "userName='" + userName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return userName.equals(logEntry.userName) &&
                url.equals(logEntry.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, url);
    }
}
