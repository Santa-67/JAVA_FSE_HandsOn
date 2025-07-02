package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchDataTwice() {
        String first = api.getData();
        String second = api.getData();
        return first + "," + second;
    }
}