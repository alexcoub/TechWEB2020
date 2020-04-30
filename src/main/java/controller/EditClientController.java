package controller;

import comptoirs.model.dao.ClientFacade;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import comptoirs.model.entity.Client;
import javax.mvc.View;
import javax.mvc.binding.BindingResult;
import javax.persistence.EntityManager;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.FormParam;

@Controller
@Path("editClient")
@View("editClient.jsp")
//@TransactionManagement(TransactionManagementType.BEAN)
public class EditClientController {

    @Inject
    ClientFacade dao;
    
    @Inject
    EntityManager em;

    @Inject
    BindingResult formValidationErrors;

    @Inject
    Models models;

    @GET
    public void show() {
        models.put("clients", dao.find("BOTTM"));
    }

    @POST
    @ValidateOnExecution(type = ExecutableType.ALL)
    public String modifier(
            @FormParam("codeClient") String codeClient,
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
        Client client = dao.find("BOTTM");
        if (adresse != null) {
            client.setAdresse(adresse);
        }

        if (codePostal != null) {
            client.setCodePostal(codePostal);
        }

        if (contact!= null) {
            client.setContact(contact);
        }

        if (fax != null) {
            client.setFax(fax);
        }

        if (fonction != null) {
            client.setFonction(fonction);
        }

        if (pays != null) {
            client.setPays(pays);
        }

        if (region != null) {
             client.setRegion(region);
        }

        if (societe != null) {
            client.setSociete(societe);
        }

        if (telephone!= null) {
            client.setTelephone(telephone);
        }
        
        if (ville!= null) {
            client.setVille(ville);
        }

        
        
        
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();

        return "redirect:/editClient";
    }
}
