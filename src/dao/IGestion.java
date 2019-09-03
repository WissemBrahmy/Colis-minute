package dao;


import java.util.List;

import entities.Admin;
import entities.Annonce;
import entities.Contact;
import entities.Demande_liv;
import entities.Statistique;
import entities.Utlisateur;

public interface IGestion {
	public void traiterDemande(String etat , int id);
	public int verficationMail(String mail);
	public List<Statistique> getStatistique(); // select count(id_annonce), ville_depart as nbr from annonce  where month(date_voyage) = month(CURDATE()) Group By Ville_depart
	public void addUtlisateur(Utlisateur u); 
	public void updateUtlisateur(Utlisateur u); 
	public Utlisateur loginUtlisateur(String login , String password); 
	public Admin loginAdmin(String login , String password);
	public void addAnnonce(Annonce c);
	public void updateAnnonce(Annonce c) ;
	public void deleteAnnonce(int code);
	public List<Annonce> getAllAnnonceEnAttente();
	public List<Annonce> getAllAnnonce();
	public List<Annonce> getAllAnnonceFromUtilisateur(int id);
	public List<Utlisateur> getAllUtlisateur();
	public List<Utlisateur> getAllUtlisateurEnAttente();
	public List<Demande_liv> getAllDemandeFromUtilisateur(int id);
	public List<Demande_liv> getAllDemandeRecuUtilisateur(int id);
	public void validerCompte(String etat, int id);
	public void validerAnnonce(String etat, int id); 
	public void deleteUtilisateur(int id);
	public void deleteMessage(int id);
	public List<Annonce> getAllAnnonce(String depart , String arrivve, String date);
	public void sendDemande(Demande_liv m); 
	public void contacterAdmin(Contact c); 
	public Annonce getAnnonceById(int id);
	public void deleteDemande(int code);
	public Utlisateur getUtilisateurById(int id);
	
}


