package com.example.demobff.infrastructure.config;

public enum MicrosservicesInfo {
    TRANSFERS("http://localhost:8081"),
    CUSTOMERS("http://localhost:8080");

    private final String url;

    MicrosservicesInfo(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
