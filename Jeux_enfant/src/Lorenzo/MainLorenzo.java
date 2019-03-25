/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public class MainLorenzo {
    
    public static void main(String[] args) {
        CalculNiveau1_Lorenzo c = new CalculNiveau1_Lorenzo();
        //System.out.println(c.getCalcul());
        JFrame jf = new JFrame("Calcul");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel jp1 = new CalculAndTextField(c.getCalcul(), 2);
        c.add(jp1);
        jf.add(c);
        jf.pack();
        jf.setVisible(true);
        
    }
}
