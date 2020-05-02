/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Connexion.ClientConnecte;
import comptoirs.model.dao.ClientFacade;
import comptoirs.model.entity.Client;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author Alex
 */
@Controller
@Path("connexion") // Le chemin d'accès au contrôleur
@View("connexion.jsp") // La vue qui affiche le résultat
public class ConnexionController {

    @Inject
    ClientFacade client;

    @Inject
    ClientConnecte user;

    @GET
    public void show() {
        System.out.println("controller.ConnexionController.show()");
    }

    @POST
    public String login(
            @FormParam("userName") String name,
            @FormParam("userMdp") String mdp
    ) {
        Client u = client.find(mdp);
        String redirect= "erreurCo.jsp";
        if (name.equals(u.getContact())) {
            user.login(u);
            redirect= "redirect:/client";
        }
        return redirect;

    }

}
