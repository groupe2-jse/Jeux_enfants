/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.Button;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Draw_Marianne extends JFrame{
    
    Button delete, color, choicePen ; 
    JPanel draw ; 
    JMenu menu ; 
   

    
    public Draw_Marianne()
    {
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
        this.setResizable(false); // Fenêtre non-redimensionnable
        //this.pack(); // Ajustement de la taille au contenu
        // On positionne la fenêtre au milieu de l'écran
       // this.setLocationRelativeTo(null);
        this.setVisible(true); // Affichage de la fenêtre
        
      
    }
    
//   private void initDraw()
//   {
//       this.add(draw); 
//       this.add(menu); 
//       this.add(color); 
//       this.add(choicePen); 
//       this.add(delete); 
//   }
//    
    

  
    
    

}
