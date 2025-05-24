package com.juego7th.controller;
import com.juego7th.Utils.FuncionesGenerales;
import com.juego7th.modelo.Games;
import com.juego7th.modelo.Users;
import com.juego7th.modelo.UsersGames;
import com.juego7th.service.UsersGamesService;
import com.juego7th.service.UsersService;

public class UsersController {
    private final UsersService usersService = new UsersService();
    private final UsersGamesService usersGamesService = new UsersGamesService();
    public Users loginUser(Games game) {

        System.out.println("=== INICIO SESION ===");
        System.out.println("Ingrese el email del usuario: ");
        String email = FuncionesGenerales.scanerString();
        System.out.println("Ingrese el password del usuario: ");
        String pass = FuncionesGenerales.scanerString();
        Users user = usersService.loginUser(email, pass);

        if (user != null) {
            UsersGames usergame = new UsersGames();
            usergame.setGame(game);
            usergame.setUser(user);
            usersGamesService.save(usergame);
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + user.getName() + "a la partida !"+game.getId());

        } else {
            System.out.println("Credenciales incorrectas.");
        }
        return user;
    }
    public void promptRegister() {

        System.out.println("=== Registro Usuario ===");
        System.out.print("Introduzca su nombre: ");
        String name =FuncionesGenerales.scanerString();

        System.out.print("Introduzca su nombre su email: ");
        String email =FuncionesGenerales.scanerString();

        System.out.print("Introduzca su  contraseña: ");
        String password = FuncionesGenerales.scanerString();

        String result = usersService.registrerUser(name, password, email);
        System.out.println(result);
    }
}


