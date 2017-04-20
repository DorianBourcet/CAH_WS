/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.atoudeft.jdbc.Connexion;
import java.util.ArrayList;
import model.Partie;

/**
 *
 * @author soixa
 */
public class ServerSupport {
    public static ArrayList joueurs = new ArrayList();
    public static ArrayList joueurStart = new ArrayList();
    public static boolean partieCommencer = false;
    public static Partie partie;
    public static MembreDao mdao = new MembreDao(Connexion.getInstance());
}
