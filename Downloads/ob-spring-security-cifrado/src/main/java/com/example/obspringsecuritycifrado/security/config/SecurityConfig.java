package com.example.obspringsecuritycifrado.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Clase para la configuracion de seguridad Spring Security
 * */

@Configuration
@EnableWebSecurity //Permite a Spring aplicar esta configuracion a la configuracion de seguridad global
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //OVERRIDE: SOBREESCRIBIR FUNCIONALIDAD SECURITY POR DEFECTO
}
