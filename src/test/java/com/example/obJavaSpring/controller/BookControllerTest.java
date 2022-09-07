package com.example.obJavaSpring.controller;

import com.example.obJavaSpring.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate; // nos va a permitir utilizar los métodos HTTP

    @Autowired //Inyectar
    private RestTemplateBuilder restTemplateBuilder; //Objeto que nos va a permitir construir el TestRestTemplate

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAllBooks() {
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/findAllBooks", Book[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());//Estado de la perticion sea un 200
        assertEquals(200, response.getStatusCodeValue());

        List<Book> books = Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Book> response = testRestTemplate.getForEntity("/api/findOneById/1", Book.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void createBook() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json = "{\n" +
                "    \"id\": null,\n" +
                "    \"title\": \"Libro creado desde Spring Test\",\n" +
                "    \"author\": \"Autor\",\n" +
                "    \"pages\": 480,\n" +
                "    \"price\": 23.50,\n" +
                "    \"releaseDate\": \"2019-10-08\",\n" +
                "    \"online\": true\n" +
                "}";

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Book> response = testRestTemplate.exchange("/api/createBook", HttpMethod.POST, request, Book.class);

        Book result = response.getBody();

        assertEquals(1L, result.getId());
        assertEquals("Libro creado desde Spring Test", result.getTitle());

    }
}