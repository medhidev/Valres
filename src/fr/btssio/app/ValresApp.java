package fr.btssio.app;

import java.awt.EventQueue;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ValresApp extends JFrame{
	
	// Déclarations Components
	private JButton select_XML;
	private JButton genenerate_PDF;
	private JFileChooser gui_XML;
	private JPanel conteneur;
	
	public ValresApp(){
		
		// Déclaration
		int width = 400;
		int height = 300;
		conteneur = new JPanel();
	
		// Configuration de l'Interface
		setTitle("Application Valres");
		setResizable(false);
		setSize(width, height);
		conteneur.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(conteneur);
		
		
		// Placement des components sur l'Interface
		select_XML = new JButton("select XML");
		conteneur.add(select_XML);
		select_XML.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gui_XML = new JFileChooser();
				gui_XML.setDialogTitle("Select XML File");
				gui_XML.setFileFilter(new FileNameExtensionFilter("Fichiers XML", "xml"));
				int returnValue = gui_XML.showOpenDialog(null); // valeur renvoyer par la boîte de dialogue
				
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					// Fichier selectionner dans le Gestionnaire de fichier
				    File selectedFile = gui_XML.getSelectedFile();
				    String nameFile = selectedFile.getName();
				    String pathFile = selectedFile.getPath();
				    
				    JLabel lbl_select_file = new JLabel(nameFile);
					lbl_select_file.setBounds(129, 105, 46, 14);
					conteneur.add(lbl_select_file);
				}

			}
		});

		
	}
	
	
	// Lancement de l'interface
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					ValresApp window = new ValresApp();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
	}
	
}
