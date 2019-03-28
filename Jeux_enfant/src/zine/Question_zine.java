/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zine;

import Pkg_DAO.Question_Julien;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Expression zine is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Question_zine extends JPanel{

    JPanel Reponse;
    JButton suivant;
    JLabel question;
    static int compteur;
    
    public Question_zine() {
        
        this.Reponse = new LabelAndField("Réponse");
        this.suivant = new Button("Suivant");
        this.question = new JLabel(textQuestion());
        this.setLayout(new GridLayout(1, 3));
        this.add(suivant);      
        this.add(Reponse);
        this.add(question);
        
        
    }
    
    private static String textQuestion()
    {
        String text = "";
        Question_Julien daop = new Question_Julien();
        int id = ChoixQuestion();
        Question a = daop.find(id);
        text = a.getQuestions();
        return text;
    }
    
    private static int ChoixQuestion()
    {
        int tabId[]={};
        
        int nbr;
        int choixNiveau = 1;
        int idRef;
        Random r = new Random();
        int nb = r.nextInt((9 - 0) + 1);
        Question_Julien daop = new Question_Julien();
        Question a = daop.find(nb);
        idRef = a.getId();
        nbr = a.getNiveau_question();
        if(nbr != choixNiveau)
        {
            return ChoixQuestion();
        }
        else
        {
            for(int i = 0; i != compteur; i++)
            {
                if(tabId[i] == idRef)
                {
                    return ChoixQuestion();
                }
            }
        }
        compteur = compteur + 1;
        tabId[compteur]=idRef;
        
        return idRef;
    }

    public void initQuestion(int niveau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
