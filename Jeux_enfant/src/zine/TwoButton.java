/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author stagldnr
 */
public class TwoButton extends JPanel{
    JButton Suivant;
    JButton Verification;
    
    public TwoButton()
    {
        Suivant = new JButton("Question suivante");
        Verification = new JButton("Vérification");
        this.setLayout(new FlowLayout());
        this.add(Suivant);
        this.add(Verification);
    }
    
    
}
