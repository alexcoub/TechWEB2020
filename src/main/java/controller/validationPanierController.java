/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connexion.ClientConnecte;
import Connexion.Panier;
import Connexion.ProduitPanier;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.dao.ProduitFacade;
import comptoirs.model.entity.Commande;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePK;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Alex
 */
@Controller
@Path("validationPanier")
@View("validationPanier.jsp")
public class validationPanierController {

    @Inject
    ClientConnecte user;
    @Inject
    Panier panier;
    @Inject
    Models models;
    @Inject
    CommandeFacade commandes;
    @Inject
    LigneFacade lignes;
    @Inject 
    ProduitFacade produits;

    @GET
    public void show() {
        models.put("user", user);
    }
Commande comValide = new Commande();
    @POST
    public String valider(
            @FormParam("port") BigDecimal port,
            @FormParam("adresse") String adresse,
            @FormParam("ville") String ville,
            @FormParam("region") String region,
            @FormParam("codePostal") String codePostal,
            @FormParam("pays") String pays,
            @FormParam("codeReduc") BigDecimal codeReduc,
            @FormParam("destinataire") String destinataire) {
        //Creer la nouvelle commande validée
        
        comValide.setSaisieLe(new Date());

        comValide.setAdresseLivraison(adresse);
        comValide.setCodePostalLivrais(codePostal);
        comValide.setDestinataire(destinataire);
        comValide.setPaysLivraison(pays);
        comValide.setPort(port);
        comValide.setRegionLivraison(region);
        comValide.setRemise(codeReduc);
        comValide.setVilleLivraison(ville);

        comValide.setClient(user.getClientC());
        //insere cette commande dans la bdd      
        commandes.create(comValide);
        //Insère les lignes de la commande dans la bdd
        for(ProduitPanier liste:user.getPanier().getListeProd()){
            int ref= produits.find(liste.getProduitSelectionne().getReference()).getReference();
            LignePK lignepk=new LignePK(comValide.getNumero(),ref);
            Ligne ligne=new Ligne(lignepk, liste.getQte());
            lignes.create(ligne);
            //On met à jour les quantités disponible et commandé
            short unitesEnStock=produits.find(ref).getUnitesEnStock();
            short unitesCommandees=produits.find(ref).getUnitesCommandees();
            unitesEnStock=(short) (unitesEnStock-liste.getQte());
            unitesCommandees=(short)(unitesCommandees+liste.getQte());
            produits.find(ref).setUnitesEnStock(unitesEnStock);
            produits.find(ref).setUnitesCommandees(liste.getQte());
        }
        commandes.edit(comValide);
        user.viderPanier();
        models.put("user",user);
        return "redirect:/commandes";

    }

}
