/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import javax.swing.JFrame;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in Templates/Classes/Main.java.
 */
public class MainMarianne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // creation Jframe
        JFrame  dessinTest = new JFrame("Dessin"); 
        // creation de lobket draw_marianne
        Draw_Marianne contenu = new Draw_Marianne(); 
        
        dessinTest.add(contenu) ; 
        
        // Ajout de mon contenu à la fenêtre
        dessinTest.setContentPane(contenu); 
        // Fermeture
        dessinTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Fenêtre non-redimensionnable
     // this.setResizable(false); 
        // Ajustement de la taille au contenu
        dessinTest.pack(); 
        // On positionne la fenêtre au milieu de l'écran
        dessinTest.setLocationRelativeTo(null);
        // Affichage de la fenêtre
        dessinTest.setVisible(true); 
        
       
        
        
    }
    

}
