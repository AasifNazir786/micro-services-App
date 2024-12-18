package com.example.book_service.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.book_service.DTO.BookDTO;
import com.example.book_service.DTO.BookWithAuthorDTO;

public interface BookServiceInterface {
    
    BookDTO createBook(BookDTO dto);
    Page<BookDTO> getPageOfBooks(Pageable pageable);
    BookDTO getBookById(Long id);
    BookWithAuthorDTO getBookWithAuthorDTO(Long id);
    BookDTO updateBook(Long id, BookDTO dto);
    void deleteBook(Long id);
    List<BookDTO> getBooksByIds(List<Long> ids);
}
