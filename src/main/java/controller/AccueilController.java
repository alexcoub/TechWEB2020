/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comptoirs.model.dao.ClientFacade;
import comptoirs.model.dao.UtilisateurFacade;
import comptoirs.model.entity.Client;
import comptoirs.model.entity.Utilisateur;
import java.sql.Connection;
import java.sql.Statement;
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
    UtilisateurFacade user;
    
    @Inject
    Models models;
    
    static Connection cnx;
    static Statement st;
    
    @GET
    public void show(@QueryParam("id") String identifiant,
            @QueryParam("pw") String motDePasse) {
       
        //Envoyer le contact à la vue
        models.put("contact", identifiant);
        
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
                
                //Créer un nouvel utilisateur
                Utilisateur u = new Utilisateur(mdp);
                //Renseigner toutes les informations de l'utilisateur actuel
                u.setSociete(societe);
                u.setContact(login);
                u.setFonction(fonction);
                u.setAdresse(adresse);
                u.setVille(ville);
                u.setCodePostal(codepostal);
                u.setPays(pays);
                u.setTelephone(telephone);
                u.setFax(fax);
                
                user.create(u);
            }
        }
    }
    
    public void logOut() {
        //Vider la table utilisateur
        List<Utilisateur> lu = user.findAll();
        for(Utilisateur u : lu) {
            user.remove(u);
        }
    }
    
}