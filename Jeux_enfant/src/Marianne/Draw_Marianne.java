/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marianne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class Draw_Marianne extends JPanel {

    Display_drawing leDessin;
    Bouton delete, gomme;
    JPanel choicePen, pen;
    JPanel menu;
    JPanel choiceColor;
    JPanel effacer;
    Bouton jb;
    TitledBorder title, title2, title3;
    

    public Draw_Marianne() {
        this.setName("Dessin"); // constructeur signé
        this.initDraw();
    }

    public void initDraw() {
        
        // vide l'objet
        this.removeAll();
        // objet de support pour l'affichage du dessin
        leDessin = new Display_drawing();
        // support pour les differents boutons de couleur
        choiceColor = new JPanel();
        choiceColor.setLayout(new GridLayout(0, 2, 2, 2));
        // creation de titre et cadre
        title2 = new TitledBorder("Choix de la couleur");
        title3 = new TitledBorder("");
        // ajout de titleBorder
        choiceColor.setBorder(title2);
        // support pour les boutons d'effacement
        effacer = new JPanel();
        effacer.setLayout(new BorderLayout());
        delete = new Bouton("Effacer");

        gomme = new Bouton("Gomme");
        // creation d'un ecouteur pour le bouton gomme
        gomme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leDessin.setEpaisseur(((Bouton) e.getSource()).getText());
                leDessin.setCouleur(((Bouton) e.getSource()).getText());
                leDessin.setShape("Gomme");
            }
        });
        effacer.setBorder(title3);
        effacer.add(delete, BorderLayout.NORTH);
        effacer.add(gomme, BorderLayout.SOUTH);
        // creation ecouteur pour bouton effacer
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initDraw();
            }
        });

        choicePen = new JPanel();
        title = new TitledBorder("Choix du crayon");
        choicePen.setLayout(new BorderLayout());
        choicePen.setBorder(title);
        pen = new JPanel();
        pen.setLayout(new GridLayout(0, 2, 2, 2));

        String[] differentPen = {
            "Gros", "Fin"
        };
        // boucle for etendue pour la creation des boutons et ajout d'ecouteur 
        for (String s : differentPen) {
            jb = new Bouton(s);
            pen.add(jb);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    leDessin.setEpaisseur(((Bouton) e.getSource()).getText());
                    leDessin.setEpaisseurReminder(((Bouton) e.getSource()).getText());

                    if (leDessin.getCouleur().equals("Gomme")) {
                        leDessin.setCouleur(leDessin.getCouleurReminder());
                    }
                    if (leDessin.getShape().equals("Gomme")) {
                        leDessin.setShape(leDessin.getShapeReminder());
                    }

                }

            });
        }
        String[] differentShape = {
            "Rond", "Carré"
        };
        // boucle for etendue pour la creation des boutons et ajout d'ecouteur 
        for (String s : differentShape) {
            jb = new Bouton(s);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    leDessin.setShape(((Bouton) e.getSource()).getText());
                    leDessin.setShapeReminder(((Bouton) e.getSource()).getText());
                    if (leDessin.getCouleur().equals("Gomme")) {
                        leDessin.setCouleur(leDessin.getCouleurReminder());
                    }
                    if (leDessin.getEpaisseur().equals("Gomme")) {
                        leDessin.setEpaisseur(leDessin.getEpaisseurReminder());
                    }
                }
            });
            pen.add(jb);
        }
        choicePen.add(pen, BorderLayout.CENTER);
        menu = new JPanel();
        menu.setLayout(new BorderLayout());
        //menu.add(color, BorderLayout.NORTH) ; 
        menu.add(choiceColor, BorderLayout.NORTH);
        String[] differentColor = {
            "bleu", "rouge", "jaune",
            "gris", "noir", "rose",
            "violet", "vert"

        };
        // boucle for etendue pour la creation des boutons et ajout d'ecouteur 
        for (String s : differentColor) {
            jb = new Bouton(s);
            switch (s) {
                case "bleu":
                    jb.setBackground(Color.blue);
                    jb.setForeground(Color.white);
                    break;
                case "rouge":
                    jb.setBackground(Color.red);
                    break;
                case "jaune":
                    jb.setBackground(Color.yellow);
                    break;
                case "gris":
                    jb.setBackground(Color.gray);
                    break;
                case "noir":
                    jb.setBackground(Color.black);
                    jb.setForeground(Color.white);
                    break;
                case "rose":
                    jb.setBackground(Color.pink);
                    break;
                case "violet":
                    jb.setBackground(Color.magenta);
                    break;
                case "vert":
                    jb.setBackground(Color.green);
                    break;
            }
            choiceColor.add(jb);

            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // setCouleur recupere la couleur saisie
                    // lance la fonction sur chaque bouton 
                    // getSouce = le bouton sur lequel on clique
                    // getTexte = renvoie titre string[]
                    leDessin.setCouleur(((Bouton) e.getSource()).getText());
                    leDessin.setCouleurReminder(((Bouton) e.getSource()).getText());
                    if (leDessin.getEpaisseur().equals("Gomme")) {
                        leDessin.setEpaisseur(leDessin.getEpaisseurReminder());
                    }
                    if (leDessin.getShape().equals("Gomme")) {
                        leDessin.setShape(leDessin.getShapeReminder());
                    }

                }
            });
        }

        // implantation
        effacer.add(delete, BorderLayout.NORTH);
        menu.add(effacer, BorderLayout.SOUTH);
        menu.add(choicePen, BorderLayout.CENTER);
        this.setLayout(new BorderLayout()); // j'identifie les futurs emplacements
        this.add(menu, BorderLayout.WEST); // j'ajoute  le MenuPanel
        this.add(leDessin, BorderLayout.CENTER);
    }

}
