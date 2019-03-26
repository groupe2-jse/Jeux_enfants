/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import Marianne.Bouton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public class MainLorenzo {
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("Calcul");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contents= new JPanel();
        contents.setLayout(new BoxLayout(contents,BoxLayout.Y_AXIS));
        
        Calcul_Lorenzo c = new Calcul_Lorenzo(2);
        JPanel calculZone = new CalculAndTextField(c.getCalcul(), 3);
        JPanel bottomButtons = new JPanel();
        bottomButtons.setLayout(new GridLayout(0, 2, 100, 10));
        
        
        
        Font f1 = new Font("ComicSansMS", Font.BOLD, 13);
        Font f2 = new Font("ComicSansMs", Font.BOLD, 20);
        Bouton b1 = new Bouton("Autre calcul",f1);
        Bouton b2 = new Bouton("Solution",f1);
        Bouton b3 = new Bouton("Vérifier réponse");
        JLabel lb1= new JLabel(" ");
        JLabel lb2= new JLabel("TEST AFFICHAGE SOLUTION");
        JLabel lb3= new JLabel("TEST AFFICHAGE VERIFICATION");
        c.add(calculZone);
        bottomButtons.add(lb1);
        bottomButtons.add(b1);
        bottomButtons.add(lb2);
        bottomButtons.add(b2);
        bottomButtons.add(lb3);
        bottomButtons.add(b3);
        contents.add(c);
        contents.add(bottomButtons);
        jf.add(contents);
        jf.pack();
        jf.setVisible(true);
        
    }
}
