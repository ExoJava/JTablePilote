/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import dao.ManagerPilote;
import entity.Pilote;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mayer
 */
public class ModelTablePilote extends AbstractTableModel
{
    ArrayList<Pilote> liste = ManagerPilote.listePilote();
    ArrayList<String> listeColonne = ManagerPilote.listeColonnesPilotes();
    //listeColonne.add("Viré");
    
    @Override
    public int getRowCount() {
        return liste.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return listeColonne.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: return liste.get(rowIndex).getId();
            case 1: return liste.get(rowIndex).getNom();
            case 2 : return liste.get(rowIndex).getPrenom();
            default: return liste.get(rowIndex).isVire();
        }
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        
        if (aValue instanceof Boolean && columnIndex == 3)
        {
        //Récupère un pilote dans la JTable
        Pilote pil = liste.get(rowIndex);
        // Met à jour le modèle de données
        pil.setVire((Boolean) aValue);
        //Prévient tout le monde du changement
        fireTableCellUpdated(rowIndex, columnIndex);
        fireTableCellUpdated(rowIndex, 4); // on met à jour la colonne des boutons
        }
        else if (aValue instanceof String && columnIndex == 2)
        {
            Pilote pil = liste.get(rowIndex);
            pil.setPrenom((String) aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
        else if(columnIndex == 4)
        {
            Pilote pil = liste.get(rowIndex);
            pil.setVire((Boolean) aValue);
            
            fireTableCellUpdated(rowIndex, columnIndex);
            
        }
    }
    
    
    @Override
    public String getColumnName(int column) {
        return listeColonne.get(column); 
    }
    
    public void addColumn(String colName)
    {
        listeColonne.add(colName);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return columnIndex == 2 || columnIndex == 3 || columnIndex == 5 ||
                (columnIndex == 4 && getValueAt(rowIndex, 3) == Boolean.FALSE);
        // les 4 dernières colonnes sont éditables, et seulement les boutons de la 
        // 4
        
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
    
    
    
    
}
