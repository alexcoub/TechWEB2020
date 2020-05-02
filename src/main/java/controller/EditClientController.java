package controller;

import Connexion.ClientConnecte;
import comptoirs.model.dao.ClientFacade;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import comptoirs.model.entity.Client;
import java.util.List;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;

@Controller
@Path("client")
@View("editClient.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class EditClientController {
    
    @Inject
    ClientConnecte user;
    @Inject
    ClientFacade dao;


    @Inject
    Models models;

    String c = "BOTTM";

    @GET
    public void show() {

        models.put("clients", user.getClientC());
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public void modifier(
            @FormParam("societe") String societe,
            @FormParam("contact") String contact,
            @FormParam("fonction") String fonction,
            @FormParam("adresse") String adresse,
            @FormParam("ville") String ville,
            @FormParam("region") String region,
            @FormParam("codePostal") String codePostal,
            @FormParam("pays") String pays,
            @FormParam("telephone") String telephone,
            @FormParam("fax") String fax
    ) {
       
        Client client = user.getClientC();

        client.setAdresse(adresse);
        client.setCodePostal(codePostal);
        client.setContact(contact);
        client.setFax(fax);
        client.setFonction(fonction);
        client.setPays(pays);
        client.setRegion(region);
        client.setSociete(societe);
        client.setTelephone(telephone);
        client.setVille(ville);

        dao.edit(client);
        models.put("clients", user.getClientC());

    }
}
