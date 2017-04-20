/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Cartes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.websocket.Session;

/**
 *
 * @author jcf_1
 */
public class Partie {
    private Joueur[] tabJoueur;
    private Stack stackNoire = new Stack();
    private Stack stackBlanche = new Stack();
    private Stack stackTourJoueur = new Stack();
    private Stack secondStackJoueur = new Stack();
    private ArrayList propositions = new ArrayList();
    private int nbCartesParJoueur;

    
    //Crée une partie avec le nombre de joueur
    public Partie(int nbrJoueur) {
        tabJoueur = new Joueur[nbrJoueur];
        nbCartesParJoueur = 10;
    }
    
    public void setJoueurs(ArrayList liste){
        Iterator itr = liste.iterator();
        int i = 0;
        while (itr.hasNext()){
            Joueur unJoueur = (Joueur)itr.next();
            tabJoueur[i] = unJoueur;
            i++;
        }
    }
    
    public Joueur getJoueur(Session se){
        for (int i=0;i<tabJoueur.length;i++){
            if (tabJoueur[i].getSession() == se)
                return tabJoueur[i];
        }
        return null;
    }
   
    public void melangeCartes(){
        // initialisation des cartes à partir des fichiers .txt
        Cartes.getBlanchesFromTxt();
        Cartes.getNoiresFromTxt();
        // Mix up the white cards
        do{
            int randomCard = (int)(Math.random()* Cartes.listeBlanches.size());
            stackBlanche.add(Cartes.listeBlanches.get(randomCard));
            Cartes.listeBlanches.remove(randomCard);
        }while(!Cartes.listeBlanches.isEmpty());

        // Mix up the black cards
        do{
            int randomCard = (int)(Math.random()* Cartes.listeNoires.size());
            stackNoire.add(Cartes.listeNoires.get(randomCard));
            Cartes.listeNoires.remove(randomCard);
        }while(!Cartes.listeNoires.isEmpty());
    }
    
    public void distribuerCartes(){
        
        if ((tabJoueur.length*10)>stackBlanche.size()){
            nbCartesParJoueur = (int)Math.floor(stackBlanche.size()/tabJoueur.length);
        }
        
        for(int i=0; i<tabJoueur.length;i++){
            for(int j=0; j<nbCartesParJoueur;j++){
                tabJoueur[i].ajouterBlanche((Blanche)stackBlanche.pop());
            }
        }
    }
    public void nextNoire(){
        stackNoire.pop();
    }
    public Noire getCurrentNoire(){
        return (Noire)stackNoire.peek();
    }
    public Blanche getCurrentBlanche(){
        return (Blanche)stackBlanche.peek();
    }
    
    public void pigerCartes(){
        // repige le nombre de cartes nécessaires pour tous les joueurs
        for (int i=0;i<tabJoueur.length;i++){
            if (tabJoueur[i].getSession()!=getCurrentJoueur().getSession()){
                do {
                    tabJoueur[i].ajouterBlanche((Blanche)stackBlanche.pop());
                } while(tabJoueur[i].getNombreBlanches()<nbCartesParJoueur);
            }
        }
    }
    public void ordreInitiate(){
        List shadowListJoueur = new ArrayList();
        for (int i=0;i<tabJoueur.length;i++){
            shadowListJoueur.add(tabJoueur[i]);
        }
        do{
            int randomJoueur = (int)(Math.random()* shadowListJoueur.size());
            stackTourJoueur.add(shadowListJoueur.get(randomJoueur));
            shadowListJoueur.remove(randomJoueur);
        }while(!shadowListJoueur.isEmpty());
    }
    
    public int getNbrPropositions(){
        return propositions.size();
    }
    public void flushPropositions(){
        propositions.clear();
    }
    public Boolean ajouterProposition(Proposition pr){
        return propositions.add(pr);
    }
    public Proposition getProposition(int i){
        return (Proposition)propositions.get(i);
    }
    public boolean nextJoueur(){
        secondStackJoueur.push(stackTourJoueur.pop());
        if (stackTourJoueur.empty())
            return false;
        return true;
    }
    public void reinitBeginningStack(){
        while(!secondStackJoueur.empty()){
            stackTourJoueur.push(secondStackJoueur.pop());
        }
    }
    public Joueur getCurrentJoueur(){
        /*for (int i=0;i<tabJoueur.length;i++){
            if (((Joueur)stackTourJoueur.peek()).getProvenance()==tabJoueur[i].getProvenance()) return tabJoueur[i];
        }*/
        //Peut-etre juste retourné le nom du joueur au lieu de l'objet joueur??
        return (Joueur)stackTourJoueur.peek();
    }
    
    public ArrayList getPropositions(){
        return propositions;
    }
    
}
