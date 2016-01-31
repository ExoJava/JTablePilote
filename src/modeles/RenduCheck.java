/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mayer
 */
public class RenduCheck extends JCheckBox implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object check, boolean isSelected, boolean hasFocus, int row, int column)
    {
        setHorizontalAlignment(JCheckBox.CENTER);
        //affiche le bouton activé
        this.setSelected((Boolean) check);
        setOpaque(true);
        if((row+column)%2 ==0)
        {
            setBackground(Color.LIGHT_GRAY);
        }
        else
        {
            setBackground(Color.CYAN);
        }
        return this;
    }
    
}
