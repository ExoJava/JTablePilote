/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGraphiques;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author mayer
 */
public class EditeurBoutonTable extends DefaultCellEditor
{
    
    private JButton boutonVirer;
    private final ButtonListener bListener = new ButtonListener();

    /**
     * Constructeur, par défaut 
     * @param checkBox 
     */
    public EditeurBoutonTable(JCheckBox checkBox)
    {
        super(checkBox);
        boutonVirer = new JButton("Virer");
        boutonVirer.setOpaque(true);
        boutonVirer.addActionListener(bListener);
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column)
            
    {
        //On définit le numéro de ligne à notre listener
        bListener.setRow(row);
        //on ne se sert pas du numéro de colonne
        //on transfert le tableau pour pouvoir le modifier
        bListener.setTable(table);
        //on renvoie le bouton
        return boutonVirer;
    }
    
    class ButtonListener implements ActionListener
    {
        private int row;
        private JTable table;
        
        public void setRow(int row){this.row = row;}
        public void setTable(JTable table){this.table = table;}

        @Override
        public void actionPerformed(ActionEvent e)
        {
            //1.récuperer le modele de données de table
            TableModel tm = table.getModel();
            //modifier le booléen
            tm.setValueAt(true, row, 3); //on met la valeur de la colonne 3 à vrai
            
        }
    }
}
