package obJavaSpring.Ejercicios.Ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    NotificationService notificationService;

    public UserService(NotificationService notificationService){
        System.out.println("Ejecutando constructor de UserService");
        this.notificationService = notificationService;
    }
}
