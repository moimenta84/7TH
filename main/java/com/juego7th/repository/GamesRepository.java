package com.juego7th.repository;
import com.juego7th.Utils.HibernateUtil;
import com.juego7th.modelo.Games;
import org.hibernate.Session;

public class GamesRepository extends GenericRepository<Games,Integer>{

    public GamesRepository() {
        super(Games.class);
    }



}
