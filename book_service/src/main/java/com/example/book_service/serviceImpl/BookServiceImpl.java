package com.example.book_service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.book_service.DTO.BookDTO;
import com.example.book_service.DTO.BookWithAuthorDTO;
import com.example.book_service.custom_exceptions.BookNotFoundException;
import com.example.book_service.mapper.BookMapper;
import com.example.book_service.model.Author;
import com.example.book_service.model.Book;
import com.example.book_service.repository.BookRepository;
import com.example.book_service.service.BookServiceInterface;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookServiceImpl implements BookServiceInterface{
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public BookDTO createBook(BookDTO dto) {
        
        if(dto == null){
            throw new IllegalArgumentException("BookDTO can not be null");
        }
        Book book = BookMapper.dtoToEntity(dto);

        return mapEntityToDTO(bookRepository.save(book));
    }

    @Override
    public List<BookDTO> getBooksByIds(List<Long> ids){
        List<BookDTO> books = new ArrayList<>();
        for(var id : ids){
            BookDTO book = getBookById(id);
            books.add(book);
        }
        return books;
    }

    @Override
    public BookDTO getBookById(Long bookId){
        if(bookId == null){
            throw new IllegalArgumentException("Please enter valid id:");
        }
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new EntityNotFoundException("Book not found with id: "+bookId));

        return mapEntityToDTO(book);
    }

    @Override
    public BookWithAuthorDTO getBookWithAuthorDTO(Long bookId){

        BookWithAuthorDTO bookWithAuthorDTO = validateAndRetrieveBookWithAuthorDTO(bookId);
        return bookWithAuthorDTO;
    }

    @Override
    public Page<BookDTO> getPageOfBooks(Pageable pageable) {
        
        Page<Book> bookPage = bookRepository.findAll(pageable);

        Page<BookDTO> bookDTOPage = bookPage.map(this::mapEntityToDTO);

        return bookDTOPage;
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO dto) {
        
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Book not found with id: "+id));
        
        Book savedBook = bookRepository.save(updateBook(book, dto));

        return mapEntityToDTO(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        
        if(bookRepository.existsById(id)){

            bookRepository.deleteById(id);
        }else{
            throw new BookNotFoundException("Book not exists with id: "+id);
        }

    }


    // Helper methods
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
        return BookMapper.mapBookWithAuthorDTO(book, author);
    }


    private Author getAuthor(Long authorId){
        try{
            return restTemplate.getForObject("http://author-service/api/authors/"+ authorId, Author.class);

        }catch(RestClientException e){
            
            System.err.println("Failed to fetch author with id: " + authorId + ". Reason: " + e.getMessage());
            return new Author(authorId, "Unknown Author", null, null, null);
        }
        
    }

    private Book updateBook(Book book, BookDTO dto){

        book.setBookPrice(dto.getBookPrice());
        book.setBookStock(dto.getBookStock());
        book.setBookTitle(dto.getBookTitle());
        book.setGenre(dto.getGenre());
        book.setPublicationDate(dto.getPublicationDate());
        book.setAuthorId(dto.getAuthorId());
        return book;
    }
}
