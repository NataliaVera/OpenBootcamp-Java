package com.example.obJavaSpring.controller;

import com.example.obJavaSpring.entity.Book;
import com.example.obJavaSpring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Devuelve Json
@RestController
public class BookController {

    @Autowired
    BookRepository repository;

    //Crud sobre la entidad Book
    //Buscar todos los libros
    @GetMapping("/api/findAllBooks")
    public List<Book> findAllBooks(){
        //recuperar y devolver los libros DB
        return repository.findAll();
    }

    //Buscar un solo libro segun su id
    @GetMapping("/api/findOneById/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOpt = repository.findById(id);

        //Programación Funcional
        //return bookOpt.orElse(null);
        //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        if(bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return  ResponseEntity.notFound().build();
    }

    //Crear un nuevo libro
    @PostMapping("/api/createBook")
    public Book createBook(@RequestBody Book newBook, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        return repository.save(newBook);
    }

    //actualizar un libro existente

    // borrar un libro

}
