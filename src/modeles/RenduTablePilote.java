/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import dao.ManagerPilote;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mayer
 */
public class RenduTablePilote implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
    {
        Component compo;
        
        switch (column)
        {
            case 2://colonne des prenoms
                compo = new JComboBox();
                /*compo.setSize(30, 20);
                compo.setPreferredSize(new Dimension(30,20));*/
                ArrayList<String> lp = ManagerPilote.listePrenom();
                //ici on pourrait passer directement par une boucle sur
                // listeColonnesPilotes(), qui contient tous les prénoms
                for(String prenom : lp)
                {
                    ((JComboBox) compo).addItem(prenom);
                }   //sélection du pilote concerné
                ((JComboBox<String>) compo).setSelectedItem(value);
                table.getColumn("Prenom").setCellEditor(new DefaultCellEditor((JComboBox) compo));
                break;
            case 4: //colonne des boutons Virer
                if (table.getModel().getValueAt(row, 3) == Boolean.TRUE)
                { //si le check box est 
                    String texte;
                    texte = value.toString();
                    compo = new JLabel(texte);
                    ((JLabel) compo).setOpaque(true);
                    if(((row + column) % 2) == 0)
                    {
                        compo.setBackground(Color.LIGHT_GRAY);
                    }
                    else
                    {
                        compo.setBackground(Color.cyan);
                    }
                }
                    
                else compo = new JButton("Virer");
                
                break;
            default:
                compo = new JLabel(value.toString());
                ((JLabel)compo).setOpaque(true);
                if((row + column) % 2 == 0)
                {
                    compo.setBackground(Color.lightGray);
                }
                else
                {
                    compo.setBackground(Color.cyan);
                }   break;
        }
        return compo;
    }
}
