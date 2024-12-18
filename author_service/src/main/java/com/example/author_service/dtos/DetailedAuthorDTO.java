package com.example.author_service.dtos;

import java.util.List;

public class DetailedAuthorDTO extends BasicAuthorDTO{

    private List<Integer> bookIds;

    public DetailedAuthorDTO() {
    }

    public DetailedAuthorDTO(Long authorId, String authorName, String authorBiography, String nationality, String awards, List<Integer> bookIds) {

        super(authorId, authorName, nationality, authorBiography, awards);
        this.bookIds = bookIds;
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Integer> bookIds) {
        this.bookIds = bookIds;
    }
}
