package fr.btssio.app.Utilisateurs;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.btssio.app.Utilisateur;

public class Utilisateur2 extends Utilisateur{

	public Utilisateur2(String nom, String prenom, String id_utilisateur, int id_structure, String nom_structure,
			String email, String adresse_structure) {
		super(nom, prenom, id_utilisateur, id_structure, nom_structure, email, adresse_structure);
		
		try {
			
		      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Créer un DocumentBuilderFactory
		      DocumentBuilder builder = factory.newDocumentBuilder(); // Créer un DocumentBuilder
		      
		      Document doc = builder.parse(new File("src/fr/btssio/app/data/reservation.xml")); // Charger le fichier XML
		      Element root = doc.getDocumentElement(); // Obtenir l'élément racine      
		      NodeList reservationList = root.getElementsByTagName("reservation"); // Obtenez une liste de tous les éléments "reservation" dans le document
		
		
		      for (int i = 0; i < reservationList.getLength(); i++) {
		          Element reservation = (Element) reservationList.item(i);
		          String id = reservation.getAttribute("id");
		
		          if ("1".equals(id)) {
		        	  
		          	  // Contenu XML
		              nom = reservation.getElementsByTagName("nom").item(0).getTextContent();
		              prenom = reservation.getElementsByTagName("prenom").item(0).getTextContent();
		              id_utilisateur = reservation.getElementsByTagName("utilisateur_id").item(0).getTextContent();
		              nom_structure = reservation.getElementsByTagName("structure_nom").item(0).getTextContent();
		              email = reservation.getElementsByTagName("mail").item(0).getTextContent();
		              adresse_structure = reservation.getElementsByTagName("structure_adresse").item(0).getTextContent();
		              
		          }
		      }
		  } catch (ParserConfigurationException | SAXException | IOException e) {
		      e.printStackTrace();
		  }
	}

}
