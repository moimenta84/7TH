package com.juego7th.repository;

import com.juego7th.modelo.Games;

public class GamesRepository extends GenericRepository<Games,Integer>{

    public GamesRepository() {
        super(Games.class);
    }
}
