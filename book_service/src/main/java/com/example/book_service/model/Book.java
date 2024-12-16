package com.example.book_service.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.book_service.enums.GenreType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "book_title", nullable=false)
    private String bookTitle;

    @Column(name = "book_stock", nullable=false)
    private Long bookStock;

    @Column(name = "book_price", nullable=false)
    private BigDecimal bookPrice;

    @Column(name = "genre", nullable=false)
    @Enumerated(EnumType.STRING)
    private GenreType genre;

    @Column(name = "publication_date", nullable=false)
    private LocalDate publicationDate;

    @Column(name="author_id", nullable=false)
    private Long authorId;

    public Book() {
    }

    public Book(Long bookId, String bookTitle, Long bookStock, BigDecimal bookPrice, GenreType genre,
            LocalDate publicationDate, Long authorId) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookStock = bookStock;
        this.bookPrice = bookPrice;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.authorId = authorId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}