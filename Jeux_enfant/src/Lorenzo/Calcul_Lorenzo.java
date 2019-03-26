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
public final class Calcul_Lorenzo extends JPanel{
    private int num1;
    private int num2;
    private int operationResult;
    private char operand;
    private String calcul;
    private Random rd = new Random();

    
    
    public Calcul_Lorenzo(int niveau){
        this.initCalcul(niveau);
    }
    
    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }
    
    private int GenerateRandomNumbers(int niveau){
        int num=0;
        switch(niveau){
            case 1:
                num=rd.nextInt(8)+1;
            break;
            
            case 2:
                num=rd.nextInt(998)+1;
            break;
        }
        return num;
    }
    private int GenerateAlternativeSecondRandomNumbers(){
        int num=rd.nextInt(this.num1)+1;
        return num;
    }
    
    private char GenerateRandomOperand(int niveau){
        int choixOperand=0;
        switch(niveau){ 
            case 1:
                choixOperand = rd.nextInt(2);
                if(choixOperand==1){
                    return '-';
                }
                else{
                    return '+';
                } 
            case 2:
                choixOperand = rd.nextInt(3);
                if(choixOperand==1){
                    return '-';
                }
                else if(choixOperand==2){
                    return '+';
                }
                else{
                    return 'x';
                }      
        }
        return 0;
    }
    
    private void initCalcul(int niveau){
        this.setName("Calcul");
        switch(niveau){
            case 1:
                num1=GenerateRandomNumbers(1);
                operand=GenerateRandomOperand(1);
                if(operand=='-'){
                    num2=GenerateAlternativeSecondRandomNumbers();
                    operationResult=num1-num2;
                }
                else{
                    num2=GenerateRandomNumbers(1);
                    operationResult=num1+num2;
                }
                calcul=toString();
            break;
            
            case 2:
                operand=GenerateRandomOperand(2);
        switch (operand) {
            case '-':
                num1=GenerateRandomNumbers(2);
                num2=GenerateRandomNumbers(2);
                operationResult=num1-num2;
                break;
            case 'x':
                num1=GenerateRandomNumbers(1);
                num2=GenerateRandomNumbers(1);
                operationResult=num1*num2;
                break;
            default:
                num1=GenerateRandomNumbers(2);
                num2=GenerateRandomNumbers(2);
                operationResult=num1+num2;
                break;
        }
                calcul=toString();
            break;  
        }        
        
    }
    @Override
    public String toString(){
        return(num1 + " " + operand + " " + num2 + " = ");
    }
}



