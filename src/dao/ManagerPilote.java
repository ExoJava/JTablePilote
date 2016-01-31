
package dao;

import entity.Pilote;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import outils.Connexion;

/**
 *
 * @author mayer
 */
public class ManagerPilote {
    /**
     * Constructeur en privé pour interdire l'instanciation
     */
    private ManagerPilote() {}
    
    /**
     * Cette fonction donne la liste des pilotes de la table PILOTE
     * @return Cette fonction retourne un ArrayList contenant tous les pilotes
     */
    public static ArrayList<Pilote> listePilote()
    {
        try
        {
            Statement st = Connexion.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PILOTE ORDER BY IdPilote");
            ArrayList<Pilote> liste = new ArrayList();
            while (rs.next())
            {
                liste.add(new Pilote(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return liste;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    
    public static ArrayList<String> listePrenom()
    {
        try
        {
            Statement st = Connexion.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT Prenom FROM PILOTE ORDER BY IdPilote");
            ArrayList<String> listePrenom = new ArrayList<>();
            while(rs.next())
            {
                listePrenom.add(rs.getString(1));
            }
            return listePrenom;
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<String> listeColonnesPilotes()
    {
        try
        {
            Statement st = Connexion.getInstance().getConn().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PILOTE");
            ArrayList<String> liste = new ArrayList<>();
            ResultSetMetaData md = rs.getMetaData();
            int i = 1;
            while(i <= md.getColumnCount())
            {
                liste.add(md.getColumnName(i));
                i++;
            }
            return liste;
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
