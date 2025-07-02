package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void doActions() {
        api.firstAction();
        api.secondAction();
    }
}