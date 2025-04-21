package com.juego7th.modelo;
import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "pasword", nullable = false, length = 100) // cuidado con el nombre real en BD
    private String password;

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

    @Override
    public
    String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
