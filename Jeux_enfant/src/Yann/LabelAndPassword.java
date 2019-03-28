/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Yann Golhen
 */
public class LabelAndPassword extends JPanel{

   
    JLabel reponse;
    JTextField textField;

    public JTextField getTextField() {
        return textField;
    }
    
    
    public LabelAndPassword(String pReponse){
       
        reponse= new JLabel(pReponse);
        
        textField= new JPasswordField(10);
        this.setLayout(new FlowLayout());
        this.add(reponse);
        this.add(textField);
        
    }
    
    
    
}