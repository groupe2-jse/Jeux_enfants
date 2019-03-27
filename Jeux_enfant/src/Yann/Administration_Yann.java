/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Marianne.Bouton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import zine.LabelAndField;

/**
 *
 * @author Yann Golhen
 */
public final class Administration_Yann extends JPanel{

    boolean alreadyShown;
    
    public Administration_Yann() {
        alreadyShown=false;
        this.initAdmin();
    }

    public void initAdmin() {
        alreadyShown=false;
        this.removeAll();
        this.setName("Administration");
        JPanel orga =new JPanel();
        orga.setLayout(new BoxLayout(orga,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        LabelAndField askMDP = new LabelAndField("Veuillez saisir votre mot de passe");
        TitledBorder borderAdmin = new TitledBorder("Bienvenue dans l'interface d'aministration");
        orga.setBorder(borderAdmin);


        orga.add(askMDP);
        
        askMDP.getTextField().addActionListener((ActionEvent e) -> {
            if (verifierMDP(askMDP.getTextField().getText()))
            {
                System.out.println("bonmdp");
                initAdmiValidated();
            }
            else if (alreadyShown==false)
            {
                orga.add(new JLabel("Mot de passe erroné, veuillez réessayer"));
                this.removeAll();
                this.add(orga,BorderLayout.CENTER);
                alreadyShown=true;
            }
        });
        
        //Ajout bouton valider lancant la méthode de vérification
        Bouton checkMDP = new Bouton("Valider");
        checkMDP.addActionListener((ActionEvent e) -> {
            if (verifierMDP(askMDP.getTextField().getText()))
            {
                System.out.println("bonmdp");
                initAdmiValidated();
            }
            else if (alreadyShown==false)
            {
                orga.add(new JLabel("Mot de passe erroné, veuillez réessayer"));
                this.removeAll();
                this.add(orga,BorderLayout.CENTER);
                alreadyShown=true;
            }
        });
        
        orga.add(checkMDP);
        this.add(orga,BorderLayout.CENTER);
    }
    
    public boolean verifierMDP(String essai)
    {
        
        return false;
    }

    public void initAdmiValidated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
