package com.juego7th.service;
import com.juego7th.modelo.Games;
import com.juego7th.modelo.Users;
import com.juego7th.modelo.UsersGames;
import com.juego7th.repository.GamesRepository;
import com.juego7th.repository.UsersGamesRepository;
import com.juego7th.repository.UsersRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersGamesService {

    private final UsersRepository usersRepository = new UsersRepository();
    private final GamesRepository gamesRepository = new GamesRepository();
    private final GamesService gamesService = new GamesService();
    private final UsersGamesRepository usersGamesRepository = new UsersGamesRepository();

    // Devuelve directamente la lista de usuarios en una partida
    public
    List<UsersGames> getUsersByGameId(int gameId) {
        return usersGamesRepository.findUsersByGameId(gameId);
    }
    // Añadir usuario a partida
    public String addUserToGame(int userId, int gameId) {
        Users user = usersRepository.getfindById(userId);
        Games game = gamesRepository.getfindById(gameId);

        if (user == null || game == null) {
            return "El usuario o la partida no existen.";
        }
        UsersGames usersGames = new UsersGames();
        usersGames.setUser(user);
        usersGames.setGame(game);
        usersGamesRepository.create(usersGames);
        return "Se ha guardado correctamente el usuario: " + user.getName() + " en la partida: " + game.getId();
    }

    // Guardar número del jugador
    public String addNumSelection(Users user, int numero, Games game) {
        if (numero < 0 || numero > 100) {
            return "Número inválido. Debe estar entre 0 y 100.";
        }

        UsersGames usersGames = usersGamesRepository.findByUserAndGame(user, game);

        if (usersGames == null) {
            usersGames = new UsersGames();
            usersGames.setUser(user);
            usersGames.setGame(game);
        }
        usersGames.setNumeroSeleccionado(numero);
        usersGamesRepository.saveOrUpdate(usersGames);
        usersRepository.update(user);
        return "Número " + numero + " guardado correctamente para " + user.getName() +
                ". Vidas restantes: " + usersGames.getVidas();
    }
    public
    void save(UsersGames usersGames) {
        usersGamesRepository.create(usersGames);
    }
    public
    void update(UsersGames usersGames) {
        usersGamesRepository.update(usersGames);
    }

    public Users getWinner(List<UsersGames> usersGames) {
        if (usersGames == null || usersGames.isEmpty()) return null;

        // 1. Calcular suma total
        double suma = 0;
        for (UsersGames ug : usersGames) {
            suma += ug.getNumeroSeleccionado();
        }

        // 2. Calcular media y multiplicar por 0.8
        double media = suma / usersGames.size();
        double objetivo = media * 0.8;

        // 3. Encontrar el jugador más cercano
        UsersGames ganadorUG = null;
        double menorDiferencia = Double.MAX_VALUE;

        for (UsersGames ug : usersGames) {
            double diferencia = Math.abs(ug.getNumeroSeleccionado() - objetivo);
            System.out.println("diferencia: " + diferencia);
            System.out.println("menor diferencia: " + menorDiferencia);

            if (diferencia < menorDiferencia) {
                menorDiferencia = diferencia;
                ganadorUG = ug;
            }

        }

        // 4. Devuelve el usuario ganador
        return (ganadorUG != null) ? ganadorUG.getUser() : null;
    }

    public void penalizaciones(Users ganador,List<UsersGames> usersGames) {
        // Por defecto si no ganas la ronda pierdes 1 vida//
        int penalizaciones = 1;
        if(ganador == null || usersGames.isEmpty()) {

            System.out.println("El usuario o la partida no existe");
        }

        //Capturo los numeros repetidos
        Map<Integer,Integer> numerosRepetidos = new HashMap<>();
        for(UsersGames userGame : usersGames) {

            int numero = userGame.getNumeroSeleccionado();
            numerosRepetidos.put(numero, numerosRepetidos.getOrDefault(numero, 0) + 1);
        }
        for(UsersGames jugador : usersGames) {

            Users user = jugador.getUser();
            //Si el numero elegido por el jugador esta repetido mas de 1 vez
            if(numerosRepetidos.get(jugador.getNumeroSeleccionado()) > 1) {

                penalizaciones = 2;
                jugador.setVidas(jugador.getVidas() - penalizaciones);
                System.out.println(jugador.getVidas()+"tiene estas vidas");
                usersGamesRepository.update(jugador);
                System.out.println(jugador.getVidas()+"tiene estas vidas");
                System.out.println("Jugador " + jugador.getUser().getName() + " repitió número: pierde 2 vidas.");
            }else{

                penalizaciones = 13;
                if(ganador.getId() != jugador.getUser().getId()) {

                    jugador.setVidas(jugador.getVidas() - penalizaciones);
                    System.out.println(jugador.getVidas() + "tiene estas vidas");
                    usersGamesRepository.update(jugador);
                    System.out.println(jugador.getVidas() + "tiene estas vidas");
                    System.out.println("Jugador " + jugador.getUser().getName() + " pierde 1 vida tiene " + jugador.getVidas());
                    System.out.println("las vidas en la linea 139 son : "+jugador.getVidas()+"\n");
                    if (jugador.getVidas() <= 0) {
                        usersGamesRepository.delete(jugador.getId());
                        System.out.println("Jugador eliminado de la partida: " + user.getName());
                    } else {

                        usersGamesRepository.update(jugador);
                        System.out.println("Jugador actualizado: " + user.getName()+" con "+jugador.getVidas()+" vidas\n");
                    }
                }
            }
        }
    }
}


