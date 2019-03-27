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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import zine.LabelAndField;

/**
 *
 * @author Yann Golhen
 */
public final class Administration_Yann extends JPanel{

    boolean alreadyShown;
    JLabel erreur;
    
    public Administration_Yann() {
        alreadyShown=false;
        this.initAdmin();
    }

    public void initAdmin() {
        alreadyShown=false;
        this.removeAll();
        this.setName("Administration");
        JPanel orga =new JPanel();
        JPanel global = new JPanel();
        global.setLayout(new BorderLayout());
        orga.setLayout(new BoxLayout(orga,BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        LabelAndField askMDP = new LabelAndField("Veuillez saisir votre mot de passe");
        TitledBorder borderAdmin = new TitledBorder("Bienvenue dans l'interface d'aministration");
        orga.setBorder(borderAdmin);

        erreur = new JLabel("Mot de passe erroné, veuillez réessayer");

        orga.add(askMDP);
        
        askMDP.getTextField().addActionListener((ActionEvent e) -> {
            if (verifierMDP(askMDP.getTextField().getText()))
            {
                System.out.println("bonmdp");
                initAdmiValidated();
            }
            else if (alreadyShown==false)
            {
                orga.add(erreur);
                global.removeAll();
                global.add(orga,BorderLayout.CENTER);
                alreadyShown=true;
            }
        });
        
        askMDP.getTextField().getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    
                    orga.remove(erreur);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    alreadyShown=false;
                    
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    orga.remove(erreur);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    alreadyShown=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    orga.remove(erreur);
                    global.removeAll();
                    global.add(orga,BorderLayout.CENTER);
                    alreadyShown=false;
                }
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
                orga.add(erreur);
                global.removeAll();
                global.add(orga,BorderLayout.CENTER);
                alreadyShown=true;
            }
        });
        
        orga.add(checkMDP);
        global.add(orga,BorderLayout.CENTER);
        this.add(global,BorderLayout.CENTER);
    }
    
    public boolean verifierMDP(String essai)
    {
        
        return false;
    }

    public void initAdmiValidated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
