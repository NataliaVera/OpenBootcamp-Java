package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     *BCrypt que genera su propio salt de 16 bytes
     *
     * El resultado de cifrar con bcrypt sera un string 60 caracteres:
     *
     * $a version
     * $10 fuerza (valor que va de 4 a 31, por defecto vale 10)
     * Los 22 siguientes caracteres son el salt generado
     *
     * */
    @Test
    void bcryptTest(){
    //Codificar contraseñas y comprobarlas
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

        boolean matches = passwordEncoder.matches("admin", hashedPassword);// devuelve un Boolean si las contraseñas son iguales
        System.out.println(matches);

    }

    @Test
    void bcryptCheckMultiplePasswords(){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for(int i = 0; i < 30; i++){
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void pbkdf2() {
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        for(int i = 0; i< 10; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void argon() {
        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
        for(int i = 0; i< 10; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void scrypt() {
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
        for(int i = 0; i< 10; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void springPasswordEncoder(){

        String idForEncode = "bcrypt";

        Map<String, PasswordEncoder> encoderMap = new HashMap<>();
        encoderMap.put("bcrypt", new BCryptPasswordEncoder());
        encoderMap.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoderMap.put("argon2", new Argon2PasswordEncoder());
        encoderMap.put("scrypt", new SCryptPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoderMap);


    }
}
