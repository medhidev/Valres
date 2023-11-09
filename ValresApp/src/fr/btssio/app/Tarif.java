package fr.btssio.app;

import java.time.LocalDateTime;

public class Tarif {
	
	// Attribut
	private LocalDateTime date;
	private int periode;
	private double prixHT;
	private double prixTTC;
	private double prix_total;
	double TVA = 20/100;
	
	// Constructeur
	public Tarif(int periode, double prixHT, double prixTTC, double prix_total) {
		super();
		this.periode = periode;
		this.prixHT = prixHT;
		this.prixTTC = prixTTC;
		this.prix_total = prix_total;
	}
	
	public String getNamePeriod(int periode) {
		String periode_name = "pas de periode";
		
		// Vérifie le type de periode (1, 2 ou 3)
		switch(periode) {
		case 1:
			periode_name = "Matinée";
		case 2:
			periode_name = "Après-Midi";
		case 3:
			periode_name = "Soirée";
		}
			
		return periode_name;
	}
	
	public double calculTTC(double prixHT) {
		return prixHT * (1 + this.TVA);
	}
	
	public double calculPrix(String nomSalle) {
		
		double total_price = 0;
		
		// Vérifie en fonction de la Salle & de la periode le prix
		if(nomSalle == "Multimedia") {
			switch(this.periode) {
			case 1:
				total_price += calculTTC(1055.5);
			case 2:
				total_price += calculTTC(1530.8);
			case 3:
				total_price += calculTTC(1455.5);
			}
		}
		
		else if(nomSalle == "Salle de Restauration") {
			if(this.periode == 2)
				total_price += calculTTC(1055.5);
			else
				total_price += 0;
		}
		
		else if(nomSalle == "Amphithéâtre") {
			switch(this.periode) {
			case 1:
				total_price += calculTTC(1055.5);
			case 2:
				total_price += calculTTC(1055.5);
			case 3:
				total_price += calculTTC(1055.5);
			}
		}
		return total_price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
