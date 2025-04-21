🎮 Seven To Hell / Seven To Heaven

📝 Descripción General

Seven To Hell es un juego multijugador por turnos en el que 8 jugadores compiten ingresando números entre 0 y 100. El objetivo es acercarse lo más posible a una media modificada. A medida que avanzan las rondas, los jugadores son eliminados hasta que solo queda uno.

Seven To Heaven es una variante donde un jugador tiene el rol de ADMIN con ventajas especiales. Si el ADMIN pierde, todos los usuarios ganan.

⚙️ Requisitos del Sistema

☕ Java JDK 11 o superior

🐘 PostgreSQL 12 o superior

📦 Maven o Gradle

🚀 Instalación

Clona el repositorio:

git clone <URL-del-repositorio>

Crea una base de datos PostgreSQL:

CREATE DATABASE seven_to_hell;

Configura las credenciales en el archivo de configuración de Hibernate (hibernate.cfg.xml o similar):

<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/seven_to_hell</property>
<property name="hibernate.connection.username">tu_usuario</property>
<property name="hibernate.connection.password">tu_contraseña</property>

Ejecuta migraciones SQL o permite que Hibernate cree las tablas automáticamente según las entidades.

Compila y ejecuta:

mvn clean install
java -cp target/tu-jar-generado.jar com.tupaquete.Main

🕹️ Cómo Jugar

Regístrate como usuario.

Inicia sesión.

Espera a que 8 jugadores estén conectados.

Ingresa un número entre 0 y 100 en cada ronda.

Se calcula la media * 0.8 ➡️ quien más se acerque gana.

Pierdes puntos si no ganas, y más si empatas.

Llegar a 0 puntos = eliminado ❌

Último jugador con puntos = ganador 🏆

👑 Modo ADMIN (Seven To Heaven)

1 jugador es ADMIN

El ADMIN ve los números de los demás

Si el ADMIN pierde ➡️ todos los USERS ganan 😇

📁 Estructura del Proyecto

model/ ➡️ Entidades JPA (Usuario, Partida, etc.)

service/ ➡️ Lógica del juego y reglas

controller/ ➡️ Controladores para entrada de usuario o API

repository/ ➡️ Acceso a la base de datos

resources/ ➡️ Configuraciones y scripts SQL

🛠️ Tecnologías Utilizadas

Java ☕

Hibernate 🧩

PostgreSQL 🐘

Maven 🛠️

🙋 Autor

Iker Martínez Velasco – Desarrollador del proyecto. 💻

Si te gusta este proyecto, ¡dale una ⭐ en GitHub y clona para jugar con tus amigos!

