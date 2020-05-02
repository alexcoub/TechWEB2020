/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Panier extends Commande{
    private Commande panierC;
    private List<Ligne> liste; 

    public Panier() {
    }

    public Panier(Integer numero) {
        super(numero);
    }

    public Panier(Integer numero, Date saisieLe, BigDecimal remise) {
        super(numero, saisieLe, remise);
    }
    
    
}
