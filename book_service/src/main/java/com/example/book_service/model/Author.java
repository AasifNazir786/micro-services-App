package com.example.book_service.model;

public class Author {
    private Long authorId;

    private String authorName;

    private String authorBiography;

    private String nationality;

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
