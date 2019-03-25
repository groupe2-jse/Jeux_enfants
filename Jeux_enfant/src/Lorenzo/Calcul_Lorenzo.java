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
public class Calcul_Lorenzo extends JPanel{
    private int num1;
    private int num2;
    private char operand;
    private String calcul;
    private Random rd = new Random();

    
    
    public Calcul_Lorenzo(int niveau){
        this.setName("Calcul");
        
        switch(niveau){
            case 1:
                num1=GenerateRandomNumbers(1);
                operand=GenerateRandomOperand(1);
                if(operand=='-'){
                    num2=GenerateAlternativeSecondRandomNumbers(1);
                }
                else{
                    num2=GenerateRandomNumbers(1);
                }
                calcul=toString();
            break;
            
            case 2:
                
            break; 
        }        
        
    }
    
    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }
    
    private int GenerateRandomNumbers(int niveau){
        int num=rd.nextInt(8)+1;
        return num;
    }
    private int GenerateAlternativeSecondRandomNumbers(int niveau){
        int num=rd.nextInt(this.num1)+1;
        return num;
    }
    
    private char GenerateRandomOperand(int niveau){
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



