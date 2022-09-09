## JWT

Es un estandar abierto que permite transmitir información entre dos partes: navegador y servidor

### Funcionamiento Session
1. Cliente envia una petición a un servidor (/api/login)
2. Servidor valida username y password, si no son validos devolvera una respuesta 401 unauthorized
3. Servidor valida username y password, si son validos entonces se almacena el usuario en session
4. Se genera una cookie en el Cliente 
5. En proximas peticiones se comprueba que el cliente esta en session

##### Desventajas:
* La informacion de la session se almacena en el servidor, lo cual consume recursos.


### Funcionamiento JWT
1. Cliente envia una peticion a un servidor (/api/login)
2. Servidor valida username y password,si no son válidos devolverá una respuesta 401 
    unauthorized
3. Servidor válida username y password, si son válidos entonces genera un token JWT utilizando una secret key
4. Servidor devuelve el token JWT generado al Cliente 
5. Cliente envia peticiones a los endpoints REST del servidor utilizando el token JWT en las cabeceras
6. Servidor valida el token JWT en cada peticion y si es correcto permite el acceso a los datos 


##### Ventajas: 
* El token se almacena en el Cliente, de manera que consuma menos recursos en el Servidor, lo cual permite
mejor escalabilidad 

##### Desventajas:
* El token esta en el navegador, no podriamos invalidaro antes de la fecha de expiracion asignada cuando
se creo 
* Lo que se realiza es dar la opcion de logout , lo cual simplemente borra el token 

### Estructura del Token JWT
3 partes separadas por un punto (.) y codificadas en base 64 cada una: 
1. Header
   ```json 
   {
        "alg": "HS512",
        "typ": "JWT"
   }
   ```
2. Payload (información, datos del usuario que no son sensibles)
    ```json 
   {
        "name": "John Doe",
        "admin": true
   }
   ```
3. Signatura
```
  HMACKSHA256(
    base64Encode(header+ "." + base64UrlEncode(payload), secret
  )
 ```

El User-Agent envia el token JWT en las cabeceras: 
 ```
 Authorization: Bearer <token> 
 ```

### Configuración Spring 
Crear proyecto Spring Boot  con: 
* Spring Security
* Spring Web
* Spring Boot Dev tools
* Spring Data JPA
* PostgreSQL
* Dependencia JWT (se añade en el pom.xml)

 ```
 <dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt</artifactId>
	<version>0.9.1</version>
 </dependency>
 ```