package com.example.obspringsecuritycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ObSpringSecurityCifradoApplication {

	//esto va en una clase config
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringSecurityCifradoApplication.class, args);

		UserRepository repository = context.getBean(UserRepository.class); //extraer los repositorios para guardar en DB

		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		User user1 = new User(null, "user1", encoder.encode("admin"));
		User user2 = new User(null, "user2", "12345");
		User user3 = new User(null, "user3", "6789");

		repository.save(user1);
		repository.save(user2);
		repository.save(user3);

	}

}
