/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lorenzo;

import Marianne.Bouton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Lorenzo Nava-Nava
 */
public final class Calcul_Lorenzo extends JPanel{
    
    Display d;
    
    public Calcul_Lorenzo(int niveau){
        this.initCalcul(niveau);
    }
    
    public void initCalcul(int niveau)
    {
        this.removeAll();
        this.setName("Calcul");
        
        CreateOperation operation = new CreateOperation(niveau);
        d = new Display(operation);
        
        TitledBorder tb1 = new TitledBorder("");
        d.setBorder(tb1);
        
        d.getB1().addActionListener((ActionEvent e) -> {
            initCalcul(niveau);
        });
        
        //AFFICHAGE SOLUTION
        d.getB2().addActionListener((ActionEvent e) -> {
            if(!((Bouton)e.getSource()).isAlreadyHit()){
            d.getLb2().setText("  La Solution est: " + operation.toString2(operation.getOperationResult()));
            d.getCalculZone().getTextField().requestFocus();
            }
        });
        
        //VERIFICATION REPONSE EN APPUYANT SUR LE BOUTON "VERIFIER REPONSE"
        d.getB3().addActionListener((ActionEvent e) -> {
            if(operation.toString2(operation.getOperationResult()).equalsIgnoreCase(d.getCalculZone().getTextField().getText())){
                d.getLb3().setForeground(Color.green);
                d.getLb3().setText("  Réponse correcte! Bravo!");
            }
            else{
                d.getLb3().setForeground(Color.red);
                d.getLb3().setText("  Réponse fausse, oups.");
                d.getCalculZone().getTextField().requestFocus();
            }
        });
        
        //VERIFICATION REPONSE EN APPUYANT SUR "ENTREE"
        d.getCalculZone().getTextField().addActionListener((ActionEvent e) -> {
            if(operation.toString2(operation.getOperationResult()).equalsIgnoreCase(d.getCalculZone().getTextField().getText())){
                d.getLb3().setForeground(Color.green);
                d.getLb3().setText("  Réponse correcte! Bravo!");
            }
            else{
                 
                d.getLb3().setForeground(Color.red);
                d.getLb3().setText("  Réponse fausse, oups.");
                d.getCalculZone().getTextField().requestFocus();
            }
        });
        
        this.add(d); 
        
        SwingUtilities.invokeLater( new Runnable() { 
        //permet de focus la zone de texte après que tout  
            public void run() { 
                d.getCalculZone().getTextField().requestFocus(); 
            } 
        } );
    }
}
    

