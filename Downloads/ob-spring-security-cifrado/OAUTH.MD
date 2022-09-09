# Open Authorization (OAuth)

Es un framework de autorizacion, abierto y esta construido por estandares IETF y licenciado bajo
OpenWeb Foundation.

Es un protocolo de delegacion: 

Permite que alguien que controla un recurso permita a una aplicacion de software acceder a ese recurso
en su propio nombre sin pasar por ello.

Con la ayuda de OAuth los usuarios pueden autorizar a third part applications a acceder a sus datos o ejecutar
determinadas operaciones sin necesidad de proporcionar usuario y contraseña.

## Flujo de trabajo con OAuth: 
1. Una aplicacion solicita autenticacion 
2. Se realiza login mediante Google
3. La aplicacion se comunica con Google donde utilizan las credenciales de Google sin que la aplicacion
pueda verlas. 
4. El servidor de Google pregunta al usuario si desea conceder X permisos
5. El usuario acepta los permisos 
6. Google genera un token de acceso como respuesta 
7. La aplicacion utiliza ese token 

## Escenarios para utilizar OAuth
1. Autenticacion HTTP en la que no se quiere utilizar usuario y contraseña todo el tiempo 
2. Evitar multiples aplicaciones dentro de una misma empresa y en consecuencia multiples cuentas con el 
mismo usuario y contraseña
3. Arquitectura de microservicios 
4. Interacion de aplicaciones de terceros 


## Proveedores 
* Google
* GitHub
* Facebook
* Okta

## OAuth Spring Security
Se sobreescribe para hacerlo mas eficiente, con un codigo base mas sencillo.

Incluye: 
* Cliente Support
* Resource server 

## Flujo de Accion 
* Authorization code 
* Implicit
* Resource owner password credentials 
* cliente credentials 
* refresh token 
 c 
