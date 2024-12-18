package com.example.author_service.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.author_service.custom_exceptions.AuthorNotFoundException;
import com.example.author_service.dtos.AuthorDtoWithBooks;
import com.example.author_service.dtos.BasicAuthorDTO;
import com.example.author_service.dtos.BookDTO;
import com.example.author_service.feign_clients.BookClient;
import com.example.author_service.mapper.AuthorMapper;
import com.example.author_service.model.Author;
import com.example.author_service.repository.AuthorRepository;
import com.example.author_service.service_repo.AuthorInterface;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorInterface{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookClient bookClient;

    @Override
    public BasicAuthorDTO createAuthor(BasicAuthorDTO dto) {

        if(dto == null)
            throw new IllegalArgumentException("Author can't be null");
        
        Author author = AuthorMapper.mapDtoToEntity(dto);

        return AuthorMapper.mapEntityToDto(authorRepository.save(author));
    }

    @Override
    public Page<BasicAuthorDTO> getPageAuthors(Pageable pageable) {

        Page<BasicAuthorDTO> dtos = authorRepository
                                        .findAll(pageable)
                                        .map(AuthorMapper::mapEntityToDto);

        return dtos;
    }

    @Override
    public BasicAuthorDTO getAuthorById(Long id) {
        
        Author author = validateAndRetrieveAuthor(id);

        return AuthorMapper.mapEntityToDto(author);
    }

    @Override
    public AuthorDtoWithBooks getAuthorWithBooks(Long authorId, String bookIds) {

        if (bookIds == null || bookIds.isEmpty()) {
            throw new IllegalArgumentException("No book IDs provided.");
        }
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException("author not found with id: "+ authorId));
        BasicAuthorDTO dto = AuthorMapper.mapEntityToDto(author);
        try {
            System.out.println("Fetching books for ids: " + bookIds);
            List<BookDTO> books = bookClient.getListBooks(bookIds);
            System.out.println("Fetching books for idstry: " + bookIds);
            return AuthorMapper.mapBasicAuthorDtoToAuthorDtoWithBooks(dto, books);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to fetch books for the author", ex);
        }
    }

    @Override
    public AuthorDtoWithBooks getAuthorWithBooksByAuthorId(Long authorId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BasicAuthorDTO updateAuthor(Long id, BasicAuthorDTO dto) {
        
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("author not found with id: "+id));
        
        Author savedAuthor = authorRepository.save(updatedAuthor(author, dto));

        return AuthorMapper.mapEntityToDto(savedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {

        validateAndRetrieveAuthor(id);
        authorRepository.deleteById(id);
    }
    

    // Helper Methods
    private Author validateAndRetrieveAuthor(Long id){
        if(id == null || id <= 0){
            throw new IllegalArgumentException("enter valid id");
        }

        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("author with id "+id+" not found"));
    }

    private Author updatedAuthor(Author author, BasicAuthorDTO dto){

        if(dto == null){
            return author;
        }
        author.setAuthorName(dto.getAuthorName());
        author.setAuthorBiography(dto.getAuthorBiography());
        author.setNationality(dto.getNationality());
        author.setAwards(dto.getAwards());
        
        return author;
    }
}
