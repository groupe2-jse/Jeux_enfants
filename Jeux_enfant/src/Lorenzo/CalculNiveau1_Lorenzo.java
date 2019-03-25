/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public class CalculNiveau1_Lorenzo extends JPanel{
    private int num1;
    private int num2;
    private char operand;
    private String calcul;
    private Random rd = new Random();

    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }
    
    public CalculNiveau1_Lorenzo(){
        num1=GenerateRandomNumbers();
        operand=GenerateRandomOperand();
        if(operand=='-'){
            num2=GenerateAlternativeSecondRandomNumbers();
        }
        else{
            num2=GenerateRandomNumbers();
        }
        calcul=toString();
        this.setName("Calcul niveau 1");
    }
    private int GenerateRandomNumbers(){
        int num=rd.nextInt(8)+1;
        return num;
    }
    private int GenerateAlternativeSecondRandomNumbers(){
        int num=rd.nextInt(this.num1)+1;
        return num;
    }
    
    private char GenerateRandomOperand(){
        int choixOperand = rd.nextInt(2);
        if(choixOperand==1){
            return '-';
        }
        else{
            return '+';
        }
    }
    
    public String CreateCalcul(int num1,int num2, char operand){
        
        return calcul;
    }
    
    
    @Override
    public String toString(){
        return(num1 + " " + operand + " " + num2 + " = ");
    }
}



