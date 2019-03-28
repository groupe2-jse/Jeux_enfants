/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marianne;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class Draw_Marianne extends JPanel {

    // JPanel option ; // declaration d'objet
    Display_drawing leDessin;
    Bouton color, delete, choicePen;
    JPanel menu;
    JPanel choiceColor;
    Graphics g;
    Bouton jb ; 
    //Draw_Marianne tableau = new Draw_Marianne(); 

    public Draw_Marianne() {
        this.setName("Dessin"); // constructeur signé
        // JPanel option = new JPanel(); // je cree un objet MenuPanel
        this.initDraw();
    }

    public void initDraw() {
        this.removeAll();
        leDessin = new Display_drawing();
        choiceColor = new JPanel();
        choiceColor.setLayout(new GridLayout(0, 2));
        color = new Bouton("Couleur");
        delete = new Bouton("Effacer");
        
        delete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                initDraw();
            }
        });
        
        choicePen = new Bouton("Forme du crayon");
        menu = new JPanel();
        menu.setLayout(new BorderLayout());
        //menu.add(color, BorderLayout.NORTH) ; 
        menu.add(choiceColor, BorderLayout.NORTH);
        String[] differentColor = {
            "bleu", "rouge", "jaune",
            "gris", "noir", "rose",
            "violet", "vert"

        };

        for (String s : differentColor) {
            jb = new Bouton(s);
            choiceColor.add(jb);
            
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // lance la fonction sur chaque bouton 
                    // getSouce = le bouton sur lequel on clique
                    // getTexte = renvoie titre string[]
                    leDessin.initColor(leDessin.getG(),((Bouton)e.getSource()).getText());
                    
                }
            });
            //actionListener
//            if (s.equals("bleu")) {
//                jb.addActionListener(new listenerBleu());
//            }
//
//            if (s.equals("rouge")) {
//                jb.addActionListener(new listenerRouge());
//            }

        }

        menu.add(delete, BorderLayout.SOUTH);

        menu.add(choicePen, BorderLayout.CENTER);
        this.setLayout(new BorderLayout()); // j'identifie les futurs emplacements
        this.add(menu, BorderLayout.WEST); // j'ajoute  le MenuPanel
        this.add(leDessin, BorderLayout.CENTER);
    }

    
   
 }

