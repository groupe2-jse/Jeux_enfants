/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Marianne.Bouton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Yann Golhen
 */
public final class Surprise extends JPanel{

    String wordToFind, sLettre;
    int fails;
    int tries;
    ArrayList <String> proposedLetters = new ArrayList<>();
    ArrayList <String> foundLetters = new ArrayList<>();
    String wordToShow, clavier;
    char letter;
    boolean hanged, found, letterFound, debugMode, uniqueLetter;
    int MAX_FAILS = 7;
    Bouton bLettre;
    JPanel keyboard;
    JLabel result, life, answer,congratulations;
    
    public Surprise(){
        
        clavier= "azertyuiopqsdfghjklmwxcvbn";
        fails=0;
        tries=0;
        wordToShow="";
        hanged=false;
        found=false;
        letterFound=false;
        uniqueLetter=true;
        debugMode=false;
        initSurprise();
    }

    public void initSurprise() {
        
        wordToFind=getRandomWordFromFile("dictionary.dat");
        makeWordToShow();
        
        this.removeAll();
        this.setName("Pendu");
        
        keyboard = new JPanel();
        keyboard.setLayout(new GridLayout(0,10));
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        
        result = new JLabel("");
        life = new JLabel("Vies restantes : " + MAX_FAILS);
        answer = new JLabel("Mot à trouver : " + wordToShow);
        congratulations = new JLabel("");
        
        for (int i=0;i<clavier.length();i++)
        {
            sLettre=""+clavier.charAt(i);
            bLettre= new Bouton(sLettre);
            bLettre.addActionListener((ActionEvent e) -> {
                if (!((Bouton)e.getSource()).isAlreadyHit())
                {
                    result.setText(checkLetter(((Bouton)e.getSource()).getText().charAt(0)));
                    ((Bouton)e.getSource()).setText("");
                    makeWordToShow();
                    answer.setText("Mot à trouver : " + wordToShow);
                    
                    if(checkFound())
                    {
                        congratulations.setText("--- Bravo vous avez trouvé le mot : " + wordToFind + " ---");
                    }
                    else if (checkHanged())
                    {
                        congratulations.setText("--- Perdu ! le mot était : " + wordToFind + " ---");
                    }
                    
                    ((Bouton)e.getSource()).setAlreadyHit(true);
                    
                }
            });
            keyboard.add(bLettre);
            this.add(keyboard);
            this.add(result);
            this.add(life);
            this.add(answer);
            this.add(congratulations);
            
        }
        
        
        
    }
 
    /**
     * Choix du mot aléatoire pris dans le dictionary
     * @return un mot aléatoire du dictonnaire
     */
    private String getRandomWordFromFile(String fileName)
    {
        //Création d'un objet de la classe random, pour appliquer la méthode nextInt
        Random randomNo = new Random();
        String mot="";
        int rdm=randomNo.nextInt(336528);
        try (BufferedReader in = new BufferedReader(new FileReader(fileName)))
        {
          for (int i=0;i<rdm;i++)
          {
              in.readLine();
          }
          mot = in.readLine();
          
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Surprise.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Surprise.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mot;
    }
    
    
    
   
    /**
     * Vérification de la présence de la lettre dans le mot à trouver
     * @param letter La lettre saisie par l'utilisateur
     * @return Une phrase qui dit si la lettre est présente dans le mot
     */
    private String checkLetter(char letter)
    {
        for (int i=0;i<wordToFind.length();i++)
        {
            if (wordToFind.charAt(i)==letter)
            {
                foundLetters.add(""+letter);
                return "Bravo, lettre trouvée";
            }
        }
        fails++;
        life.setText("Vies restantes : " + (MAX_FAILS-fails));
        return "Désolé cette lettre ne fait pas partie du mot";

    }
    
    /**
     * Construction du mot à trouver avec les "*"
     */
    private void makeWordToShow()
    {
        wordToShow="";
        //Boucle sur le mot a trouver
        for (int i=0;i<wordToFind.length();i++)
        {
            letterFound=false;
            //Boucle sur les lettres trouvées
            for (Iterator<String> it = foundLetters.iterator(); it.hasNext();)
            {
                //Si une lettre trouvée se trouve dans le mot, l'écrire
                if (it.next().equals(""+wordToFind.charAt(i)))
                {
                    wordToShow+=wordToFind.charAt(i);
                    letterFound=true;
                    break;
                }
            }
            //Sinon, écrire un "*"
            if (letterFound==false)
            {
                wordToShow+='*';
            }
        }
    }
    
    
    /**
     * Condition de victoire (toutes les lettres sont trouvées
     * @return true si toutes les lettres ont été trouvées
     */
    private boolean checkFound()
    {
        return !wordToShow.contains("*");
    }
    
    /**
     * Condition de défaite (plus d'essais restant)
     * @return true si il ne reste plus d'essais
     */
    private boolean checkHanged()
    {
        return fails == MAX_FAILS;
    }
    
   
}