/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marianne;

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

    /**
     *
     */
    int x = 0, y = 0;
    JPanel affiche ; 

    public Display_drawing() {

        affiche=new JPanel();
        
        this.setBackground(Color.WHITE);
        
        
        this.addMouseListener(new MouseAdapter() {
            //@Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
            //@Override
            public void mouseDragged(MouseEvent e ){
                Graphics g = affiche.getGraphics() ; 
                g.drawLine(x, y, e.getX(),e.getY() );
                x = e.getX(); 
                y = e.getY() ; 
                
            }
});
          
           
    }
     
    

}
