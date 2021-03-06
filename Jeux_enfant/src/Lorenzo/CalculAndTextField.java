/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public class CalculAndTextField extends JPanel{
    JLabel calcul;
    JTextField textField;
    Font font;
    
    //CREATION ZONE D'AFICHAGE DU CALCUL ET DE ZONE DE SAISIE
    public CalculAndTextField(String calcul, int size, Font font){
        this.font = font;
        this.calcul= new JLabel(calcul);
        TitledBorder tb1 = new TitledBorder("");
        this.calcul.setBorder(tb1);
        this.calcul.setFont(font);
        this.calcul.setBorder(BorderFactory.createBevelBorder(2));
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
