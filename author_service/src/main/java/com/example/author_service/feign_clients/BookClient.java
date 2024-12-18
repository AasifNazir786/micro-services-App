package com.example.author_service.feign_clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.author_service.dtos.BookDTO;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="BOOK-SERVICE")
public interface BookClient {
    @GetMapping("/book/{id}")
    BookDTO getBookById(@PathVariable Long id);

    @GetMapping("/api/books/bookss")
    List<BookDTO> getListBooks(@RequestParam String ids);
}
