
import com.atoudeft.jdbc.Connexion;
import dao.MembreDao;
import email.EmailSessionBean;
import java.util.UUID;
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
        //MembreDao mdao = new MembreDao(Connexion.getInstance());
        //Membre m = mdao.read("Jycy");
        //System.out.println(m.toString());
        EmailSessionBean eb = new EmailSessionBean();
        eb.sendMail("soixante6dollars@gmail.com","Cards Against Humanity - Réinitialisation",
                            "Hey Dorian"
                            +" !\nOn nous a dit que tu avais oublié ton mot de passe pour jouer à Cards Against Humanity !"
                            + "\nClique ici pour le réinitialiser : http://localhost:8080/CAH_WS/newpassword.html"
                            + "\nEntre le code : "
                            +UUID.randomUUID());
        //eb.sendMail("soixante6dollars@gmail.com","If you read this...","It works my dude!! :))");
    }
    
}
