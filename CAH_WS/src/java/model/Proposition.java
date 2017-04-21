/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import javax.websocket.Session;

/**
 *
 * @author soixa
 */
public class Proposition {
    
    private Session session;
    private ArrayList blanches = new ArrayList();

    public Proposition(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public ArrayList getBlanches() {
        return blanches;
    }

    public void setBlanches(ArrayList blanches) {
        this.blanches = blanches;
    }
    
    public Boolean ajouterBlanche(Blanche bl){
        return this.blanches.add(bl);
    }
    
    public String toString(){
        Iterator itr = this.blanches.iterator();
        String str = "";
        while(itr.hasNext()){
            str+=((Blanche)itr.next()).getTexte()+"\n";
        }
        return str;
    }
    
}
