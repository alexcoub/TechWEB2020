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

    @GET
    public void show() {
        models.put("user", user);
    }

    @POST
    public void valider(
            @FormParam("port") BigDecimal port,
            @FormParam("adresse") String adresse,
            @FormParam("ville") String ville,
            @FormParam("region") String region,
            @FormParam("codePostal") String codePostal,
            @FormParam("pays") String pays,
            @FormParam("codeReduc") BigDecimal codeReduc,
            @FormParam("destinataire") String destinataire) {
        //Creer la nouvelle commande validée
        Commande comValide = new Commande();
        
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
            LignePK lignepk=new LignePK(comValide.getNumero(), liste.getProduitSelectionne());
            Ligne ligne=new Ligne(lignepk, liste.getQte());
            lignes.create(ligne);
        }
        user.viderPanier();

    }

}