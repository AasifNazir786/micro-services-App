package com.example.author_service.service_repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.author_service.dtos.AuthorDtoWithBooks;
import com.example.author_service.dtos.BasicAuthorDTO;

public interface AuthorInterface {
    
    BasicAuthorDTO createAuthor(BasicAuthorDTO dto);
    Page<BasicAuthorDTO> getPageAuthors(Pageable pageable);
    BasicAuthorDTO getAuthorById(Long id);
    AuthorDtoWithBooks getAuthorWithBooks(Long authorId, String bookIds);
    AuthorDtoWithBooks getAuthorWithBooksByAuthorId(Long authorId);
    BasicAuthorDTO updateAuthor(Long id, BasicAuthorDTO dto);
    void deleteAuthor(Long id);
    
}
