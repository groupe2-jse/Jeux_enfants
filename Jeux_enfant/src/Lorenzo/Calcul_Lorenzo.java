/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public class Calcul_Lorenzo extends JFrame{
    public int num1;
    public int num2;
    public char operand;
    public String calcul;
    public Random rd = new Random();
    
    public void GenerateRandomNumbers(){
        this.num1=rd.nextInt(8)+1;
        this.num2=rd.nextInt(8)+1;
    }
    
    JPanel calculAndAnswer = new CalculAndTextField(calcul, WIDTH);
}

