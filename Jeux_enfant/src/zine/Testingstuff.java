/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zine;

import javax.swing.JFrame;

    
 import java.awt.*;
import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
public class Testingstuff extends JFrame{
    private JLabel theBox;
     private JTextField   theBox2;
    private String str;
     private JPanel pan = new JPanel();
    private JButton bouton = new JButton("question suivante");
    public Testingstuff(){
        super("question");
        setLayout(new FlowLayout());  
        JPanel box= new JPanel();
        theBox = new JLabel();
        theBox2 = new JTextField(20);
        pan.add(bouton);
        this.setContentPane(pan);
        this.setVisible(true);
        add(theBox);
        add(theBox2);
        HandlerClass handler = new HandlerClass();
        theBox2.addActionListener(handler);
    }
     
    private class HandlerClass implements ActionListener{
        public void actionPerformed(ActionEvent e){
            str = e.getActionCommand(); //This is what I mean by storing.
            // now I want 3 variables, collecting data from 3 textbox
            // at the same time. Please help?
             
            // This is how I can print out in GUI:
            JOptionPane.showMessageDialog(null, str);
        }   }   
  

    private static 

    public static void main(String[]args){      
        Testingstuff t = new Testingstuff();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setSize(350,100);
        t.setVisible(true);
       
    }   }




