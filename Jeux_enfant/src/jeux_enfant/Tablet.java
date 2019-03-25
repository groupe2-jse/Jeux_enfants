/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeux_enfant;

import Yann.Menu_Yann;
import Yann.Onglets;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Yann Golhen
 */
public class Tablet extends JFrame{

    JPanel contenu;
    
    
    public Tablet(String nom) {
        
        contenu = new JPanel();
        //initialisation de la fenetre principale
        this.setTitle(nom);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.initGUI();
        this.setContentPane(contenu);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void initGUI() {
        
        //Creation Layout
        contenu.setLayout(new BorderLayout(5, 5));
        
        //Ajout du menuBar
        this.setJMenuBar(new Menu_Yann());
        
        //Init des onglets
        
        
        
        //Ajout des onglets
        this.add(new Onglets(),BorderLayout.CENTER);
        
    }

    
    
}
