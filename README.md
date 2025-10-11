
# 🎮 Seven To Hell / Seven To Heaven

## 📝 Descripción General

**Seven To Hell** es un juego multijugador por turnos en el que 8 jugadores compiten ingresando números entre 0 y 100.  
El objetivo es acercarse lo más posible a una media modificada.  
A medida que avanzan las rondas, los jugadores con menor puntuación son eliminados hasta que solo queda uno.

**Seven To Heaven** es una variante donde un jugador tiene el rol de **ADMIN** con ventajas especiales.  
Si el ADMIN pierde, todos los usuarios ganan automáticamente.

---

## ⚙️ Requisitos del Sistema

- ☕ **Java JDK 11 o superior**  
- 🐘 **PostgreSQL 12 o superior**  
- 📦 **Maven o Gradle**  
- 💻 **IDE recomendado:** IntelliJ IDEA / Eclipse / VS Code  

---
## 🕹️ Cómo Jugar

Regístrate como usuario.  
Inicia sesión en el sistema.  
Espera a que haya 8 jugadores conectados.  
Ingresa un número entre 0 y 100 en cada ronda.  
El sistema calcula la media * 0.8 → quien más se acerque gana la ronda.  
Los jugadores que no ganan pierden puntos; empatar también resta puntuación.  
Si llegas a 0 puntos, quedas eliminado ❌  
El último jugador con puntos es el ganador 🏆  

### 👑 Modo ADMIN (Seven To Heaven)

1 jugador actúa como ADMIN.  
El ADMIN puede ver los números de los demás jugadores.  
Si el ADMIN pierde, todos los USERS ganan 😇  
Este modo añade un componente estratégico en el que los demás deben coordinarse para derrotar al ADMIN.
src/
├── main/
│   ├── java/com/seventohell/
│   │   ├── model/         ➡️ Entidades JPA (Usuario, Partida, Ronda, etc.)
│   │   ├── service/       ➡️ Lógica del juego, validaciones y reglas
│   │   ├── controller/    ➡️ Controladores de entrada o API REST
│   │   ├── repository/    ➡️ Interfaces DAO para acceso a base de datos
│   │   └── Main.java      ➡️ Clase principal del juego
│   └── resources/
│       ├── hibernate.cfg.xml  ➡️ Configuración de Hibernate
│       ├── application.properties / log4j.properties
│       └── scripts.sql        ➡️ Scripts de inicialización (si aplica)
└── test/
    └── java/com/seventohell/  ➡️ Pruebas unitarias con JUnit


Si el ADMIN pierde, todos los USERS ganan 😇

Este modo añade un componente estratégico en el que los demás deben coordinarse para derrotar al ADMIN.``
