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
    
    public void initCalcul(int niveau)
    {
        this.removeAll();
        this.setName("Calcul");
        this.add(new Display(new CreateOperation(niveau)));
    }
}


