package com.juego7th.modelo;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
public class Games implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    Timestamp date;
    boolean start;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private Set<UsersGames> jugadores = new HashSet<>();

    public Games(Timestamp  fecha, boolean start) {

        this.date = fecha;
        this.start = start;
    }

    public Games() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp  getFecha() {
        return date;
    }

    public void setFecha(Timestamp  date) {
        this.date= date;
    }

    public
    void setDate(Timestamp date) {
        this.date = date;
    }

    public
    void setStart(boolean start) {
        this.start = start;
    }

    public
    void setJugadores(Set<UsersGames> jugadores) {
        this.jugadores = jugadores;
    }

    public boolean isStart() {
        return start;
    }

    public
    Set<UsersGames> getJugadores() {
        return jugadores;
    }

    public
    Timestamp  getDate() {
        return date;
    }
}
