package com.juego7th.controller;

import com.juego7th.modelo.Games;
import com.juego7th.service.GamesService;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class GamesController {

    private GamesService gamesService = new GamesService() ;
    //Guardo Partida en base de datos//
    public Games startGame() {
        Timestamp ahora = Timestamp.valueOf(LocalDateTime.now());
        return gamesService.createGame();
    }
}
