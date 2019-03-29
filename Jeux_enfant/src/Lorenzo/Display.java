/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import Marianne.Bouton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public class Display extends JPanel{
    Font f1, f2;
    Bouton b1,b2,b3;
    JLabel lb1,lb2,lb3;
    JPanel bottomButtons;
    CalculAndTextField calculZone;

    public Bouton getB1() {
        return b1;
    }

    public void setB1(Bouton b1) {
        this.b1 = b1;
    }

    public Bouton getB2() {
        return b2;
    }

    public void setB2(Bouton b2) {
        this.b2 = b2;
    }

    public Bouton getB3() {
        return b3;
    }

    public void setB3(Bouton b3) {
        this.b3 = b3;
    }

    public JLabel getLb1() {
        return lb1;
    }

    public void setLb1(JLabel lb1) {
        this.lb1 = lb1;
    }

    public JLabel getLb2() {
        return lb2;
    }

    public void setLb2(JLabel lb2) {
        this.lb2 = lb2;
    }

    public JLabel getLb3() {
        return lb3;
    }

    public void setLb3(JLabel lb3) {
        this.lb3 = lb3;
    }
    public Display(CreateOperation operation){    
        
        //GESTION DE L'AFFICHAGE ET DE L'EMBOITEMENT DES JPANEL
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.white);
       
        calculZone = new CalculAndTextField(operation.getCalcul(), 3, new Font("ComicSansMS", Font.BOLD, 50));
        calculZone.setBackground(Color.white);
        
        bottomButtons = new JPanel();
        bottomButtons.setLayout(new GridLayout(0, 2, 100, 10));
        bottomButtons.setBackground(Color.white);
        
        f1 = new Font("ComicSansMs", Font.BOLD, 20);
        f2 = new Font("ComicSansMs", Font.BOLD, 14);
        
        b1 = new Bouton("Autre calcul",f1,Color.CYAN);
        b2 = new Bouton("Solution",f1, Color.GREEN);
        b3 = new Bouton("Vérifier réponse",f1, Color.ORANGE);
        
        lb1= new JLabel(" ");
        lb2= new JLabel(" ");
        lb2.setFont(f2);
        lb3= new JLabel(" ");
        lb3.setFont(f2);
        
        bottomButtons.add(lb1);
        bottomButtons.add(b1);
        bottomButtons.add(lb2);
        bottomButtons.add(b2);
        bottomButtons.add(lb3);
        bottomButtons.add(b3);
        
        this.add(calculZone);
        this.add(bottomButtons);

    }

    public CalculAndTextField getCalculZone() {
        return calculZone;
    }

    public void setCalculZone(CalculAndTextField calculZone) {
        this.calculZone = calculZone;
    }
}