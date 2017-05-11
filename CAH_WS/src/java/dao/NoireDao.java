/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.atoudeft.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Noire;

/**
 *
 * @author soixa
 */
public class NoireDao extends Dao<Noire> {

    public NoireDao(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Noire x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Noire read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Noire x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Noire x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noire> findAll() {
        List<Noire> liste = new ArrayList();
        PreparedStatement stm = null;
        try 
            {
                stm = cnx.prepareStatement("select * from cartes_noires");
                ResultSet r = stm.executeQuery();
                Noire n;
                while (r.next())
                {
                    n = new Noire(r.getInt("ID"),r.getString("Texte"),r.getInt("Piger"));
                    liste.add(n);
                }
                r.close();
                stm.close();
            }
            catch (SQLException exp) {
            }
            return liste;
    }
    
}
