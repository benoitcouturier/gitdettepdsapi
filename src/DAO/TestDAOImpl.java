package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.ConnectionDataBase;

public class TestDAOImpl {
	Connection connect;
	PreparedStatement st;
	ResultSet rs = null;
	public Connection getConnect() {
		return connect;
	}
	public void setConnect(Connection connect) {
		this.connect = connect;
	}
	public PreparedStatement getSt() {
		return st;
	}
	public void setSt(PreparedStatement st) {
		this.st = st;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	public TestDAOImpl() {
		super();
		try {
			ConnectionDataBase co= new ConnectionDataBase();
			this.connect = co.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String getName(){
		String resultat="la requete n'a pas été executee";
		try{
			String sql="SELECT count(*), `moi`, `annee` FROM `frequentation` where 1 group by `moi`,`annee`;";
			st=connect.prepareStatement(sql);
			rs=st.executeQuery();
			
			while (rs.next()){
				resultat=rs.getString("Name");
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultat;
		
	}
	
}
