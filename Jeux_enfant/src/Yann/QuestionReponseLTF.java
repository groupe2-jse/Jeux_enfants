/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import zine.LabelAndField;

/**
 *
 * @author Yann Golhen
 */
public class QuestionReponseLTF extends JPanel{

    LabelAndField question,reponse;

    public LabelAndField getQuestion() {
        return question;
    }

    public LabelAndField getReponse() {
        return reponse;
    }
    
    public QuestionReponseLTF(String pQuestion, String pReponse)
    {
        question = new LabelAndField("Question : ");
        reponse = new LabelAndField("Réponse : ");
        
        question.getTextField().setText(pQuestion);
        reponse.getTextField().setText(pReponse);
        
        TitledBorder borderQR = new TitledBorder("Saisissez la question et sa réponse");
        this.setBorder(borderQR);
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(question);
        this.add(reponse);
    }
}
