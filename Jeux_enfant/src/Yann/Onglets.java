/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Lorenzo.Calcul_Lorenzo;
import Marianne.Draw_Marianne;
import javax.swing.JFrame;
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
    
    public Onglets(int niveau) {
        
        Draw_Marianne draw = new Draw_Marianne();
        Calcul_Lorenzo calcul = new Calcul_Lorenzo(niveau);
        Question_zine question = new Question_zine();
        this.add(draw);
        this.add(calcul);
        this.add(question);
        this.addChangeListener((ChangeEvent e) -> {
            chosen = this.getSelectedIndex();
            switch (chosen){
                case 0 : draw.initDraw();break;
                case 1 : calcul.initCalcul(((Tablet)((JRootPane)((JLayeredPane)((JPanel)((JTabbedPane)e.getSource())
                        .getParent()).getParent()).getParent()).getParent()).getNiveau());
                case 2 : question.initQuestion(((Tablet)((JRootPane)((JLayeredPane)((JPanel)((JTabbedPane)e.getSource())
                        .getParent()).getParent()).getParent()).getParent()).getNiveau());
            }
        });
    }
    
    
}
