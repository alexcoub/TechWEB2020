package service;

import comptoirs.model.dao.StatisticsDao;
import comptoirs.model.dto.StatsResult;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import util.HtmlSqlDate;

@Path("service")
public class StatisticsService {

	@Inject
	StatisticsDao dao;

	@GET
	@Path("unitesVendues/categories")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult> unitesVenduesJSON() {
		return dao.unitesVenduesParCategorieDTO();
	}

	@GET
	@Path("unitesVendues/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StatsResult> produitsVendus(@QueryParam("code") Integer codeCategorie) {
		return dao.produitsVendusPour(codeCategorie);
	}

        @Path("ChiffreaffaireDate")
        @Produces(MediaType.APPLICATION_JSON)
        public List<StatsResult> chiffreAffaireCategorieDate(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate){
            return dao.chiffreAffaireClientDTO_DATE(minDate, maxDate);
        }
        
        @GET
        @Path("chiffreaffairepays")
        @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
        public List<StatsResult> chiffreAffaireParPays(){
            return dao.chiffreAffaireParPaysDTO();
        }

        @GET
        @Path("chiffreaffairepaysDate")
        @Produces(MediaType.APPLICATION_JSON)
        public List<StatsResult> chiffreAffairePaysDate(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate){
            return dao.chiffreAffairePaysDTO_DATE(minDate, maxDate);
        }
        
        @GET
        @Path("chiffreaffaireclient")
        @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
        public List<StatsResult> chiffreAffaireClient(){
            return dao.chiffreAffaireClientDTO();
        }
        
        @GET
        @Path("chiffreaffaireclientDate")
        @Produces(MediaType.APPLICATION_JSON)
        public List<StatsResult> chiffreAffaireClientDate(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate){
            return dao.chiffreAffaireClientDTO_DATE(minDate, maxDate);
        }
        
        @GET
        @Path("produits")
        @Produces(MediaType.APPLICATION_JSON)
        public List<StatsResult> produitVendus(@QueryParam("test") Integer codeCategorie){
            return dao.produitsVendusPour(codeCategorie);
        }
                
	@GET
	@Path("commandesFiltrees")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Numéros des commandes entre deux dates
	 */
	public List<Integer> commandesFiltrees(
		@QueryParam("minDate") HtmlSqlDate minDate,
		@QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.commandesEntre(minDate, maxDate);
	}

	@GET
	@Path("vector")
	@Produces(MediaType.APPLICATION_JSON)
	public List unitesVenduesParCategorie() {
		List result = dao.unitesVenduesParCategorie();
		return result;
	}
}
