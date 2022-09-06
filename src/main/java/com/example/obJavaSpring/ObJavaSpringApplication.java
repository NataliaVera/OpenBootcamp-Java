package com.example.obJavaSpring;

import com.example.obJavaSpring.entity.Book;
import com.example.obJavaSpring.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObJavaSpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObJavaSpringApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		//Crear libro
		System.out.println("Número de libros en DB:"+repository.findAll().size());

		Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 200, 29.99, LocalDate.of(2018, 12, 1), true);
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 200, 19.99, LocalDate.of(2013, 12, 1), true);

		//Almacenar Libro
		repository.save(book1);
		repository.save(book2);

		//Recuperar todos los libros
		System.out.println("Número de libros en DB:"+repository.findAll().size());

		//Borrar un libro
		//repository.deleteById(1L);

		System.out.println("Número de libros en DB:"+ repository.findAll().size());


	}

}
