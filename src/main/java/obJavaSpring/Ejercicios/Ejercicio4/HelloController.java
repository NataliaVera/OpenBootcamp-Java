package obJavaSpring.Ejercicios.Ejercicio4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloController")
    public String saludo(){
        return "Hola desde el controlador HelloController";
    }
}
