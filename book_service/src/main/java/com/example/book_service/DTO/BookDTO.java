package com.example.book_service.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.book_service.enums.GenreType;

public class BookDTO {
    private long bookId;

    private String bookTitle;

    private long bookStock;
    
    private BigDecimal bookPrice;

    private GenreType genre;

    private LocalDate publicationDate;

    private long authorId;

    public BookDTO() {
    }

    public BookDTO(long bookId, String bookTitle, long bookStock, BigDecimal bookPrice, GenreType genre,
            LocalDate publicationDate, long authorId) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookStock = bookStock;
        this.bookPrice = bookPrice;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.authorId = authorId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
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
}

