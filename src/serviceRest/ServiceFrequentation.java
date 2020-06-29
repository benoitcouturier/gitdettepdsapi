package serviceRest;

import java.util.ArrayList;

import Entities.Frequentation;

public class ServiceFrequentation {
	private int annee;
	private int mois;
	private ArrayList<Frequentation> arrayfreq;
	public ServiceFrequentation(int annee, int mois, ArrayList<Frequentation> arrayfreq) {
		super();
		this.annee = annee;
		this.mois = mois;
		this.arrayfreq = arrayfreq;
	}
	private int nbMois(){
		int index=this.arrayfreq.size()-1;
		int anneeprecedent=this.arrayfreq.get(index).getAnnee();
		System.out.println(anneeprecedent);
		int calculan=(this.annee-anneeprecedent)*12;
		System.out.println(calculan);
		int moidernier=this.arrayfreq.get(index).getMoi();
		System.out.println(moidernier);
		int calculmois=this.mois-moidernier;
		System.out.println(calculmois);
		
		int result =this.arrayfreq.get(index).getNbmois()+calculan+calculmois;
		return result;
	}
	
	private float moyennex(){
		float somme=0;
		int i=0;
		while(i<this.arrayfreq.size()){
			somme=somme+this.arrayfreq.get(i).getNbmois();
			i++;
		}
		return somme/arrayfreq.size();
	}
	

	private float moyenney(){
		float somme=0;
		int i=0;
		while(i<this.arrayfreq.size()){
			somme=somme+this.arrayfreq.get(i).getCount();
			i++;
		}
		return somme/arrayfreq.size();
	}
	private double variancex(){
		double somme=0;
		int i=0;
		while(i<this.arrayfreq.size()){
			somme=somme+(Math.pow(this.arrayfreq.get(i).getNbmois(),2)-Math.pow(this.moyennex(), 2));
			i++;
		}
		return somme/arrayfreq.size();
	}
	private double covariance(){
		double somme=0;
		int i=0;
		while(i<this.arrayfreq.size()){
			somme=somme+((this.arrayfreq.get(i).getNbmois()*this.arrayfreq.get(i).getCount())-(this.moyennex()*this.moyenney()));
			i++;
		}
		return somme/this.arrayfreq.size();
	}
	private double coefa(){
		return this.covariance()/this.variancex();
	}
	private double coefb(){
		double b=0;
		b= (this.moyenney()-(this.coefa()*this.moyennex()));
		return b;
	}
	public ArrayList<Frequentation> ytheorique(){
		int i=0;
		while(i<this.arrayfreq.size()){
			double theorie= ((this.coefa()*this.arrayfreq.get(i).getNbmois())+this.coefb());
			this.arrayfreq.get(i).setTheorie(theorie);
			i++;
		}
		Frequentation freq=new Frequentation(0,this.annee,this.mois,this.nbMois());
		freq.setTheorie((this.coefa()*freq.getNbmois())+this.coefb());
		this.arrayfreq.add(freq);
		return this.arrayfreq;
	}
}

