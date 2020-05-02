/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
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
    
    //DAO
    @Inject
    ClientFacade client;
    
    
    @Inject
    Models models;

    @GET
    public String show(
            @QueryParam("id") String identifiant,
            @QueryParam("pw") String motDePasse) {

        //Récupérer les champs entrés par l'utilisateur
        String loginParam = identifiant;
        String mdpParam = motDePasse;
        
        //Vérifier que l'utilisateur a bien renseigné tous les champs
        if(!loginParam.equals("") && !mdpParam.equals("")){
            //Trouver les informations de l'utilisateur dans la table Client
            Client c = client.find(mdpParam);

            //Enregistrer ses informations dans des variables locales
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
            
            //Vérifier que la combinaiason login/mdp correspond à la combinaison contact/code
            if(login.equals(loginParam) && mdp.equals(mdpParam)) { 
                //Supprimer l'utilisateur actuel (déconnexion)
                logOut();
                
                //Envoyer le contact à la vue
                models.put("contact", identifiant);

                //Renseigner toutes les informations de l'utilisateur actuel
               
                 //Vérifier si c'est un client ou l'administrateur qui s'est connecté
                if(login.equals("Administrateur")) {
                    return "admin.jsp";
                }
                else{
                    return "accueil.jsp";
                }
            }
            else {
                return "redirect:/index.html";
            }
        }
        else {
            return "redirect:/index.html";
        }
    }
    
    public void logOut() {
       
    }
    
}