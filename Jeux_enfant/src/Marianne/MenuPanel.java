/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class MenuPanel extends JPanel {

    Bouton color, delete, choicePen ; // declaration des objets bouton
    
    public MenuPanel() {
        
        // definition
        color = new Bouton("Couleur") ; 
        delete = new Bouton("Effacer") ; 
        choicePen = new Bouton("Forme_du_crayon") ; 
        
        this.initMenu() ;   
    }
    
    private void initMenu(){
        
        this.setLayout(new BorderLayout());
        this.add(color, BorderLayout.NORTH) ; 
        this.add(delete, BorderLayout.SOUTH) ; 
        this.add(choicePen, BorderLayout.CENTER); 
        
    }
    

}
