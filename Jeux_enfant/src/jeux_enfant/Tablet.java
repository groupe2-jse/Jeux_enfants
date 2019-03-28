/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeux_enfant;

import Yann.Administration_Yann;
import Yann.Menu_Yann;
import Yann.Onglets;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
        

/**
 *
 * @author Yann Golhen
 */
public class Tablet extends JFrame{

    
    JPanel contenu;
    int niveau, chosen;
    Menu_Yann menuP;
    boolean adminShown;

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    
    public Tablet(String nom) {
        
        
        contenu = new JPanel();
        niveau=1;
        adminShown=false;
        //initialisation de la fenetre principale
        this.setTitle(nom);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.initGUI();
        this.setContentPane(contenu);
        this.pack();
        this.setSize(600, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setAdminShown(boolean adminShown) {
        this.adminShown = adminShown;
    }

    private void initGUI() {
        
        //Creation Layout
        contenu.setLayout(new BorderLayout(5, 5));
        
        //Ajout des onglets       
        Onglets onglets = new Onglets(niveau);
        contenu.add(onglets,BorderLayout.CENTER);
        
        //Ajout du menuBar
        menuP = new Menu_Yann();
        this.setJMenuBar(menuP);
        menuP.getDraw().addActionListener((ActionEvent e) -> {
            onglets.setSelectedIndex(0);
            onglets.getDraw().initDraw();
            if (onglets.getTabCount()>3)
            {
            onglets.remove(3);
            adminShown=false;
            }
        });
        
        menuP.getCalcul().addActionListener((ActionEvent e) -> {
            onglets.setSelectedIndex(1);
            onglets.getCalcul().initCalcul(niveau);
            if (onglets.getTabCount()>3)
            {
            onglets.remove(3);
            adminShown=false;
            }
        });
        
        menuP.getQuestion().addActionListener((ActionEvent e) -> {
            onglets.setSelectedIndex(2);
            onglets.getQuestion().initQuestion(niveau);
            if (onglets.getTabCount()>3)
            {
            onglets.remove(3);
            adminShown=false;
            }
        });
        
        menuP.getNiveau1().addActionListener((ActionEvent e) -> {
            setNiveau(1);
            int chosen = onglets.getSelectedIndex();
            switch (chosen){
                case 0 : onglets.getDraw().initDraw();break;
                case 1 : onglets.getCalcul().initCalcul(niveau);break;
                case 2 : onglets.getQuestion().initQuestion(niveau);
            }
        });
        
        menuP.getNiveau2().addActionListener((ActionEvent e) -> {
            setNiveau(2);
            int chosen = onglets.getSelectedIndex();
            switch (chosen){
                case 0 : onglets.getDraw().initDraw();break;
                case 1 : onglets.getCalcul().initCalcul(niveau);break;
                case 2 : onglets.getQuestion().initQuestion(niveau);
            }
        });
        
        menuP.getAdministration().addActionListener((ActionEvent e) -> {
            if (!adminShown){
            Administration_Yann admin = new Administration_Yann();
            onglets.add(admin);
            onglets.setSelectedIndex(onglets.getTabCount()-1);
            adminShown=true;
            }
        });
        
        onglets.addChangeListener((ChangeEvent e) -> {
            chosen = onglets.getSelectedIndex();
            switch (chosen){
                case 0 : onglets.getDraw().initDraw();
                        if (adminShown)
                        {
                        onglets.remove(onglets.getTabCount()-1);
                        adminShown=false;
                        }break;
                case 1 : onglets.getCalcul().initCalcul(niveau);
                        if (adminShown)
                        {
                        onglets.remove(onglets.getTabCount()-1);
                        adminShown=false;
                        }break;
                case 2 : onglets.getQuestion().initQuestion(niveau);
                        if (adminShown)
                        {
                        onglets.remove(onglets.getTabCount()-1);
                        adminShown=false;
                        }
            }
        });
        
    }

    
    
}
