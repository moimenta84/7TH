package com.juego7th.controller;
import com.juego7th.Utils.FuncionesGenerales;
import com.juego7th.modelo.Games;
import com.juego7th.modelo.Users;
import com.juego7th.modelo.UsersGames;
import com.juego7th.service.UsersGamesService;
import com.juego7th.service.UsersService;
import java.util.List;

public class UsersGamesController {

    private final UsersGamesService usersGamesService = new UsersGamesService();
    private final UsersService usersser = new UsersService();
    // Devuelve lista de usuarios de una partida por su ID
    public List<UsersGames> getUsersByGameId(int gameId) {
        return usersGamesService.getUsersByGameId(gameId);
    }

    public void addUserToGame(int userId, int gameId) {
        usersGamesService.addUserToGame(userId, gameId);
    }

    public String insertNumber(Users user, Games game, int numero) {
        // si necesitas devolver el objeto, usa obtainNumber
        return usersGamesService.addNumSelection(user,numero,game);
    }
    public void logicaJuego(Games game) {

        int id = game.getId();
        List<UsersGames> jugadores = usersGamesService.getUsersByGameId(id);

        if (jugadores.size() >= 2) {
            System.out.println("La partida ha comenzado");
            System.out.println("1. Introducir número");
            System.out.println("2. Salir");
            int opcion = FuncionesGenerales.scanerNum();
            switch (opcion) {
                case 1:
                    for (UsersGames user : jugadores) {
                        Users jugador = usersser.getUserById(user.getUser().getId());
                        System.out.println(jugador.getName() + ": Introduzca un número entre 0 y 100");
                        int numero = FuncionesGenerales.scanerNum();
                        user.setNumeroSeleccionado(numero);
                        usersGamesService.update(user);
                    }
                    Users winner =  usersGamesService.getWinner(jugadores);
                    System.out.println("EStoy en la linea 46 El ganador es: " + winner.getName());
                    usersGamesService.penalizaciones(winner, jugadores);
                    System.out.println("Jugador ganador " + winner.getName());
                    break;
                case 2:
                    System.out.println("Saliendo del juego...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("Se necesitan al menos 2 jugadores para jugar.");
        }
    }
    public void penalizaciones(Games game) {

       List <UsersGames>participantes = usersGamesService.getUsersByGameId(game.getId());

       if(participantes.isEmpty()) {
           System.out.println("No hay participantes.");
       }else{
           Users ganador = usersGamesService.getWinner(participantes);
           if(ganador != null) {
               System.out.println("Ganador " + ganador.getName());
           }else{
               System.out.println("No hay ganadores");
           }
           usersGamesService.penalizaciones(ganador, participantes);
       }
    }
}
