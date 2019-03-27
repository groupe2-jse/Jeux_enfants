/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Yann;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Yann Golhen
 */
public class RadioNiveau extends JPanel{

    JRadioButton bNiveau1,bNiveau2;

    public JRadioButton getbNiveau1() {
        return bNiveau1;
    }

    public JRadioButton getbNiveau2() {
        return bNiveau2;
    }
    
    public RadioNiveau() {
        
        bNiveau1 = new JRadioButton("Niveau 1",true);
        bNiveau2 = new JRadioButton("Niveau 2",false);
        
        ButtonGroup btrg = new ButtonGroup();
        btrg.add(bNiveau1);
        btrg.add(bNiveau2);
        
        TitledBorder borderNiveau = new TitledBorder("Niveau question");
        this.setBorder(borderNiveau);
        
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(bNiveau1);
        this.add(bNiveau2);
    }

}
