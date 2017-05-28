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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Blanche;

/**
 *
 * @author soixa
 */
public class BlancheDao extends Dao<Blanche> {

    public BlancheDao(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Blanche x) {
        String req = "INSERT INTO cartes_blanches (`Texte`)"
                + "VALUES ('"
                +x.getTexte()+"')";
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } 
        catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public Blanche read(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Blanche x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Blanche x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean delete(int id) {
        Statement stm = null;
	try 
	{
		stm = cnx.createStatement(); 
		int n= stm.executeUpdate("DELETE FROM cartes_blanches WHERE ID='"+id+"'");
		if (n>0)
		{
			stm.close();
			return true;
		}
	}
	catch (SQLException exp)
	{
	}
	finally
	{
		if (stm!=null)
		try {
			stm.close();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	return false;
    }

    @Override
    public List<Blanche> findAll() {
        List<Blanche> liste = new ArrayList();
        PreparedStatement stm = null;
        try 
            {
                stm = cnx.prepareStatement("select * from cartes_blanches");
                ResultSet r = stm.executeQuery();
                while (r.next())
                {
                    Blanche b = new Blanche(r.getInt("ID"),r.getString("Texte"));
                    liste.add(b);
                }
                r.close();
                stm.close();
            }
            catch (SQLException exp) {
            }
            return liste;
    }
    
}
