package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //atributos
    private BookRepository bookRepository;
    //constructor

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD sobre la entidad Book

    //Buscar todos los libros

    /**
     * http://localhost:8090/api/books
     * @return JSON books list
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //recuperar y devolver los libros
        return bookRepository.findAll();
    }
    /**
     * http://localhost:8090/api/books
     * @return JSON books list
     */
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        //recuperar y devolver los libros
        Optional<Book> book=bookRepository.findById(id);
        //return book.orElse(null);
        if(book.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(book.get());
        }
        //return book.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return bookRepository.save(book);
    }
}
