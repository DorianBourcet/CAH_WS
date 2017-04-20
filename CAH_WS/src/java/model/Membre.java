/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dbourcet
 */
public class Membre {
    
    private int id;
    private String username, password, email;

    public Membre() {
    }

    public Membre(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Membre(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Membre(int id) {
        this.id = id;
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
        return id+"\n"
                +username;
    }

    
}
