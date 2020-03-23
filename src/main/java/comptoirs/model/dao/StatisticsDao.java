package comptoirs.model.dao;

import comptoirs.model.dto.StatsResult;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.HtmlSqlDate;

@Stateless
public class StatisticsDao {
	private static final String UNITS_SOLD = 
		"SELECT cat.libelle, SUM(li.quantite) " +
		"FROM Categorie cat " + 
		"JOIN cat.produitCollection p " + 
		"JOIN p.ligneCollection li " + 
		"GROUP BY cat.libelle";
	
	private static final String UNIT_SOLDS_DTO =
		"SELECT new comptoirs.model.dto.StatsResult" +
				        "(cat.libelle, SUM(li.quantite)) " + 
		"FROM Categorie cat " + 
		"JOIN cat.produitCollection p " + 
		"JOIN p.ligneCollection li " + 
		"GROUP BY cat.libelle";
	
	private static final String PRODUCTS_SOLDS_DTO =
		"SELECT new comptoirs.model.dto.StatsResult" +
				        "(p.nom, SUM(li.quantite)) " + 
		"FROM Produit p " +
		"JOIN p.categorie cat " +
		"JOIN p.ligneCollection li " + 
		"WHERE cat.code = :code " +
		"GROUP BY p.nom " ;
	
	@PersistenceContext(unitName = "comptoirs")
	private EntityManager em;

	public List unitesVenduesParCategorie() {
		Query query = em.createQuery(UNITS_SOLD);
		List results = query.getResultList();
		return results;
	}

	public List<StatsResult> unitesVenduesParCategorieDTO() {
		Query query = em.createQuery(UNIT_SOLDS_DTO, StatsResult.class);
		List<StatsResult> results = query.getResultList();
		return results;
	}		
	
	public List<StatsResult> produitsVendusPour(Integer codeCategorie) {
		Query query = em.createQuery(PRODUCTS_SOLDS_DTO, StatsResult.class);
		List<StatsResult> results = query.setParameter("code", codeCategorie).getResultList();
		return results;
	}
        
        public HtmlSqlDate datePlusRecenteCommande() {
            Date result = em.createQuery("select max(c.saisieLe) from Commande c", Date.class)
            .getSingleResult();
            return new HtmlSqlDate(result);
        }
        
        public Date datePlusAncienneCommande() {
            Date result =  em.createQuery("select min(c.saisieLe) from Commande c", Date.class)
            .getSingleResult();
            return new HtmlSqlDate(result);
        }

        public List<Integer> commandesEntre(Date minDate, Date maxDate) {
            return em.createQuery("select c.numero from Commande c where c.saisieLe between :minDate and :maxDate", Integer.class)
                    .setParameter("minDate", minDate)
                    .setParameter("maxDate", maxDate)
                    .getResultList();
        }
}
