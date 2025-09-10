package com.juego7th.views;
import com.juego7th.Utils.FuncionesGenerales;
import com.juego7th.controller.GamesController;
import com.juego7th.controller.UsersController;
import com.juego7th.controller.UsersGamesController;
import com.juego7th.modelo.Games;
import com.juego7th.modelo.Users;
import java.util.Scanner;
public class MainMenu {
    public static void menu(){

         final UsersController usersController = new UsersController();
         final UsersGamesController usersGamesController = new UsersGamesController();
         final GamesController gamesController = new GamesController();

         Games games = null;
         Users user = null;
         Scanner scanner = new Scanner(System.in);

         int opcion;
            do {
                vista();
                opcion = FuncionesGenerales.scanerNum();

                // Limpiar el buffer
                switch (opcion) {
                    case 1:
                        usersController.promptRegister();
                        break;

                    case 2:
                        if (games == null) {
                            System.out.println("Primero debes crear una partida (opción 3).");
                        } else {
                            user = usersController.loginUser(games);
                        }
                        break;

                    case 3:
                        if (games == null) {
                            games = gamesController.startGame();
                            System.out.println("Partida creada con ID: " + games.getId());
                        } else {
                            System.out.println("Ya hay una partida activa con ID: " + games.getId());
                        }
                        break;
                        
                    case 4:
                        if (games == null) {
                            System.out.println("Primero debes crear una partida.");
                        } else {
                            usersGamesController.logicaJuego(games);
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo del juego. ¡Hasta pronto!");
                        break;
                        
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 5);
            scanner.close();
    }
    
    public static void vista(){

        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar sesión");
        System.out.println("3. Crear Partida");
        System.out.println("4. Jugar");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");

    }
  



