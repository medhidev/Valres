package fr.btssio.app;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Salle {
	
	private int id_salle;
	private String nom_salle;
	private int categorie;
	private String libelle_categorie;
	private int id_categorie;
	
	public Salle(int id_salle, String nom_salle, int categorie, String libelle_categorie, int id_categorie) {
		super();
		this.id_salle = id_salle;
		this.nom_salle = nom_salle;
		this.categorie = categorie;
		this.libelle_categorie = libelle_categorie;
		this.id_categorie = id_categorie;
		
		try {
			
		      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Créer un DocumentBuilderFactory
		      DocumentBuilder builder = factory.newDocumentBuilder(); // Créer un DocumentBuilder
		      
		      Document doc = builder.parse(new File("src/fr/btssio/app/data/reservation.xml")); // Charger le fichier XML
		      Element root = doc.getDocumentElement(); // Obtenir l'élément racine      
		      NodeList reservationList = root.getElementsByTagName("reservation"); // Obtenez une liste de tous les éléments "reservation" dans le document
		
		
		      for (int i = 0; i < reservationList.getLength(); i++) {
		          Element reservation = (Element) reservationList.item(i);
		          String id = reservation.getAttribute("id");
		
		          
		      }
		  } catch (ParserConfigurationException | SAXException | IOException e) {
		  	
		  	System.out.println("dans le catch");
		      e.printStackTrace();
		  }
	}
	
}
