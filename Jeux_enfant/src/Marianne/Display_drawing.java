/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marianne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class Display_drawing extends JPanel {

    int x = 0, y = 0;
    Graphics g;
    JPanel affiche = new JPanel();

    public Display_drawing() {

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
                // g.setColor(Color.black);
                initColor("couleur");
                
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
    public void initColor (String couleur) 
      {
          if (couleur.equals("bleu")) {
              System.out.println("initbleu");
              // Graphics g = getGraphics() ; 
               this.g.setColor(Color.BLUE);
          }
          
          if (couleur.equals("red")) {
              
              // Graphics g = getGraphics() ; 
                g.setColor(Color.red);
          }
          
          
    }
}
