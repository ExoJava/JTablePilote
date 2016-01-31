
package entity;

/**
 *
 * @author mayer
 */
public class Pilote {
    
   private int id;
   private String nom;
   private String prenom;
   private boolean vire;

    public Pilote(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isVire()
    {
        return vire;
    }

    
    public void setVire(boolean vire)
    {
        this.vire = vire;
    }
    
    @Override
    public String toString() {
        return "Pilote{" + "nom=" + nom + ", prenom=" + prenom + '}';
    }
    
}
