/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zine;

import Marianne.Bouton;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author stagldnr
 */
public class TwoButton extends JPanel{
    Bouton suivant;
    Bouton verification;

    public JButton getSuivant() {
        return suivant;
    }

    public JButton getVerification() {
        return verification;
    }
    
    public TwoButton()
    {
        suivant = new Bouton("Question suivante");
        verification = new Bouton("Vérification");
        this.setLayout(new FlowLayout());
        this.add(suivant);
        this.add(verification);
    }
    
    
}
