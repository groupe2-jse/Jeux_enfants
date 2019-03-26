/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import javax.swing.JPanel;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public final class Calcul_Lorenzo extends JPanel{
    public Calcul_Lorenzo(int niveau){
        this.initCalcul(niveau);
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
    
    public void initCalcul(int niveau){
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
        
        this.setName("Calcul");
        CreateOperation operation = new CreateOperation(niveau);
        Display d1 = new Display(operation);
        }        
        //Display();
    }
    




