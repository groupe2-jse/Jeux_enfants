/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marianne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
    Graphics g;
    String couleur;

    public Graphics getG() {
        return g;
    }
    
    JPanel affiche = new JPanel();

    public Display_drawing() {
        couleur="noir";
        affiche.setBackground(Color.WHITE);

        this.addMouseListener(new MouseAdapter() { // mouvement de la souris
            //@Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {  // mouseEvent : evenement lié au mvt de la souris
            //@Override
            public void mouseDragged(MouseEvent e) {

                g = affiche.getGraphics();
                initColor(g,couleur);
                
                g.drawLine(x, y, e.getX(), e.getY());

                x = e.getX();
                y = e.getY();

            }
        });
          

    this.setLayout(
    new BorderLayout());
        

    this.add(affiche, BorderLayout.CENTER);

}
    // vraiment fait par moi  
    public void initColor (Graphics g1, String couleur) 
      {
          switch (couleur)
          {
              case "bleu" : g1.setColor(Color.BLUE);
              this.couleur="bleu";break;
              
              case "rouge" : g1.setColor(Color.red);
              this.couleur="rouge";break;
              
          }
          
          
          
    }
}
