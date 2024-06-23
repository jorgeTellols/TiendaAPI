# API de Academia/Tienda músical.

"Back" de un sitio web pensado para ser una academia de música y a la vez tienda de instrumentos. Puede efectuar una par de operaciones CRUD básicas y estaba preparada para añadir futuras funcionalidades, pero no llegé a crearlas por falta de tiempo. La API tiene las dependencias para usar swagger, así que genera documentación sobre todos sus endpoints al ser lanzada. El unico requisito para su correcto lanzamiento es definir una database vacia en un servidor postgreSQL llamada "academiaModoFrigio", una vez creada manualmente la creación/actualización de las tablas se producirá siempre que se lanze el proyecto

Esta API fue la parte "Back" de mi TFG y he decidido subirla para dejar constancia de ella ya que, a diferencia de la parte "Front", estuve satisfecho con el resultado. La API genera una base de datos y prepara los endpoints para ser consumida por otra aplicación.  

## Tecnologias utilizadas

- JAVA
- SpringBoot
- Lombok
- MapStruct
- PostgreSQL

## Principios/Metodologías seguidos

- Code First
- Arquitectura Clean
- APIRESTful

## Esquema relacional de la base de datos

<br>
<p align="center">
  <img align="center" src="./src/assets/Esquema ER.png"/>
</p>

