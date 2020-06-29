package serviceRest;

import java.util.ArrayList;

import javax.ws.rs.GET;

import DAO.FrequentationDAO;
import DAO.FrequentationDAOImpl;
import Entities.Frequentation;

public class ControlerFreq {
	public ArrayList<Frequentation> getAnnalyse(int annee,int mois){
		FrequentationDAO dao = new FrequentationDAOImpl();
		ServiceFrequentation service=new ServiceFrequentation(annee,mois,dao.getDataFrequentation());
		return service.ytheorique();
			
	}

}
