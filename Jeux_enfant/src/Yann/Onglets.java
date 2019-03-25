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

    public Onglets() {
        
        this.add(new Draw_Marianne());
        this.add(new Calcul_Lorenzo());
        this.add(new Question_zine());
        
        
    }
    

    
    
}
