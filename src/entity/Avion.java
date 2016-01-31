/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author mayer
 */
public class Avion
{
    private int id;
    private String type;
    private String baseAero;
    private boolean vendu;

    public Avion(int id, String type, String baseAero)
    {
        this.id = id;
        this.type = type;
        this.baseAero = baseAero;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getBaseAero()
    {
        return baseAero;
    }

    public void setBaseAero(String baseAero)
    {
        this.baseAero = baseAero;
    }

    @Override
    public String toString()
    {
        return "Avion{" + "type=" + type + ", baseAero=" + baseAero + '}';
    }

    public boolean isVendu()
    {
        return vendu;
    }

    public void setVendu(boolean vendu)
    {
        this.vendu = vendu;
    }
    
    
    
}
