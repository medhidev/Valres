package fr.btssio.app;

public class Utilisateur {
	
    private String nom;
    private String prenom;
    private String id_utilisateur;
    private int id_structure;
    private String nom_structure;
    private String email;
    private String adresse_structure;
    
	public Utilisateur(String nom, String prenom, String id_utilisateur, int id_structure, String nom_structure, String email, String adresse_structure) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.id_utilisateur = id_utilisateur;
		this.id_structure = id_structure;
		this.nom_structure = nom_structure;
		this.email = email;
		this.adresse_structure = adresse_structure;
	} 
}
