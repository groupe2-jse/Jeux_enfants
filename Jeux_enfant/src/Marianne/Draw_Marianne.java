/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Draw_Marianne extends JPanel{
    
   // JPanel option ; // declaration d'objet
    Display_drawing leDessin ; 
    Bouton color, delete, choicePen ; 
    JPanel menu  ; 
    //Draw_Marianne tableau = new Draw_Marianne(); 
    
    
     
    public Draw_Marianne()
    {
        this.setName("Dessin"); // constructeur signé
       // JPanel option = new JPanel(); // je cree un objet MenuPanel
        this.initDraw(); 
    }
    
   public void initDraw()
   {
        leDessin = new Display_drawing(); 
        color = new Bouton("Couleur") ; 
        delete = new Bouton("Effacer") ; 
        delete.addActionListener(new listenerSuppr()); 
        choicePen = new Bouton("Forme du crayon") ; 
        menu = new JPanel(); 
        menu.setLayout(new BorderLayout());
        menu.add(color, BorderLayout.NORTH) ; 
        menu.add(delete, BorderLayout.SOUTH) ; 
        
        
        menu.add(choicePen, BorderLayout.CENTER); 
        this.setLayout(new BorderLayout()); // j'identifie les futurs emplacements
        this.add(menu,BorderLayout.WEST ) ; // j'ajoute  le MenuPanel
        this.add(leDessin, BorderLayout.CENTER) ; 
   }
   
    public class listenerSuppr implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("ok");
            initDraw();
         
    }
    
}
}

