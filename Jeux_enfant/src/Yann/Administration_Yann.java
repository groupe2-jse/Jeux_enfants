/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Marianne.Bouton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import jeux_enfant.Tablet;
import zine.LabelAndField;

/**
 *
 * @author Yann Golhen
 */
public final class Administration_Yann extends JPanel{

    boolean alreadyShown;
    JLabel erreur;
    JPanel orga, boutonsChoix;
    String mdp;
    
    public Administration_Yann() {
        alreadyShown=false;
        this.initAdmin();
    }

    public void initAdmin() {
        alreadyShown=false;
        this.removeAll();
        this.setName("Administration");
        orga =new JPanel();
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
                askMDP.getTextField().setText("");
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
                    askMDP.getTextField().grabFocus();
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
                    askMDP.getTextField().grabFocus();
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
                askMDP.getTextField().setText("");
                alreadyShown=true;
            }
        });
        
        orga.add(checkMDP);
        global.add(orga,BorderLayout.CENTER);
        this.add(global,BorderLayout.CENTER);
        askMDP.getTextField().grabFocus();
    }
    
    public boolean verifierMDP(String essai)
    {
        String essaiChiffre="";
        for (int i=0;i<essai.length();i++)
        {
            essaiChiffre+=(char)(essai.charAt(i)+5);
        }
        
        try (BufferedReader in = new BufferedReader(new FileReader("password.txt")))
        {
          mdp = in.readLine();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tablet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mdp.equals(essaiChiffre))
            {
                return true;
            }
            else
            {
                return false;
            }
    }

    public void initAdmiValidated() {
        orga.removeAll();
        boutonsChoix = new JPanel(new GridLayout(0,2));
        orga.add(boutonsChoix);
        TitledBorder borderQuestions = new TitledBorder("Modifiez ou Ajoutez une question :");
        boutonsChoix.setBorder(borderQuestions);
        
        Bouton modifier = new Bouton("Modifier");
        Bouton ajouter = new Bouton("Ajouter");
        
        modifier.addActionListener((ActionEvent e) -> {
            modifierQuestion();            
        });
        
        ajouter.addActionListener((ActionEvent e) -> {
            ajouterQuestion();            
        });
        
        boutonsChoix.add(modifier);
        boutonsChoix.add(ajouter);
        
        //orga.add(new JLabel("Changez votre mot de passe :"));
        LabelAndField changeMDP = new LabelAndField("Nouveau mot de passe (min 5 caractères)");
        TitledBorder borderNewMDP = new TitledBorder("Changez votre mot de passe :");
        changeMDP.setBorder(borderNewMDP);
        
        changeMDP.getTextField().addActionListener((ActionEvent e) -> {
            if (changeMDP.getTextField().getText().length()>=5)
            {
                changeMDP();
            }
        });
        
        Bouton validerMDP = new Bouton("Valider");
        validerMDP.addActionListener((ActionEvent e) -> {
            if (changeMDP.getTextField().getText().length()>=5)
            {
                changeMDP();
            }            
        });
        orga.add(changeMDP);
        orga.add(validerMDP);
    }

    private void changeMDP() {
        System.out.println("Mot de passe changé");
    }

    private void modifierQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ajouterQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
