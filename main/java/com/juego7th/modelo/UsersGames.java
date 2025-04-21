package com.juego7th.modelo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users_games")
public class UsersGames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_partida")
    private Games game;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    private int idGanador;


    public UsersGames(int id, Games game, Users user, int idGanador) {
        this.id = id;
        this.game = game;
        this.user = user;
        this.idGanador = idGanador;
    }

    public UsersGames() {
    }

    public
    int getId() {
        return id;
    }

    public
    void setId(int id) {
        this.id = id;
    }

    public
    Games getGame() {
        return game;
    }

    public
    void setGame(Games game) {
        this.game = game;
    }

    public
    Users getUser() {
        return user;
    }

    public
    void setUser(Users user) {
        this.user = user;
    }

    public
    int getIdGanador() {
        return idGanador;
    }

    public
    void setIdGanador(int idGanador) {
        this.idGanador = idGanador;
    }
}
