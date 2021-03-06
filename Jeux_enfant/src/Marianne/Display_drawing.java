/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marianne;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class Display_drawing extends JPanel {

    int x = 0, y = 0;
    int x2 = 0, y2=0 ; 
    Graphics g;
    Graphics2D g1;
    String couleur, epaisseur, epaisseurReminder, shape, shapeReminder, couleurReminder;
    BasicStroke line1; 

    // reminder permet au prog de se souvenir des derniers parametres enregistres
    // exemple lors du passage de la gomme au pinceau
    public String getCouleurReminder() {
        return couleurReminder;
    }

    public void setCouleurReminder(String couleurReminder) {
        this.couleurReminder = couleurReminder;
    }

    public String getShape() {
        return shape;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    // reminder permet au prog de se souvenir des derniers parametres enregistres
    // exemple lors du passage de la gomme au pinceau
    
    public String getShapeReminder() {
        return shapeReminder;
    }

    public void setShapeReminder(String shapeReminder) {
        this.shapeReminder = shapeReminder;
    }

    public void setEpaisseurReminder(String epaisseurReminder) {
        this.epaisseurReminder = epaisseurReminder;
    }

     public String getEpaisseur() {
        return epaisseur;
    }

    public String getEpaisseurReminder() {
        return epaisseurReminder;
    }
    public Graphics getG() {
        return g;
    }
    
    JPanel affiche = new JPanel();

    public Display_drawing() {
        couleur="noir";
        epaisseur = "Fin" ;
        epaisseurReminder = "Fin";
        shape = "Fin";
        shapeReminder = "Fin";
        affiche.setBackground(Color.WHITE);

        this.addMouseListener(new MouseAdapter() { // mouvement de la souris
            //@Override
            public void mousePressed(MouseEvent e) {
//              
                x = e.getX();
                y = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {  // mouseEvent : evenement lié au mvt de la souris
            //@Override
            public void mouseDragged(MouseEvent e) {
                
                g = affiche.getGraphics();
                // creation d'un objet graphics2D pour utiliser stroke, gestion de la largeur du tracé
                g1 = (Graphics2D)g; 
                
               initColor(g,couleur);
               initLine ( epaisseur);
               initShape(shape);
               g1.drawLine(x, y, e.getX(), e.getY());
               x = e.getX();
               y = e.getY();
            }

            
            
            private void initShape(String pShape) {
                // forme du pinceau carre ou rond
                switch (pShape)
        {
            case "Carré" : g1.drawRect(x,y,4,4);
                         shape= "Carré" ; break; 
                         
            case "Rond"  : g1.drawOval(x,y,4,4);
                        shape= "Rond" ; break;
                        
            case "Gomme": g1.drawRect(x,y,6,6);
                        shape= "Gomme" ;
                        
        }
                
            }});
         // gestion des emplacements   
        this.setLayout(new BorderLayout());
        this.add(affiche, BorderLayout.CENTER);
}

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    // vraiment fait par moi  
    
    public void initColor (Graphics g1, String couleur) 
      {
          switch (couleur)
          {
              // changement de couleur lors de l'affichage
              case "bleu" : g1.setColor(Color.BLUE);
              this.couleur="bleu";break;
              
              case "rouge" : g1.setColor(Color.red);
              this.couleur="rouge";break;
              
              case "jaune" : g1.setColor(Color.YELLOW);
              this.couleur="jaune";break;
              
              case "gris" : g1.setColor(Color.gray);
              this.couleur="gris";break;
              
              case "noir" : g1.setColor(Color.black);
              this.couleur="noir";break;
              
              case "rose" : g1.setColor(Color.pink);
              this.couleur="rose";break;
              
              case "violet" : g1.setColor(Color.magenta);
              this.couleur="violet";break;
              
              case "vert" : g1.setColor(Color.green);
              this.couleur="vert"; break;
              
              case "Gomme" : g1.setColor(Color.WHITE);
              this.couleur="Gomme"; break;
             
             default : g1.setColor(Color.black);
          }      
    }
    
    public void setEpaisseur(String epaisseur){
        this.epaisseur = epaisseur ; 
    }
    
    
    public void initLine(String epaisseur){
       // selection de l'epaisseur du pinceau en fonction du bouton a ecouter
        switch (epaisseur)
        {
            case "Gros" : line1 = new BasicStroke(4.0f);
                         g1.setStroke(line1);
                         this.epaisseur= "Gros" ; break; 
                         
            case "Fin" : line1 = new BasicStroke(1.0f);
                         g1.setStroke(line1);
                         this.epaisseur= "Fin" ;
                         this.shape = "Fin"; break;
                         
            case "Gomme": line1 = new BasicStroke(15.0f);
                        g1.setStroke(line1);
                        this.epaisseur= "Gomme" ;
        }
    }
    
        
    
}
