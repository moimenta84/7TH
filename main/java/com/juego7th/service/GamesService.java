
package com.juego7th.service;
import com.juego7th.modelo.Games;
import com.juego7th.repository.GamesRepository;
import org.hibernate.HibernateException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class GamesService {

    private final GamesRepository gamesRepository = new GamesRepository();

    public Games createGame() {
        try {
                Games newGame = new Games();
                Timestamp fecha = new Timestamp(System.currentTimeMillis());
                newGame.setFecha(fecha);
                newGame.setStart(true);
                gamesRepository.create(newGame);
                return newGame;

        } catch (HibernateException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Games getGameById(int id) {
        try {
            return gamesRepository.getfindById(id);
        } catch (HibernateException e) {
            return null;
        }
    }

    public String updateGame(int id,Timestamp fecha) {
        try {


            Games game = gamesRepository.getfindById(id);
            if (game == null) return "Error: Game not found";
            game.setFecha(fecha);
            gamesRepository.update(game);
            return "Game updated successfully! ID: " + game.getId();
        } catch (HibernateException e) {
            return "Database error: Could not update game";
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }

    public String deleteGame(int id) {
        try {
            Games game = gamesRepository.getfindById(id);
            if (game == null) return "Error: Game not found";

            gamesRepository.delete(id);
            return "Game deleted successfully! ID: " + id;
        } catch (HibernateException e) {
            return "Database error: Could not delete game";
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }

    public String getAllGames() {
        StringBuilder result = new StringBuilder();
        try {
            List<Games> games = gamesRepository.findAll();
            if (games.isEmpty()) return "No games found";

            for (Games game : games) {
                result.append("\n")
                        .append("ID: ").append(game.getId()).append("\n")
                        .append("FECHA: ").append(game.getId()).append("\n");
            }
        } catch (HibernateException e) {
            return "Database error: Could not retrieve games";
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
        return result.toString();
    }
}
