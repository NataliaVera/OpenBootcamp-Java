package obJavaSpring.Ejercicios;

import obJavaSpring.Ejercicios.Ejercicio1.Saludo;
import obJavaSpring.Ejercicios.Ejercicio2.NotificationService;
import obJavaSpring.Ejercicios.Ejercicio2.UserService;
import obJavaSpring.Ejercicios.Ejercicio3.User;
import obJavaSpring.Ejercicios.Ejercicio3.UserRepository;
import obJavaSpring.Ejercicios.Ejercicio5.Laptop;
import obJavaSpring.Ejercicios.Ejercicio5.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObJavaSpringApplicationEjercicios {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObJavaSpringApplicationEjercicios.class, args);

		//Ejercicio 1
		Saludo saludo = (Saludo)  context.getBean("saludo");
		String texto = saludo.Saludos();
		System.out.println(texto);

		//Ejercicio 2
		UserService userService = (UserService) context.getBean("user");
		System.out.println(userService);

		//Ejercicio3
		UserRepository userRepository = context.getBean(UserRepository.class);

		User user = new User(null, "User 1", "user1@gmail.com");
		userRepository.save(user);

		System.out.println(userRepository.findAll());

		//Ejercicio 5
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop1= new Laptop(null, "ASUS", "ROG", 6599000.00, 16);
		Laptop laptop2= new Laptop(null, "ASUS", "TUF", 5799000.00, 16);
		Laptop laptop3= new Laptop(null, "MacBook Pro", "Mac14,7", 13990000.00, 512);



	}

}
