
import com.atoudeft.jdbc.Connexion;
import dao.MembreDao;
import model.Membre;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author soixa
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MembreDao mdao = new MembreDao(Connexion.getInstance());
        Membre m = mdao.read("Dodo");
        System.out.println(m.toString());
    }
    
}
