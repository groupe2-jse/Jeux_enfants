/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Lorenzo.Calcul_Lorenzo;
import Marianne.Draw_Marianne;
import javax.swing.JTabbedPane;
import zine.Question_zine;

/**
 *
 * @author Yann Golhen
 */
public class Onglets extends JTabbedPane{

    
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
        question = new Question_zine(niveau);
        this.add(draw);
        this.add(calcul);
        this.add(question);
        
    }
    
    
}
