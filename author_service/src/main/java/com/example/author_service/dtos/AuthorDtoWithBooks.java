package com.example.author_service.dtos;

import java.util.List;

public class AuthorDtoWithBooks extends BasicAuthorDTO{
    
    private List<BookDTO> books;

    public AuthorDtoWithBooks(){}

    public AuthorDtoWithBooks(Long authorId, String authorName, String nationality, String authorBiography, String awards, List<BookDTO> books){
        super(authorId, authorName, nationality, authorBiography, awards);
        this.books = books;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
