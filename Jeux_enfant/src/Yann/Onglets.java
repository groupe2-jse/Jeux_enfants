/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Lorenzo.Calcul_Lorenzo;
import Marianne.Draw_Marianne;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import jeux_enfant.Tablet;
import zine.Question_zine;

/**
 *
 * @author Yann Golhen
 */
public class Onglets extends JTabbedPane{

    int chosen;
    Draw_Marianne draw ;
    Calcul_Lorenzo calcul;
    Question_zine question;

    public Draw_Marianne getDraw() {
        return draw;
    }

    public Calcul_Lorenzo getCalcul() {
        return calcul;
    }

    public Question_zine getQuestion() {
        return question;
    }
    
    public Onglets(int niveau) {
        
        draw = new Draw_Marianne();
        calcul = new Calcul_Lorenzo(niveau);
        question = new Question_zine();
        this.add(draw);
        this.add(calcul);
        this.add(question);
        this.addChangeListener((ChangeEvent e) -> {
            chosen = this.getSelectedIndex();
            switch (chosen){
                case 0 : draw.initDraw();break;
                case 1 : calcul.initCalcul(((Tablet)((JRootPane)((JLayeredPane)((JPanel)((JTabbedPane)e.getSource())
                        .getParent()).getParent()).getParent()).getParent()).getNiveau());break;
                //case 2 : question.initQuestion(((Tablet)((JRootPane)((JLayeredPane)((JPanel)((JTabbedPane)e.getSource())
                        //.getParent()).getParent()).getParent()).getParent()).getNiveau());
            }
        });
    }
    
    
}
