package com.example.author_service.dtos;

public class BasicAuthorDTO {
    private Long authorId;

    private String authorName;

    private String nationality;

    private String authorBiography;

    private String awards;

    public BasicAuthorDTO() {
    }

    public BasicAuthorDTO(Long authorId, String authorName, String nationality, String authorBiography, String awards) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.nationality = nationality;
        this.authorBiography = authorBiography;
        this.awards = awards;
    }

    public String getAuthorBiography() {
        return authorBiography;
    }

    public void setAuthorBiography(String authorBiography) {
        this.authorBiography = authorBiography;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
