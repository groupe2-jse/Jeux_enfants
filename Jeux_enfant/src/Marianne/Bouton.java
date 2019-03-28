/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Marianne;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author Yann Golhen
 */
public class Bouton extends JButton{

    boolean alreadyHit;
    String saisie;
    String couleur ; 

    public void setAlreadyHit(boolean alreadyHit) {
        this.alreadyHit = alreadyHit;
    }

    public boolean isAlreadyHit() {
        return alreadyHit;
    }

    public String getSaisie() {
        return saisie;
    }
    
    public Bouton(String name, Font font){
        super(name);
        this.setFont(font);
    }
    
    public Bouton(String name, Font font, Color couleur){
        super(name);
        this.setFont(font);
        this.setBackground(couleur);
    }
    
    public Bouton(String name){
        super(name);
        alreadyHit=false;
        saisie=name;
    }
    
}
