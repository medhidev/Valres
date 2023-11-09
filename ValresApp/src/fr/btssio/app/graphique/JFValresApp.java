package fr.btssio.app.graphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import fr.btssio.app.Reservation;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class JFValresApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String pathFile, nameFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFValresApp frame = new JFValresApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFValresApp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFValresApp.class.getResource("/fr/btssio/app/graphique/logo.png")));
		setResizable(false);
		setTitle("Application Valres");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_generer = new JButton("Generate");
		btn_generer.addActionListener(new ActionListener() {
			// Générer le PDF
			public void actionPerformed(ActionEvent e) {
				Reservation reserv = new Reservation();
				reserv.generatePDF(pathFile);
			}
		});
		
		btn_generer.setBounds(94, 159, 117, 23);
		contentPane.add(btn_generer);
		
		JButton btn_select_xml = new JButton("Select XML");
		btn_select_xml.addActionListener(new ActionListener() {
			
			// Click Boutton Select XML
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				
				// Filtre de selection de fichier XML
			    FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("Fichier XML", "xml");
			    fileChooser.setFileFilter(xmlFilter);
			    
			    int returnValue = fileChooser.showOpenDialog(null);
				
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					// Fichier selectionner dans le Gestionnaire de fichier
				    File selectedFile = fileChooser.getSelectedFile();  
				    nameFile = selectedFile.getName();
				    pathFile = selectedFile.getPath();
				    
				    JLabel lbl_select_file = new JLabel(nameFile);
					lbl_select_file.setBounds(129, 105, 46, 14);
					contentPane.add(lbl_select_file);
				}
			}
		});
		
		btn_select_xml.setBounds(94, 71, 117, 23);
		contentPane.add(btn_select_xml);
		
//		JLabel lbl_select_file = new JLabel((String)nameFile);
//		lbl_select_file.setBounds(129, 105, 46, 14);
//		contentPane.add(lbl_select_file);
	}
}
