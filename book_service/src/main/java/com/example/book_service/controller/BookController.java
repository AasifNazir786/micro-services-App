package com.example.book_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_service.DTO.BookDTO;
import com.example.book_service.DTO.BookWithAuthorDTO;
import com.example.book_service.service.BookServiceInterface;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceInterface bookService;

    // 1. Create a new book
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    // 2. Get a book by its ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.getBookById(id);
        return ResponseEntity.ok(bookDTO);
    }

    // 3. Get a book with author details
    @GetMapping("/{id}/with-author")
    public ResponseEntity<BookWithAuthorDTO> getBookWithAuthor(@PathVariable Long id) {
        BookWithAuthorDTO bookWithAuthor = bookService.getBookWithAuthorDTO(id);
        return ResponseEntity.ok(bookWithAuthor);
    }

    // 4. Get a paginated list of books
    @GetMapping
    public ResponseEntity<Page<BookDTO>> getBooks(Pageable pageable) {
        Page<BookDTO> books = bookService.getPageOfBooks(pageable);
        return ResponseEntity.ok(books);
    }

    // 5. Update a book by its ID
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    // 6. Delete a book by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

