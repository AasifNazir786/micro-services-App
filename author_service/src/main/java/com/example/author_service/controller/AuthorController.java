package com.example.author_service.controller;

import com.example.author_service.service_impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.author_service.dtos.AuthorDtoWithBooks;
import com.example.author_service.dtos.BasicAuthorDTO;
import com.example.author_service.service_repo.AuthorInterface;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    
    @Autowired
    private AuthorServiceImpl authorService;

    @PostMapping
    public ResponseEntity<BasicAuthorDTO> createAuthor(@RequestBody BasicAuthorDTO dto){

        BasicAuthorDTO author = authorService.createAuthor(dto);

        if(author != null)
            return new ResponseEntity<>(author, HttpStatus.CREATED);
        
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<BasicAuthorDTO>> getAuthorsPage(Pageable pageable){

        Page<BasicAuthorDTO> page = authorService.getPageAuthors(pageable);

        if(page != null)
            return ResponseEntity.ok(page);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<BasicAuthorDTO> getAuthorById(@PathVariable("authorId") Long id){

        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @GetMapping("/author/{id}/books")
    public ResponseEntity<AuthorDtoWithBooks> getAuthorWithBooks(@PathVariable Long id, @RequestParam("ids") String ids){

        AuthorDtoWithBooks authorWithBooks = authorService.getAuthorWithBooks(id, ids);
        if(authorWithBooks != null){
            return new ResponseEntity<>(authorWithBooks ,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BasicAuthorDTO> updateAuthor(@PathVariable Long id ,@RequestBody BasicAuthorDTO dto){

        BasicAuthorDTO updatedDto = authorService.updateAuthor(id, dto);

        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){

        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
