/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import Lorenzo.Calcul_Lorenzo;
import Marianne.Draw_Marianne;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import zine.Question_zine;

/**
 *
 * @author Yann Golhen
 */
public class Onglets extends JTabbedPane{

    int chosen;
    
    public Onglets() {
        
        this.add(new Draw_Marianne());
        this.add(new Calcul_Lorenzo(1));
        System.out.print((JPanel)this.getParent());
        this.add(new Question_zine());
        this.addChangeListener((ChangeEvent e) -> {
            chosen = this.getSelectedIndex();
        });
    }
    
    
}
