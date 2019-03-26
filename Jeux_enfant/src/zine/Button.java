/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zine;

import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author stagldnr
 */
public class Button extends JButton{
    
    public Button(String name, Font font){
        
        super(name);
        this.setFont(font);
    }
    
     public Button(String name){
        
        super(name);
    }
}
