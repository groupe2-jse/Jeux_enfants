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
            case 1://Addition et soustraction à 1 chiffre random
                num1=GenerateRandomNumbers(1);
                operand=GenerateRandomOperand(1);
                if(operand=='-'){//cas soustraction
                    num2=GenerateAlternativeSecondRandomNumbers();
                    operationResult=num1-num2;
                }
                else{//cas addition
                    num2=GenerateRandomNumbers(1);
                    operationResult=num1+num2;
                }
                calcul=toString();
            break;
            
            case 2://Addition et soustraction à 3 chiffres max ou multiplication à 1 chiffre
                operand=GenerateRandomOperand(2);
        switch (operand) {
            case '-'://cas soustraction
                num1=GenerateRandomNumbers(2);
                num2=GenerateRandomNumbers(2);
                operationResult=num1-num2;
                break;
            case 'x'://cas multiplication
                num1=GenerateRandomNumbers(1);
                num2=GenerateRandomNumbers(1);
                operationResult=num1*num2;
                break;
            default://cas d'addition
                num1=GenerateRandomNumbers(2);
                num2=GenerateRandomNumbers(2);
                operationResult=num1+num2;
                break;
        }
        calcul=toString();
            
    }
    }
    
    //afficher le resultat de l'operation
    public int getOperationResult() {
        return operationResult;
    }
    
    //stocker le resultat
    public void setOperationResult(int operationResult) {
        this.operationResult = operationResult;
    }
    
    //afficher le calcul
    public String getCalcul() {
        return calcul;
    }

    //stocker le calcul
    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }
    
    //nombre random en fonction du niveau
    public int GenerateRandomNumbers(int niveau){
        int num=0;
        switch(niveau){
            case 1://cas niveau 1
                num=rd.nextInt(8)+1;
            break;
            
            case 2://cas niveau 2
                num=rd.nextInt(998)+1;
            break;
        }
        return num;
    }
    
    
    //2eme nombre random si soustraction niveau 1
    public int GenerateAlternativeSecondRandomNumbers(){
        int num=rd.nextInt(this.num1)+1;
        return num;
    }
    
    //Operateur random en fonction du niveau
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
        return(" " + num1 + " " + operand + " " + num2 + " = ");
    }
    public String toString2(int machin){
        return ("" + machin);
    }
}
