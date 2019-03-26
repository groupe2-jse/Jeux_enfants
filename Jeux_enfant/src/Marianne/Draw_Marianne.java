/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Draw_Marianne extends JPanel{
    
    MenuPanel option; // declaration d'objet
   
    public Draw_Marianne()
    {
        this.setName("DESSIN"); // constructeur signé
        option = new MenuPanel(); // je cree un objet MenuPanel
        this.initDraw(); 
    }
    
   public void initDraw()
   {
        this.setLayout(new BorderLayout()); // j'identifie les futurs emplacements
        this.add(option,BorderLayout.WEST ) ; // j'ajoute  le MenuPanel
   }
    
    

  
    
    

}

