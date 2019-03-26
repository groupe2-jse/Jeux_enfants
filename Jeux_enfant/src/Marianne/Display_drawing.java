/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import javax.swing.JPanel;

/**
 *
 * @author Expression Marianne is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Display_drawing extends JPanel{
    
    /**
     *
     */
    Label title = new Label("Mon Dessin"); 
    JPanel support = new JPanel(); 
    JPanel dessin = new JPanel(); 
    
    public Display_drawing() {
        
        //dessin.setBackground(Color.red) ; 
        this.setLayout(new BorderLayout());
        
        support.setLayout(new BorderLayout());
        support.add(title, BorderLayout.NORTH); 
        support.add(dessin, BorderLayout.CENTER) ; 
        this.setSize(300,300);
        this.add(support, BorderLayout.CENTER); 
        
        
    }
    
     

}
