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

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
