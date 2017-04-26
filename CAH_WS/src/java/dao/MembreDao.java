/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
/**
 *
 * @author Ali
 */


import com.atoudeft.jdbc.dao.Dao;
import java.io.UnsupportedEncodingException;
import model.Membre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class MembreDao extends Dao<Membre> {
    
    public MembreDao(Connection c) {
        super(c);
    }

    @Override
    public boolean create(Membre m) {
        String req = "INSERT INTO membres (`pseudonyme`, `mot_de_passe`, `email`)"
                + "VALUES ('"+m.getUsername()+"', '"+m.getPassword()+"','"
                +m.getEmail()+"')";

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
                    System.out.println(e.toString());
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public Membre read(String usr) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM membres WHERE pseudonyme = ?");
            stm.setString(1,usr);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Membre m = new Membre();
                m.setId(r.getInt("ID"));  
                m.setUsername(r.getString("pseudonyme")); 
                //System.out.println(r.getString("pseudonyme"));
                m.setPassword(r.getString("mot_de_passe"));
                m.setScore(r.getInt("score"));
                r.close();
                stm.close();
                //System.out.println(m.toString());
                return m;
            }
        } catch (SQLException exp) {
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
        return null;
    }
    
    public Membre readByMail(String mail) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM membres WHERE email = ?");
            stm.setString(1,mail);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Membre m = new Membre();
                m.setId(r.getInt("ID"));  
                m.setUsername(r.getString("pseudonyme")); 
                m.setPassword(r.getString("mot_de_passe"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
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
        return null;
    }
    
    public Membre readByAlias(String alias) {
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM membres WHERE pseudonyme = ?");
            stm.setString(1,alias);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Membre m = new Membre();
                m.setId(r.getInt("ID"));  
                m.setUsername(r.getString("pseudonyme")); 
                m.setScore(r.getInt("score"));
                r.close();
                stm.close();
                return m;
            }
        } catch (SQLException exp) {
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
        return null;
    }
    
    public boolean updateUniqueID(Membre m) {
     Statement stm = null;
        try {
            String req = "UPDATE membres SET "
                +"uniqueID = '"+m.getUniqueID()+"'" 
                +" WHERE ID = '"+m.getId()+"'";
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
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
    
    public boolean updatePassword(Membre m) {
     Statement stm = null;
        try {
            String req = "UPDATE membres SET "
                +"mot_de_passe = '"+m.getPassword()+"'" 
                +" WHERE uniqueID = '"+m.getUniqueID()+"'";
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
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
    
    public boolean updateScore(Membre m) {
     Statement stm = null;
        try {
            String req = "UPDATE membres SET "
                +"score = '"+m.getScore()+"'" 
                +" WHERE ID = '"+m.getId()+"'";
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
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
    
    public List<Membre> findHighScores() {
        List<Membre> liste = new LinkedList<>();
        PreparedStatement stm = null;
        try 
            {
                stm = cnx.prepareStatement("select * from membre "
                        + "Order by 6 desc LIMIT 0, 10");
                ResultSet r = stm.executeQuery();
                while (r.next())
                {
                    Membre m = new Membre();
                    m.setUsername(r.getString("pseudonyme"));
                    m.setScore(r.getInt("score"));
                    liste.add(m);
                }
                r.close();
                stm.close();
            }
            catch (SQLException exp) {
            }
            return liste;
    }

    @Override
    public boolean update(Membre x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Membre x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Membre> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Membre find(int id) {
        String strId = Integer.toString(id);
        PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM membre WHERE id = ?");
            stm.setString(1,strId);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                
            }
        } catch (SQLException exp) {
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
        return null;
    }
    
    
    
    
    
    
    
    
    
}
