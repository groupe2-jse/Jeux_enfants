/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zine;

import java.awt.BorderLayout;
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
    
    
    public LabelAndField(String reponse){
       
        this.reponse= new JLabel(reponse);
        
        this.textField= new JTextField(size);
        
        this.setLayout(new BorderLayout());
        this.add(this.reponse, BorderLayout.WEST);
        this.add(this.textField, BorderLayout.EAST);
    }
    
}
