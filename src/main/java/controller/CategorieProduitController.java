package controller;

import Connexion.ClientConnecte;
import Connexion.Panier;
import Connexion.ProduitPanier;
import comptoirs.model.dao.CategorieFacade;
import comptoirs.model.dao.LigneFacade;
import comptoirs.model.dao.ProduitFacade;
import java.util.List;

import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import comptoirs.model.entity.Categorie;
import comptoirs.model.entity.Ligne;
import comptoirs.model.entity.LignePK;
import comptoirs.model.entity.Produit;
import java.util.ArrayList;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

@Controller
@Path("categorieProduits")
@View("categorieProduits.jsp")
public class CategorieProduitController {

    @Inject
    CategorieFacade facade;
    @Inject
    Models models;
    @Inject
    ClientConnecte user;
    @Inject
    ProduitFacade produits;

    @GET
    public void produitsParCategorie(@QueryParam("code") Integer codeCategorie) {
        // On cherche la liste des catégories pour l'afficher dans la liste de choix
        final List<Categorie> touteslesCategories = facade.findAll();

        // On cherche la catégorie à partir de son code passé en paramètre
        Categorie categorieChoisie;
        if (codeCategorie != null) // Est-ce qu'on a un paramètre ?
        // On va chercher la catégorie 
        {
            categorieChoisie = facade.find(codeCategorie); // Et si on ne trouve pas ?
        } else // On prend la première de la liste (encore faut-il qu'il y en ait une !)
        {
            categorieChoisie = touteslesCategories.get(0);
        }

        // On transmet les informations à la vue
        models.put("categories", touteslesCategories);
        models.put("selected", categorieChoisie);

    }
    ArrayList<ProduitPanier> o = new ArrayList<ProduitPanier>();
    Panier p = new Panier();
    @POST
    public String ajouterProduit(
            @FormParam("quantite") short quantite,
            @FormParam("reference") int reference
    ) {
        ProduitPanier e = new ProduitPanier(reference, quantite);

        o.add(e);
        p.setListeProd(o);
        user.setPanier(p);

        return "redirect:/validationPanier";

    }

}
