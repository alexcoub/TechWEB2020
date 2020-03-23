package controller;

import comptoirs.model.dao.StatisticsDao;
import comptoirs.model.entity.Categorie;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



@Controller
@Path("listeCommandes")
@View("listeCommandes.jsp")
public class ListeCommandeController {
	@Inject // Le DAO généré par netBeans
	StatisticsDao dao;

	@Inject
	Models models;

	@GET
	public void show() {
                Date min = dao.datePlusAncienneCommande();
                Date max = dao.datePlusRecenteCommande();
		models.put("minDate", min);
		models.put("maxDate", max);                
	}
}
