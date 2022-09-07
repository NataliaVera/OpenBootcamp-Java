package obJavaSpring.Ejercicios.Ejercicio5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LaptopController {

    //http://localhost:8080/api/findAllLaptop
    @Autowired
    LaptopRepository repository;

    @GetMapping("/api/findAllLaptop")
    public List<Laptop> findAllLaptop(){
        return repository.findAll();
    }
}
