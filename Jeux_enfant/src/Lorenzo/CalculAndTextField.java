/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public class CalculAndTextField extends JPanel{
    JLabel calcul;
    JTextField textField;
    
    public CalculAndTextField(String calcul, int size){
        this.calcul= new JLabel(calcul);
        this.textField= new JTextField(size);
        this.setLayout(new BorderLayout());
        this.add(this.calcul, BorderLayout.WEST);
        this.add(this.textField, BorderLayout.EAST);
    }
}
