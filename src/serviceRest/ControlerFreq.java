package serviceRest;

import java.io.IOException;
import java.util.ArrayList;


import DAO.FrequentationDAO;
import DAO.FrequentationDAOImpl;
import Entities.Frequentation;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/Frequentation")
public class ControlerFreq {
	@GET
	@Path("/get/{moi}/{annee}")
	@Produces("application/json")
	public Response getAnnalyse(@PathParam("annee") int annee,@PathParam("moi") int mois){
		FrequentationDAO dao = new FrequentationDAOImpl();
		
		ServiceFrequentation service=new ServiceFrequentation(annee,mois,dao.getDataFrequentation());
		ArrayList<Frequentation> freq=service.ytheorique();
		ObjectMapper mapper = new ObjectMapper();
		String response=new String();
		try {
			 response = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(freq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return Response.status(200).entity(response).build();
		
	/*	FrequentationDAO dao = new FrequentationDAOImpl();
		ServiceFrequentation service=new ServiceFrequentation(annee,mois,dao.getDataFrequentation());
		return service.ytheorique();
	*/		
	}
	public ArrayList<Frequentation> getAnnalyseAPI(int annee, int mois){
		FrequentationDAO dao = new FrequentationDAOImpl();
		ServiceFrequentation service=new ServiceFrequentation(annee,mois,dao.getDataFrequentation());
		return service.ytheorique();
		
	}

}
