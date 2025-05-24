package com.juego7th.modelo;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "users_games")
public class UsersGames implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "id_partida")
    private Games game;

    private int idGanador;

    @Column(name = "numero_seleccionado")
    private int numeroSeleccionado;
    @Column(name = "vidas")
    private int vidas = 7;

    public UsersGames(int id, Games game, Users user, int idGanador,int numeroSeleccionado,int vidas) {
        this.id = id;
        this.game = game;
        this.user = user;
        this.idGanador = idGanador;
        this.numeroSeleccionado = numeroSeleccionado;
        this.vidas = vidas;
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

    public
    int getNumeroSeleccionado() {
        return numeroSeleccionado;
    }

    public
    void setNumeroSeleccionado(int numeroSeleccionado) {
        this.numeroSeleccionado = numeroSeleccionado;
    }

    public
    int getVidas() {
        return vidas;
    }

    public
    void setVidas(int vidas) {
        this.vidas = vidas;
    }
}
