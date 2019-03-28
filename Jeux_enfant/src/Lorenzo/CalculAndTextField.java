/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import java.awt.BorderLayout;
import java.awt.Font;
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
    Font font;
    public CalculAndTextField(String calcul, int size, Font font){
        this.font = font;
        this.calcul= new JLabel(calcul);
        this.calcul.setFont(font);
        this.textField= new JTextField(size);
        this.textField.setFont(font);
        this.setLayout(new BorderLayout());
        this.add(this.calcul, BorderLayout.WEST);
        this.add(this.textField, BorderLayout.EAST);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
    
}
