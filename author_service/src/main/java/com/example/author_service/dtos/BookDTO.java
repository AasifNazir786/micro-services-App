package com.example.author_service.dtos;

import java.math.BigDecimal;

import com.example.author_service.enums.BookGenre;

public class BookDTO {

    private Long bookId;
    private String bookTitle;
    private Long bookStock;
    private BigDecimal bookPrice;
    private BookGenre genre;
    private String publicationDate;
    
    public BookDTO() {
    }

    public BookDTO(Long bookId, String bookTitle, Long bookStock, BigDecimal bookPrice, BookGenre genre, String publicationDate) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookStock = bookStock;
        this.bookPrice = bookPrice;
        this.genre = genre;
        this.publicationDate = publicationDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Long getBookStock() {
        return bookStock;
    }

    public void setBookStock(Long bookStock) {
        this.bookStock = bookStock;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
