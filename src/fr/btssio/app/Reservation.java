package fr.btssio.app;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Reservation {
	
	public void generatePDF(String pathFile) {
		try {
            // Créer un document PDF
            PDDocument document = new PDDocument();

            // Créer une nouvelle page
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Créer un contenu de page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Texte à insérer dans le PDF
            int num_bordereau = 1;
            LocalDate date_emission = LocalDate.now();
            Calendar calendar = Calendar.getInstance();
            int num_semaine = calendar.get(Calendar.WEEK_OF_YEAR);
            int year = LocalDate.now().getYear();
            String nom = "";
            String prenom = "";
            String nom_structure = "";
            String email = "";
            String adresse_structure = "";
            
//            Tarif tarif = new Tarif();
//            double montantTTC = tarif.;
            
            String text = String.format("""
            		
            	    Maison des Ligues
            	    
            	    Bordereau n° %d
            	    Date d'émission %s
            	    semaine %d - %d
            	    
            	    
            	    """,
            	    num_bordereau, date_emission, num_semaine, year);
            
            // Nombre d'utilisateur à Afficher
            for(int i=0; i < 3; i++) {
            	try {
        			
      		      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Créer un DocumentBuilderFactory
      		      DocumentBuilder builder = factory.newDocumentBuilder(); // Créer un DocumentBuilder
      		      
      		      // celui par défaut "src/fr/btssio/app/data/reservation.xml"
      		      Document doc = builder.parse(new File(pathFile)); // Charger le fichier XML
      		      Element root = doc.getDocumentElement(); // Obtenir l'élément racine      
      		      NodeList reservationList = root.getElementsByTagName("reservation"); // Obtenez une liste de tous les éléments "reservation" dans le document
      		
      		      // Affiche l'enssemble pour chacun
      		      for (int j = 0; j < reservationList.getLength(); j++) {
      		          Element reservation = (Element) reservationList.item(i);
      		          String id = reservation.getAttribute("id");
      		          String format_j = Integer.toString(j);
      		
      		          if (format_j.equals(id)) {
      		        	  
      		          	  // Contenu XML
      		              nom = reservation.getElementsByTagName("nom").item(0).getTextContent().toUpperCase();
      		              prenom = reservation.getElementsByTagName("prenom").item(0).getTextContent().toUpperCase();
      		              nom_structure = reservation.getElementsByTagName("structure_nom").item(0).getTextContent();
      		              email = reservation.getElementsByTagName("mail").item(0).getTextContent();
      		              adresse_structure = reservation.getElementsByTagName("structure_adresse").item(0).getTextContent();
      		              
      		            
      		              
      		          }
      		      }
      		  	} catch (ParserConfigurationException | SAXException | IOException e) {
      		  	
      		      e.printStackTrace();
      		  	}
            	
            	text += String.format("""
	            	 		%s %s
	            	 		%s
	            	 		%s
	            	 		%s
	            	""", nom, prenom, nom_structure, adresse_structure, email);
            	
            	 
            }

	        // Divisez la chaîne de caractères en lignes individuelles
	        String[] lignes = text.split("\n");
            
            // Définir la police
            PDFont font = PDType0Font.load(document, new File("src/fr/btssio/app/font/Helvetica.ttf"));
            
            // application police et taille sur le fichier
            contentStream.setFont(font, 12);

            // Position du texte sur la page (en points, origine en bas à gauche)
            float x = 20;
            float y = PDRectangle.A4.getHeight() - 50;

            // Ajouter le texte à la page
            contentStream.beginText();
            contentStream.newLineAtOffset(x, y);
            
//            contentStream.showText(text);
            
            float yPosition = -15;
            for (String ligne : lignes) {
            	contentStream.newLineAtOffset(x, yPosition); // Déplacez la position du texte
                contentStream.showText(ligne);
                x -= x; // remettre x au point initiale
	        }
            
           
            contentStream.endText();
            // Fermer le contenu de la page
            contentStream.close();

            // Sauvegarder le document PDF dans un fichier
            document.save("src/fr/btssio/app/bordereau/bordereau.pdf");

            // Fermer le document
            document.close();

            System.out.println("Fichier PDF créé avec succès.");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
