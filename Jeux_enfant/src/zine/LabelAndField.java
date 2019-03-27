/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author stagldnr
 */
public class LabelAndField extends JPanel{
    
    JLabel reponse;
    JTextField textField;

    public JTextField getTextField() {
        return textField;
    }
    
    
    public LabelAndField(String pReponse){
       
        reponse= new JLabel(pReponse);
        
        textField= new JTextField(20);
        //textField.setPreferredSize(new Dimension(2,2));
        
        this.setLayout(new BorderLayout());
        this.add(reponse, BorderLayout.WEST);
        this.add(textField, BorderLayout.EAST);
    }
    
    
    
}
