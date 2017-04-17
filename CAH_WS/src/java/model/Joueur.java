/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.Session;



/**
 *
 * @author soixa
 */
public class Joueur implements Serializable {
    
    private String alias;
    private Session session;
    private int score = 0;
    private ArrayList<Blanche> blanches = new ArrayList<Blanche>();

    public Joueur(Session session){
        this.session = session;
    }

    public Joueur(String alias, Session session) {
        this.alias = alias;
        this.session = session;
    }

    public Joueur() {
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Blanche> getBlanches() {
        return blanches;
    }

    public void setBlanches(ArrayList<Blanche> blanches) {
        this.blanches = blanches;
    }
    
    public void ajouterBlanche(Blanche bl){
        blanches.add(bl);
    }
    
    public Boolean deleteBlanche(Blanche bl){
        return this.blanches.remove(bl);
    }
    
    public void deleteBlanche(int index){
        this.blanches.remove(index);
    }
    
    public int getNombreBlanches(){
        return this.blanches.size();
    }
    
    public int incrementerScore(){
        return ++score;
    }
    
    public String toString(){
        return this.alias+" : "+this.score;
    }
}
