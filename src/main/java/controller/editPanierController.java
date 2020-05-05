/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connexion.ClientConnecte;
import Connexion.ProduitPanier;
import comptoirs.model.dao.CommandeFacade;
import comptoirs.model.dao.ProduitFacade;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Alex
 */
@Controller
@Path("editPanier")
@View("editPanier.jsp")
public class editPanierController {
    @Inject
    ClientConnecte user;
    @Inject
    ProduitFacade produitFacade;
    @Inject
    CommandeFacade commandeFacade;
    @Inject
    Models models;
    
    @GET
    public void show(){
        models.put("user", user);
    }
    
    @POST
    public void changerQte(
            @FormParam("quantite")short quantite,
            @FormParam("reference") int reference
            ){
        
        for(ProduitPanier p:user.getPanier().getListeProd()){
            if(p.getProduitSelectionne().getReference()==reference){
                p.setQte(quantite);
                if (quantite==0){
                    user.getPanier().getListeProd().remove(p);
                }
            }
        }
        models.put("user",user);
            
        
    }
    
}
