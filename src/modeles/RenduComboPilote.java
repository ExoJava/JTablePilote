/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import entity.Pilote;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author mayer
 */
public class RenduComboPilote implements ListCellRenderer<Pilote> {
    
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Pilote> list, Pilote value, int index, boolean isSelected, boolean cellHasFocus) {
        if ( value != null)
        {    
            JLabel lab = new JLabel( value.getNom()+" "+value.getPrenom());
            lab.setOpaque(true);
        if ( index % 2 == 0)
            lab.setBackground(Color.MAGENTA);
        else
            lab.setBackground(Color.YELLOW);
        return lab;
        }
        else
            return new JLabel("");
    }
    
    
}
