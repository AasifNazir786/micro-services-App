package com.example.author_service.mapper;

import java.util.List;

import com.example.author_service.dtos.AuthorDtoWithBooks;
import com.example.author_service.dtos.BasicAuthorDTO;
import com.example.author_service.dtos.BookDTO;
import com.example.author_service.model.Author;

public class AuthorMapper {
    
    public static Author mapDtoToEntity(BasicAuthorDTO dto){
        if(dto == null){
            return null;
        }
        return new Author(dto.getAuthorId(),
                        dto.getAuthorName(),
                        dto.getAuthorBiography(),
                        dto.getNationality(),
                        dto.getAwards()
                    );
    }

    public static BasicAuthorDTO mapEntityToDto(Author author){

        if(author == null){
            return null;
        }

        BasicAuthorDTO dto = new BasicAuthorDTO();

        dto.setAuthorId(author.getAuthorId());
        dto.setAuthorName(author.getAuthorName());
        dto.setAuthorBiography(author.getAuthorBiography());
        dto.setNationality(author.getNationality());
        dto.setAwards(author.getAwards());

        return dto;
    }

    public static AuthorDtoWithBooks mapBasicAuthorDtoToAuthorDtoWithBooks(BasicAuthorDTO dto,
            List<BookDTO> books) {
        
         return new AuthorDtoWithBooks(
                dto.getAuthorId(),
                dto.getAuthorName(),
                dto.getNationality(),
                dto.getAuthorBiography(),
                dto.getAwards(), books
        );
    }
}
