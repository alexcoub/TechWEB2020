/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import comptoirs.model.entity.Produit;


/**
 *
 * @author Alex
 */
public class ProduitPanier {
    Produit produitSelectionne;
    short qte;

    public Produit getProduitSelectionne() {
        return produitSelectionne;
    }

    public void setProduitSelectionne(Produit produitSelectionne) {
        this.produitSelectionne = produitSelectionne;
    }

    public short getQte() {
        return qte;
    }

    public void setQte(short qte) {
        this.qte = qte;
    }

    public ProduitPanier(Produit produitSelectionne, short qte) {
        this.produitSelectionne = produitSelectionne;
        this.qte = qte;
    }
    
    
    
}
