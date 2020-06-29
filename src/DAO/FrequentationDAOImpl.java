package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.Frequentation;
import database.ConnectionDataBase;

public class FrequentationDAOImpl implements FrequentationDAO {
	private Connection connect;
	private PreparedStatement ps;
	private ResultSet rs;
	private Frequentation freq;
	private ArrayList<Frequentation> arrayfreq;
	private ConnectionDataBase co;
	
	@Override
	public ArrayList<Frequentation> getDataFrequentation() {
		// TODO Auto-generated method stub
		co=new ConnectionDataBase();
		String sql="SELECT count(*) as nb, `annee`,`moi` FROM `frequentation` group by `annee`,`moi`";
		arrayfreq=new ArrayList<Frequentation>();
		try {
			connect=co.getConnection();
			ps=connect.prepareStatement(sql);
			rs=ps.executeQuery();
			int numligne=0;
			while(rs.next()){
				if (rs.getInt("moi")!=0){
					numligne++;
					freq= new Frequentation(rs.getInt("nb"),rs.getInt("annee"),rs.getInt("moi"),numligne);
					arrayfreq.add(freq);					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayfreq;
	}

}
