/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ulyss
 */
@Controller
@Path("accueil")
@View("accueil.jsp")
public class AccueilController {
    
    @Inject
    ClientFacade client;
    
    @GET
    public void show(@QueryParam("id") String identifiant,
            @QueryParam("pw") String motDePasse) {
       
        String loginParam = identifiant;
        String mdpParam = motDePasse;
        
        if(!loginParam.equals("") && !mdpParam.equals("")){
            Client c = client.find(loginParam);
            
            String mdp = c.getCode();
            String societe = c.getSociete();
            String login = c.getContact();
            String fonction = c.getFonction();
            String adresse = c.getAdresse();
            String ville = c.getVille();
            String codepostal = c.getCodePostal();
            String pays = c.getPays();
            String telephone = c.getTelephone();
            String fax = c.getFax();
            
            if(login.equals(loginParam) && mdp.equals(mdpParam)) {
                
            }
        }
    }
    
}