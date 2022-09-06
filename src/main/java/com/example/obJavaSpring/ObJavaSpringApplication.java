package com.example.obJavaSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObJavaSpringApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObJavaSpringApplication.class, args);

		CocheRepository repository = context.getBean(CocheRepository.class);

		System.out.println("El numero de coches en DB es: "+repository.count());

		//crear y almacenar un coche en DB
		Coche toyota = new Coche(null, "Toyota", "Prius", 2010);
		repository.save(toyota);//guarda en base de datos

		System.out.println("El numero de coches en DB es: "+repository.count());

		//recupera un coche por id
		System.out.println(repository.findAll()); //obtiene todos. Devuelve una lista

	}

}
