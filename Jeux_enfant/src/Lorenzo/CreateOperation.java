/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import java.util.Random;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public final class CreateOperation {
    public int num1;
    public int num2;
    public int operationResult;
    public String result;
    public char operand;
    public String calcul;
    public Random rd = new Random();
            
    public CreateOperation(int niveau){
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
            
    }
    }

    public int getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(int operationResult) {
        this.operationResult = operationResult;
    }
    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }
    
    public int GenerateRandomNumbers(int niveau){
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
    public int GenerateAlternativeSecondRandomNumbers(){
        int num=rd.nextInt(this.num1)+1;
        return num;
    }
    
    public char GenerateRandomOperand(int niveau){
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
    @Override
    public String toString(){
        return(num1 + " " + operand + " " + num2 + " = ");
    }
    public String toString2(int machin){
        return ("" + machin);
    }
}
