package com.ing.soft.proyecto.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String email;
    public int password;

    public User(String email, int password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
