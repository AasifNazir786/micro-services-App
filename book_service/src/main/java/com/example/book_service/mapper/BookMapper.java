package com.example.book_service.mapper;

import com.example.book_service.DTO.BookDTO;
import com.example.book_service.DTO.BookWithAuthorDTO;
import com.example.book_service.model.Author;
import com.example.book_service.model.Book;

public class BookMapper {

    public static Book dtoToEntity(BookDTO dto){
        Book book = new Book();
        book.setBookPrice(dto.getBookPrice());
        book.setBookStock(dto.getBookStock());
        book.setBookTitle(dto.getBookTitle());
        book.setGenre(dto.getGenre());
        book.setPublicationDate(dto.getPublicationDate());
        book.setAuthorId(dto.getAuthorId());
        return book;
    }

    public static BookDTO entityToDTO(Book book){
        BookDTO dto = new BookDTO();
        dto.setBookId(book.getBookId());
        dto.setBookPrice(book.getBookPrice());
        dto.setBookStock(book.getBookStock());
        dto.setBookTitle(book.getBookTitle());
        dto.setGenre(book.getGenre());
        dto.setPublicationDate(book.getPublicationDate());
        return dto;
    }

    public static BookWithAuthorDTO getBookWithAuthorDTO(Book book, Author author){
        return new BookWithAuthorDTO(book.getBookId(),
                    book.getBookTitle(), book.getBookStock(),
                    book.getBookPrice(), book.getGenre(),
                    book.getPublicationDate(), author);
    }
    
}
