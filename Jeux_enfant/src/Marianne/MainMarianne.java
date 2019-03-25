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
        
        JFrame  dessinTest = new JFrame("Dessin"); 
        dessinTest.add(new Draw_Marianne()) ; 
         // Initialisation de la fenêtre
        dessinTest.setContentPane(new Draw_Marianne()); // Ajout de mon contenu à la fenêtre
        dessinTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture
       // this.setResizable(false); // Fenêtre non-redimensionnable
        dessinTest.pack(); // Ajustement de la taille au contenu
        // On positionne la fenêtre au milieu de l'écran
        dessinTest.setLocationRelativeTo(null);
        dessinTest.setVisible(true); // Affichage de la fenêtre
        
       
        
        
    }
    

}
