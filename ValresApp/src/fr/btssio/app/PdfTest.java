package fr.btssio.app;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class PdfTest {

	public static void main(String[] args) {
		try {
            // Créer un document PDF
            PDDocument document = new PDDocument();

            // Créer une nouvelle page
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Créer un contenu de page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Texte à insérer dans le PDF
            int v = 1;
            int b = 2;
            String text = String.format("""
            	    variable v vaut:
            	    v = %d
            	    variable b vaut:
            	    b = %d
            	    """, v, b);

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
