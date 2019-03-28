/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import Marianne.Bouton;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public final class Calcul_Lorenzo extends JPanel{
    public Calcul_Lorenzo(int niveau){
        this.initCalcul(niveau);
    }
    
    public void initCalcul(int niveau)
    {
        this.removeAll();
        this.setName("Calcul");
        CreateOperation operation = new CreateOperation(niveau);
        Display d = new Display(operation);
        d.getB1().addActionListener((ActionEvent e) -> {
            initCalcul(niveau);
        });
        d.getB2().addActionListener((ActionEvent e) -> {
            if(!((Bouton)e.getSource()).isAlreadyHit()){
            d.getLb2().setText("La Solution est: " + operation.toString2(operation.getOperationResult()));
            }
        });
        d.getB3().addActionListener((ActionEvent e) -> {
            //System.out.println(operation.toString2(operation.getOperationResult()));
            if(operation.toString2(operation.getOperationResult()).equalsIgnoreCase(d.getCalculZone().getTextField().getText())){
                d.getLb3().setText("Réponse correcte! Bravo!");
            }
            else{
                d.getLb3().setText("Réponse fausse, oups.");
            }
        });
        d.getCalculZone().getTextField().addActionListener((ActionEvent e) -> {
            //System.out.println(operation.toString2(operation.getOperationResult()));
            if(operation.toString2(operation.getOperationResult()).equalsIgnoreCase(d.getCalculZone().getTextField().getText())){
                d.getLb3().setText("Réponse correcte! Bravo!");
                d.getCalculZone().getTextField().addActionListener((ActionEvent e2) -> {
                    initCalcul(niveau);
                });
            }
            else{
                d.getLb3().setText("Réponse fausse, oups.");
            }
        });
        this.add(d);        
    }
}


