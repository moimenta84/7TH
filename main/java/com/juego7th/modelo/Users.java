package com.juego7th.modelo;
import com.juego7th.modelo.UsersGames;
import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @SuppressWarnings("JpaAttributeTypeInspection")
    private Set<UsersGames> partidas = new HashSet<>();


    public Users() {}

    public Users(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    // Getters y setters

    public int getId() {

        return id;
    }

    public String getName() {

        return name;

    }
    public void setName(String name) {

        this.name = name;

    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String getPassword() {
        return password;

    }
    public void setPassword(String password) {

        this.password = password;
    }
}
