/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zine;

import Marianne.Bouton;
import Pkg_DAO.Question_Julien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Expression zine is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public final class Question_zine extends JPanel{

    LabelAndField reponse;
    TwoButton Bouton;
    Bouton suivant;
    JLabel question,resultat;
    List <Question> liste1,liste2;
    Question_Julien daop;
    int rnd;
    Random randomNo;
    String text;
    boolean alreadyShown;
    
    
    public Question_zine(int niveau) {
        
        text = "";
        this.initQuestion(niveau);
        alreadyShown=false;
        
    }
    
    private String textQuestion(int niveau)
    {
        randomNo = new Random();
        
        switch(niveau)
        {
            case 1:
            if(liste1.isEmpty())
            {
                text = "C'était la dernière question !";
            }
            else
            {
                rnd = randomNo.nextInt(liste1.size());
                text = liste1.get(rnd).getQuestions();
            }
            break;
            
            case 2:
               if(liste2.isEmpty())
            {
                text = "C'était la dernière question !";
            }
            else
            {
                rnd = randomNo.nextInt(liste2.size());
                text = liste2.get(rnd).getQuestions();
            };
        
        }
        
        return text;
    }
 
    public void initQuestion(int niveau) {
        this.removeAll();
        this.repaint();
        question = new JLabel("");
        question.setText("");
        this.setName("Questions");
        reponse = new LabelAndField("Réponse");
        reponse.getTextField().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(reponse.getTextField().getText(), niveau);
            }
            
        });
        
        
        reponse.getTextField().getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    resultat.setText("");
                    alreadyShown=false;
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (alreadyShown)
                {
                    resultat.setText("");
                    alreadyShown=false;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }

        });
        
        resultat = new JLabel("");
        
        Bouton = new TwoButton();
        
        Bouton.getSuivant().addActionListener((ActionEvent e) -> {
            rechargeQuestion(niveau);
            resultat.setText("");
        });
        
        Bouton.getVerification().addActionListener((ActionEvent e) -> {
            checkAnswer(reponse.getTextField().getText(), niveau);
        });

        
        liste1 = new ArrayList();
        liste2 = new ArrayList();
        
        daop = new Question_Julien();
        liste1  = daop.findNiveau1(niveau);
        liste2  = daop.findAll();
        
        rechargeQuestion(niveau);
        this.setLayout(new BoxLayout(this, Y_AXIS));
        this.add(question);      
        this.add(reponse);
        this.add(resultat);
        this.add(Bouton);
        
    }

    private void rechargeQuestion(int niveau) {
       
        question.setText(textQuestion(niveau));
    }

    private void checkAnswer(String answer, int niveau) {
        switch(niveau)
        {
            case 1:
                if (liste1.get(rnd).getReponse().toLowerCase().equals(answer.toLowerCase()))
                {
                    resultat.setText("Bravo, bonne réponse");
                    alreadyShown=true;
                    liste1.remove(rnd);
                    rechargeQuestion(niveau);
                    reponse.getTextField().setText("");
                }
                else
                {
                    resultat.setText("Mauvaise réponse");
                    alreadyShown=true;
                }
            break;
            
            case 2:
            {
                if (liste1.get(rnd).getReponse().equals(answer))
                {
                    resultat.setText("Bravo, bonne réponse");
                    alreadyShown=true;
                    liste1.remove(rnd);
                    rechargeQuestion(niveau);
                    reponse.getTextField().setText("");
                }
                else
                {
                    resultat.setText("Mauvaise réponse");
                    alreadyShown=true;
                }
            };
        
        }
    }

}
