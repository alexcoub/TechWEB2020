/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePK;
import comptoirs.model.entity.Produit;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Alex
 */
@SessionScoped
@Named("panier")
public class Panier extends Commande{
    
    @Inject
    CommandeFacade commandes;
    
    @Inject
    ProduitFacade produits;
    
    @Inject
    LigneFacade lignes;
    
    List<Ligne> mesLignes;
    
    int Id = commandes.findAll().get(commandes.findAll().size()-1).getNumero()+1;
    Commande commande=new Commande(Id);
    
    public void ajouterLigne(Produit prod, short qte){
        LignePK lignePKA= new LignePK(Id, prod.getReference());
        Ligne ligneA=new Ligne(lignePKA, qte);
        mesLignes.add(ligneA);
        
        
        
    }
    
    public void retirerLigne(Ligne ligneR){
        mesLignes.remove(ligneR);
    }

    public CommandeFacade getCommandes() {
        return commandes;
    }

    public void setCommandes(CommandeFacade commandes) {
        this.commandes = commandes;
    }

    public ProduitFacade getProduits() {
        return produits;
    }

    public void setProduits(ProduitFacade produits) {
        this.produits = produits;
    }

    public LigneFacade getLignes() {
        return lignes;
    }

    public void setLignes(LigneFacade lignes) {
        this.lignes = lignes;
    }

    public List<Ligne> getMesLignes() {
        return mesLignes;
    }

    public void setMesLignes(List<Ligne> mesLignes) {
        this.mesLignes = mesLignes;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    

    
    
    
}
