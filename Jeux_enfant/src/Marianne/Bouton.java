/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Yann Golhen
 */
public class Bouton extends JButton{

    public Bouton(String name, Font font){
        super(name);
        this.setFont(font);
    }

    public Bouton(String name){
        super(name);
    }
    
}
