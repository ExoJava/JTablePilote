/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Avion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import outils.Connexion;

/**
 *
 * @author mayer
 */
public class ManagerAvion
{
    
    private ManagerAvion() {}
    
    public static ArrayList<Avion> listeAvion()
    {
        try
        {
            Statement st = Connexion.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM AVION");
            ArrayList<Avion> liste = new ArrayList();
            
            while(rs.next())
            {
                liste.add(new Avion(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return liste;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public static ArrayList<String> ListeColonnesAvions()
    {
        try
        {
            Statement st = Connexion.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM AVION");
            ArrayList<String> liste = new ArrayList<>();
            ResultSetMetaData md = rs.getMetaData();
            int i = 1;
            while(i <= md.getColumnCount())
            {
                liste.add(md.getColumnName(i));
                i++;
            }
            return liste;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
}
