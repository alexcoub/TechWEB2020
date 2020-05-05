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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Alex
 */

public class Panier{
    ArrayList<ProduitPanier> listeProd=new ArrayList<ProduitPanier>();

    public ArrayList<ProduitPanier> getListeProd() {
        return listeProd;
    }

    public void setListeProd(ArrayList<ProduitPanier> listeProd) {
        this.listeProd = listeProd;
    }

    public Panier() {
        listeProd=new ArrayList<ProduitPanier>();
    }

    
    
    

    

    

}
