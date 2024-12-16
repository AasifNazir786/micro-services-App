package com.example.book_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.book_service.DTO.BookDTO;
import com.example.book_service.DTO.BookWithAuthorDTO;
import com.example.book_service.mapper.BookMapper;
import com.example.book_service.model.Author;
import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate rt;

    public BookDTO getBook(Long bookId){
        if(bookId == null){
            throw new IllegalArgumentException("Please enter valid id:");
        }
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new EntityNotFoundException("Book not found with id: "+bookId));

        return mapEntityToDTO(book);
    }

    public BookWithAuthorDTO getBookWithAuthorDTO(Long bookId){
        BookWithAuthorDTO bookWithAuthorDTO = validateAndRetrieveBookWithAuthorDTO(bookId);
        return bookWithAuthorDTO;
    }


    private BookDTO mapEntityToDTO(Book book){

        BookDTO dto = BookMapper.entityToDTO(book);
        if(book.getAuthorId() != null)
            dto.setAuthorId(book.getAuthorId());

        return dto;
    }

    private BookWithAuthorDTO validateAndRetrieveBookWithAuthorDTO(Long bookId){
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new EntityNotFoundException("Book not found with id: "+bookId));
        
        Author author = null;
        if(book.getAuthorId() != null){
            author = getAuthor(book.getAuthorId());
        }
        return BookMapper.getBookWithAuthorDTO(book, author);
    }


    private Author getAuthor(Long authorId){
        try{
            return rt.getForObject("http://localhost:8081/api/authors/"+ authorId, Author.class);

        }catch(RestClientException e){
            
            System.err.println("Failed to fetch author with id: " + authorId + ". Reason: " + e.getMessage());
            return new Author(authorId, "Unknown Author", null, null, null);
        }
        
    }
}
