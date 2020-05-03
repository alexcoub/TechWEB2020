/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connexion.ClientConnecte;
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import java.util.List;
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
    ClientConnecte user;

    @Inject
    Models models;

    /*public String show(
            @QueryParam("userName") String identifiant,
            @QueryParam("userMdp") String motDePasse) {

        //Récupérer les champs entrés par l'utilisateur
        String loginParam = identifiant;
        String mdpParam = motDePasse;
        
        //Vérifier que l'utilisateur a bien renseigné tous les champs
        if(!loginParam.equals("") && !mdpParam.equals("")){
            //Trouver les informations de l'utilisateur dans la table Client
            Client c = client.find(mdpParam);
          
            
            //Vérifier que la combinaiason login/mdp correspond à la combinaison contact/code
            if(identifiant.equals(loginParam) && motDePasse.equals(mdpParam)) { 
                //Supprimer l'utilisateur actuel (déconnexion)
                user.login(c);
                
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
    }*/
    @GET
    public String login(
            @QueryParam("userName") String name,
            @QueryParam("userMdp") String mdp
    ) {
        Client u = client.find(mdp);
        String redirect = "erreurCo.jsp";
        if (name.equals(u.getContact())) {
            user.login(u);
            redirect = "redirect:/client";
        }
        return redirect;
    }
    
    

   /* public String logOut() {
        user.logout();
        return "redirect:/connexion";

    }*/

}
