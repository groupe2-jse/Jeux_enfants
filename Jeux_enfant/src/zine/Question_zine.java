/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zine;

import Marianne.Bouton;
import Pkg_DAO.Question_Julien;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.LINE_AXIS;
import static javax.swing.BoxLayout.X_AXIS;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Expression zine is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Question_zine extends JPanel{

    LabelAndField Reponse;
    TwoButton Bouton;
    Bouton suivant;
    JLabel question;
    static int compteur;
    
    public Question_zine(int niveau) {
        
        
        this.initQuestion(niveau);
        
    }
    
    private static String textQuestion(int niveau)
    {
        String text = "";
        List <Question> liste = new ArrayList();
        Question_Julien daop = new Question_Julien();
        
        switch(niveau)
        {
            case 1:
                liste  = daop.findNiveau1(niveau);
        text = liste.get(compteur).getQuestions();
        compteur = compteur + 1;
        if(liste.isEmpty())
        {
            text = "C'était la dernière question !";
        }
            break;
            
            case 2:
                liste  = daop.findNiveau2(niveau);
        text = liste.get(compteur).getQuestions();
        compteur = compteur + 1;
        if(liste.isEmpty())
        {
            text = "C'était la dernière question !";
        }
                
        break;
        
            default : 
                break;
        }
        
        return text;
    }
 
    public void initQuestion(int niveau) {
        this.removeAll();
        this.setName("Questions");
       this.Reponse = new LabelAndField("Réponse");
        this.Bouton = new TwoButton();
        this.question = new JLabel(textQuestion(niveau));
        this.setLayout(new BoxLayout(this, Y_AXIS));
        this.add(question);      
        this.add(Reponse);
        this.add(Bouton);
        
    }

}
