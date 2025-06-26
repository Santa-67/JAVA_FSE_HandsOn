package com.example;
public interface ExternalApi {
    String getData();
    String getDataById(int id);
    void sendData(String data); // Add this void method
}
