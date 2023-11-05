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

//InputStream is = ...;
//DocumentBuilderFactory factory = 
//	DocumentBuilderFactory.newInstance();
//factory.setNamespaceAware(false);
//DocumentBuilder builder = null;
//try {
//	builder = factory.newDocumentBuilder();
//} catch (ParserConfigurationException e)
//{
//}
//Document doc = builder.parse(is);

public class Utilisateur {
    public static void main(String[] args) {
        try {
            // Créer un DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Créer un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Charger le fichier XML
            Document doc = builder.parse(new File("src/fr/btssio/app/data/reservation.xml"));

            // Obtenir l'élément racine
            Element root = doc.getDocumentElement();

            // Obtenez une liste de tous les éléments "reservation" dans le document
            NodeList reservationList = root.getElementsByTagName("reservation");


            // Parcourez la liste des livres
            for (int i = 0; i < reservationList.getLength(); i++) {
                Element reservation = (Element) reservationList.item(i);
                String id = reservation.getAttribute("id");

                if ("2".equals(id)) {
                	// Contenu XML
                    // ID Utilisateur
                    String utilisateurId = reservation.getElementsByTagName("utilisateur_id").item(0).getTextContent();
                    System.out.println("Utilisateur ID: " + utilisateurId);
                    
                    // Nom personne qui réserve
                    String nom = reservation.getElementsByTagName("nom").item(0).getTextContent();
                    System.out.println("Nom: " + nom);
                    
                    // Prenom personne qui réserve
                    String prenom = reservation.getElementsByTagName("prenom").item(0).getTextContent();
                    System.out.println("Prénom: " + prenom);
                    
                    // Email client
                    String email = reservation.getElementsByTagName("mail").item(0).getTextContent();
                    System.out.println("Email: " + email);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
        	
        	System.out.println("dans le catch");
            e.printStackTrace();
        }
    }
}
