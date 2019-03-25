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
    
    JPanel panel, menu; // declaration objet
    Bouton color, delete, choicePen ; 
    boolean b = true ; 
   
    public Draw_Marianne()
    {
        
        //this.setTitle("Dessin"); // titre de Jpanel
        
        panel = new JPanel() ; // def panel principal
        menu = new JPanel(); 
         color = new Bouton("Couleur") ; 
         delete = new Bouton("Effacer") ; 
         choicePen = new Bouton("Forme_du_crayon") ; 
         panel.setLayout(new BorderLayout());
         menu.setLayout(new BorderLayout());
         menu.add(color, BorderLayout.NORTH) ; 
         menu.add(delete, BorderLayout.SOUTH) ; 
         menu.add(choicePen, BorderLayout.CENTER); 
         panel.add(menu,BorderLayout.WEST ) ; 
        
         
         
         this.initDraw(); 
         
       
        
    }
    
   private void initDraw()
   {
      
         this.add(new DrawingPanel()); 
     
   }
    
    

  
    
    

}
