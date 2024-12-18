package com.example.author_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name", nullable=false)
    private String authorName;

    @Column(name="author_bio")
    private String authorBiography;

    @Column(name = "nationality", nullable=false)
    private String nationality;

    @Column(name = "awards")
    private String awards;

    public Author() {
    }

    public Author(Long authorId, String authorName, String authorBiography, String nationality, String awards) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorBiography = authorBiography;
        this.nationality = nationality;
        this.awards = awards;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }
}
