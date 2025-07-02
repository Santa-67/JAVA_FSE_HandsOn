package com.library.service;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public void printBookTitle() {
        System.out.println("Book title: Spring in Action");
    }
}