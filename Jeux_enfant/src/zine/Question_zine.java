/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zine;

import Pkg_DAO.Question_Julien;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
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
        this.question = new JLabel(textQuestion(1));
        this.setLayout(new GridLayout(1, 3));
        this.add(suivant);      
        this.add(Reponse);
        this.add(question);
        
        
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
        
            case 2:
                liste  = daop.findNiveau2(niveau);
        text = liste.get(compteur).getQuestions();
        compteur = compteur + 1;
        if(liste.isEmpty())
        {
            text = "C'était la dernière question !";
        }
                
        
        }
        
        return text;
    }
 
    public void initQuestion(int niveau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
