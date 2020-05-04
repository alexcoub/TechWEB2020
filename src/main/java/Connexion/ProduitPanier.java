/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;


/**
 *
 * @author Alex
 */
public class ProduitPanier {
    int produitSelectionne;
    short qte;

    public int getProduitSelectionne() {
        return produitSelectionne;
    }

    public void setProduitSelectionne(int produitSelectionne) {
        this.produitSelectionne = produitSelectionne;
    }

    public short getQte() {
        return qte;
    }

    public void setQte(short qte) {
        this.qte = qte;
    }

    public ProduitPanier(int produitSelectionne, short qte) {
        this.produitSelectionne = produitSelectionne;
        this.qte = qte;
    }
    
    
    
}
