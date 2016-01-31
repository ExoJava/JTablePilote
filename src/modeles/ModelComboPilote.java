/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import dao.ManagerPilote;
import entity.Pilote;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author mayer
 */
public class ModelComboPilote extends AbstractListModel<Pilote> implements ComboBoxModel<Pilote>
{
    private final ArrayList<Pilote> liste;
    private String selection = null;
    
    public ModelComboPilote()
    {
        liste = ManagerPilote.listePilote();
    }
    
    @Override
    public void setSelectedItem(Object anItem)
    {
        selection = (String) anItem; //to select and register an item from the pull-down
        //list
    }
        
    //Méthode implémentée de l'interface ComboBoxModel
    @Override
    public Object getSelectedItem()
    {
        return selection;
    }
    
    @Override
    public int getSize()
    {
        return liste.size();
    }
    
    @Override
    public Pilote getElementAt(int index)
    {
        return liste.get(index);
    }  
}
