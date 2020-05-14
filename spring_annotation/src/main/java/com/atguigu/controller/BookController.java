package com.atguigu.controller;

import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public BookController() {
      System.out.println("book controller...constructor");
    }

    @PostConstruct
    public void postConstructor() {
      bookService.toString();
      System.out.println("BookController...PostConstruct...");
    }
}
