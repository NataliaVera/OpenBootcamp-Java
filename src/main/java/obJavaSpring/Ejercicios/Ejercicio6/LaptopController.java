package obJavaSpring.Ejercicios.Ejercicio6;

import obJavaSpring.Ejercicios.Ejercicio5.Laptop;
import obJavaSpring.Ejercicios.Ejercicio5.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {

    @Autowired
    LaptopRepository repository;

    public Laptop createLaptop(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        return repository.save(laptop);
    }
}
