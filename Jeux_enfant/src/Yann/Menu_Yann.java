/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Yann Golhen
 */
public class Menu_Yann extends JMenuBar{
    
    JMenu menu, activite, niveau;
    JMenuItem draw, calcul, question, niveau1, niveau2, administration;
    
       public Menu_Yann(){  
          
        //Menus et items de premier niveau
        activite = new JMenu("Activité");
        niveau = new JMenu("Niveau");
        administration = new JMenuItem("Administration");
        
        //Second niveau Activités
        draw = new JMenuItem("Dessin");
        calcul = new JMenuItem("Calcul");
        question = new JMenuItem("Questions");
        
        //Second niveau Niveau
        niveau1 = new JMenuItem("Niveau 1");
        niveau2 = new JMenuItem("Niveau 2");
        
        //Integrations
        activite.add(draw);
        activite.add(calcul);
        activite.add(question);
        
        niveau.add(niveau1);
        niveau.add(niveau2);
        
        this.add(activite);
        this.add(niveau);
        this.add(administration);
        
                
        }
}
