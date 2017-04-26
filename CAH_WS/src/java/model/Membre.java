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
    
    private int id, score;
    private String username, password, email, uniqueid;

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
    
    public Membre(String username, String password, String email, String uniqueid) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.uniqueid = uniqueid;
    }
    
    public Membre(String username, String password, String email, String uniqueid, int score) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.uniqueid = uniqueid;
        this.score = score;
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
    
    public String getUniqueID() {
        return uniqueid;
    }

    public void setUniqueID(String uid) {
        this.uniqueid = uid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void incrementerScore() {
        this.score++;
    }
    
    @Override
    public String toString() {
        return id+"\n"
                +username;
    }

    
}
