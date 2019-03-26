/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Marianne.Bouton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import zine.LabelAndField;

/**
 *
 * @author Yann Golhen
 */
public final class Administration_Yann extends JPanel{

    public Administration_Yann() {
        this.initAdmin();
    }

    public void initAdmin() {
        
        this.removeAll();
        this.setName("Administration");
        JPanel orga =new JPanel();
        orga.setLayout(new BoxLayout(orga,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        LabelAndField askMDP = new LabelAndField("Veuillez entrer votre mot de passe");
        orga.add(askMDP);
        orga.add(new Bouton("Valider"));
        this.add(orga,BorderLayout.CENTER);
    }
    
}
