/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zine;

import Pkg_DAO.Question_Julien;
import javax.swing.JFrame;

    
 import java.awt.*;
import java.awt.event.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
 
public class Testingstuff extends JFrame{
    private JLabel theBox;
     private JTextField   theBox2;
    private String str;
     private JPanel pan = new JPanel();
    private JButton bouton = new JButton("question suivante");
    String text;
    
    public Testingstuff(){
        super("question");
        text = textQuestion();
        
        setLayout(new FlowLayout());  
        JPanel box= new JPanel();
        theBox = new JLabel(text);
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
        @Override
        public void actionPerformed(ActionEvent e){
            str = e.getActionCommand(); //This is what I mean by storing.
            // now I want 3 variables, collecting data from 3 textbox
            // at the same time. Please help?
             
            // This is how I can print out in GUI:
            //JOptionPane.showMessageDialog(null, str);
            
        String text = "";
        Question_Julien daop = new Question_Julien();
        Question a = daop.find(1);
        text = a.getReponse();
        
        if(str.equals(text))
        {
            JOptionPane.showMessageDialog(null
                    ,"C'est juste bien joué"
                    ,"Bravo!"
                    ,JOptionPane.ERROR_MESSAGE);
        }
        
        else
        {
            JOptionPane.showMessageDialog(null
                    ,"C'est faux"
                    ,"BOUH"
                    ,JOptionPane.ERROR_MESSAGE);
        }
            
        }   }   
  

    private static String textQuestion()
    {
        String text = "";
        Question_Julien daop = new Question_Julien();
        Question a = daop.find(1);
        text = a.getQuestions();
        return text;
    }
    private static int ChoixQuestion()
    {
        int nbr;
        int choixNiveau = 1;
        
        Random r = new Random();
        int nb = r.nextInt((9 - 0) + 1) + 0;
        Question_Julien daop = new Question_Julien();
        Question a = daop.find(nb);
        nbr = a.getNiveau_question();
        if(nbr != choixNiveau)
        {
            return ChoixQuestion();
        }
        
        
        return nbr;
    }

public static void main(String[]args){      
        Testingstuff t = new Testingstuff();
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.setSize(350,100);
        t.setVisible(true);
       
    }   
}




