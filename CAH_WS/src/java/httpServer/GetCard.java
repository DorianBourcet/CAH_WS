/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package httpServer;

import com.atoudeft.jdbc.Connexion;
import dao.BlancheDao;
import dao.NoireDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blanche;
import model.Noire;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author jcf_1
 */
@WebServlet(name = "CardServlet", urlPatterns = {"/CardServlet"})
public class GetCard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR! Driver not found");
        }
        Connexion.setUrl("jdbc:mysql://localhost/cardsagainsthumanity");
        Connexion.setUser("root");
        Connexion.setPassword("root");
        ArrayList cards;
        Iterator itra;
        JSONArray list = new JSONArray();
        if (request.getParameter("type").equals("BLANCHES")){
            BlancheDao bdao = new BlancheDao(Connexion.getInstance());
            cards = (ArrayList) bdao.findAll();
            itra = cards.iterator();
            Blanche b;
            while(itra.hasNext()){
                JSONObject obj = new JSONObject();
                b = (Blanche) itra.next();
                obj.put("id",b.getId());
                obj.put("texte",b.getTexte());
                list.add(obj);
            }
        } else if (request.getParameter("type").equals("NOIRES")){
            NoireDao ndao = new NoireDao(Connexion.getInstance());
            cards = (ArrayList) ndao.findAll();
            System.out.println("Taille du tableau "+cards.size());
            itra = cards.iterator();
            Noire n;
            while(itra.hasNext()){
                n = (Noire) itra.next();
                System.out.println(n.getTexte());
                JSONObject obj = new JSONObject();
                obj.put("id",n.getId());
                obj.put("texte",n.getTexte());
                obj.put("piger",n.getPiger());
                list.add(obj);
            }
        }
        System.out.println(list.toJSONString());
        response.getWriter().write(list.toJSONString());
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
