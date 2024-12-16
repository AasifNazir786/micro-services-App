package com.example.book_service.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.book_service.enums.GenreType;
import com.example.book_service.model.Author;

public class BookWithAuthorDTO {
    private long bookId;

    private String bookTitle;

    private long bookStock;
    
    private BigDecimal bookPrice;

    private GenreType genre;

    private LocalDate publicationDate;

    private Author author;

    public BookWithAuthorDTO() {
    }

    public BookWithAuthorDTO(long bookId, String bookTitle, long bookStock, BigDecimal bookPrice, GenreType genre,
            LocalDate publicationDate, Author author) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookStock = bookStock;
        this.bookPrice = bookPrice;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.author = author;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public long getBookStock() {
        return bookStock;
    }

    public void setBookStock(long bookStock) {
        this.bookStock = bookStock;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
