/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Yann Golhen
 */
public class ComboBox extends JPanel{

    JComboBox menuDeroulant;
    
    /**
     * Constructeur du comboBox
     * @param title titre de la bordure
     * @param list Liste des question sous format string
     */
    public ComboBox(String title, List<String> list) {
        
        menuDeroulant = new JComboBox();
        for (String texte : list)
        {
            menuDeroulant.addItem(texte);
        }
        TitledBorder borderComboBox = new TitledBorder(title);
        this.setBorder(borderComboBox);
        this.add(menuDeroulant);
    }
    
    /**
     * getter du menu deroulant
     * @return une combobox
     */
    public JComboBox getMenuDeroulant() {
        return menuDeroulant;
    }

}
