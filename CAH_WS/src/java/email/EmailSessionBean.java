/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.util.Properties;
//import javax.ejb.Stateless;
import protocol.Protocol;

/**
 *
 * @author soixa
 */
//@Stateless
public class EmailSessionBean {

    private int port = 465;
    private String host = "smtp.example.com";
    private String from = "matt@example.com";
    private boolean auth = true;
    private String username = "matt@example.com";
    private String password = "secretpw";
    private Protocol protocol = Protocol.SMTPS;
    private boolean debug = true;
    
    public void sendMail(String to, String subject, String body){
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        switch (protocol) {
            case SMTPS:
                props.put("mail.smtp.ssl.enable", true);
                break;
            case TLS:
                props.put("mail.smtp.starttls.enable", true);
                break;
        }
    }
}
