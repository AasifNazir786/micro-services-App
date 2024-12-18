package com.example.author_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.author_service.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
    
}
