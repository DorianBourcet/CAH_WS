/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author soixa
 */
public class Blanche implements Serializable {
    private String texte;
    private int id;

    public Blanche(String texte){
        this.texte = texte;
    }
    
    public Blanche(int id,String texte){
        this.id = id;
        this.texte = texte;
    }
    
    public Blanche() {
        this("");
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
