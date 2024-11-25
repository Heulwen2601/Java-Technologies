package org.example.lab05.Models;

import jakarta.persistence.*;
@Entity
@Table(name="users")

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email;
    }
}
