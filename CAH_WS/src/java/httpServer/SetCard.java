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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blanche;
import model.Noire;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author jcf_1
 */
public class SetCard extends HttpServlet {

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
                if (request.getParameter("type").equals("NOIRE")){
                    NoireDao cdao = new NoireDao(Connexion.getInstance());
                    Noire c = new Noire(request.getParameter("texte").replaceAll("'","\\\\'"),Integer.parseInt(request.getParameter("piger")));
                    System.out.println(c);
                    cdao.create(c);
                    response.getWriter().write("creation de la carte noir fini");
                }
                else if (request.getParameter("type").equals("BLANCHE")){
                    BlancheDao cdao = new BlancheDao(Connexion.getInstance());
                    Blanche c = new Blanche(request.getParameter("texte").replaceAll("'","\\\\'"));
                    cdao.create(c);
                    response.getWriter().write("creation de la carte blanche fini");
                }
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
