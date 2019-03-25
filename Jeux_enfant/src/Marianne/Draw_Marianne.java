/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.BorderLayout;
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
        draw = new JPanel (); 
        menu = new JMenu (); 
        delete = new Button() ; 
        color = new Button() ; 
        choicePen = new Button() ; 
        
        initDraw(); 
        
        //this.pack(); // pour avoir une taille auto
        this.setResizable(true);// la taille est gelee
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // le programme ferme a la fermeture de l'IG
        this.setVisible(true);// Formulaire visible
        
      
    }
    
   private void initDraw()
   {
       draw.setLayout(new BorderLayout()) ;
   }
    
    

  
    
    

}
