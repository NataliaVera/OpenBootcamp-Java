package com.example.obJavaSpring.controller;

import com.example.obJavaSpring.entity.Book;
import com.example.obJavaSpring.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Devuelve Json
@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

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
    public ResponseEntity<Book> createBook(@RequestBody Book newBook, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if(newBook.getId() != null){
            log.warn("trying to create a boook with id");
            return ResponseEntity.badRequest().build();
        }

        Book result = repository.save(newBook);
        return ResponseEntity.ok(result);
    }

    //actualizar un libro existente
    @PutMapping ("/api/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Optional<Book> bookOptional = repository.findById(book.getId());

        if(book.getId() == null){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }

        if(!repository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        Book result = repository.save(book);

        return ResponseEntity.ok(result);
    }
    // borrar un libro
    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<Book> delecte(@PathVariable Long id){
        if(!repository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    //borrar todos
    @DeleteMapping("/api/deleteAll")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request for delete all books");
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
