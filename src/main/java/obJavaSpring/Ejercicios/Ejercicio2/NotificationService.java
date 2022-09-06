package obJavaSpring.Ejercicios.Ejercicio2;

import obJavaSpring.Ejercicios.Ejercicio1.Saludo;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public NotificationService(){
        System.out.println("Ejecutando constructor NotificationService");
    }

    public String UserNotification(){
        return "Notificacion de usuario";
    }
}
