package com.example.book_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_service.serviceImpl.BookServiceImpl;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

}
