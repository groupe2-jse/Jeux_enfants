/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import java.awt.BorderLayout;
import javax.swing.JPanel;

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
        this.setLayout(new BorderLayout());
//        LabelAndField askMDP = new LabelAndField("Veuillez entrer votre mot de passe");
//        this.add(askMDP,BorderLayout.NORTH);
    }
    
}
