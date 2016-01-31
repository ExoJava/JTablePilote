/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import dao.ManagerAvion;
import entity.Avion;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mayer
 */
public class ModelTableAvion extends AbstractTableModel
{
    ArrayList<Avion> liste = ManagerAvion.listeAvion();
    ArrayList<String> listeColonne = ManagerAvion.ListeColonnesAvions();

    @Override
    public int getRowCount()
    {
        return liste.size();
    }

    @Override
    public int getColumnCount()
    {
        return listeColonne.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        switch(columnIndex)
        {
            case 0 : return liste.get(rowIndex).getId();
            case 1 : return liste.get(rowIndex).getType();
            case 2 : return liste.get(rowIndex).getBaseAero();
            default : return liste.get(rowIndex).isVendu();
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex > 2;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
     
        Class clas = String.class;
        if(columnIndex == 3)
        {
            clas = Boolean.class;
        }
        return clas;
    }
    
    @Override
    public String getColumnName(int column)
    {
        return listeColonne.get(column);
    }
    
    public void addColumn(String nomCol)
    {
        listeColonne.add(nomCol);
    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        if (aValue instanceof Boolean && columnIndex == 3)
            {
            //Récupère un pilote dans la JTable
            Avion av = liste.get(rowIndex);
            // Met à jour le modèle de données
            av.setVendu((Boolean) aValue);
            //Prévient tout le monde du changement
            fireTableCellUpdated(rowIndex, columnIndex);
            }
    }
    
}
