package entities;
import java.sql.Date;

public class Contact {
	private int id ; 
	private String nom_prenom ; 
	private String mail ; 
	private String sujet ; 
	private String message ; 
	private Date date_envoi  ;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String nom_prenom, String mail, String sujet,
			String message, Date date_envoi) {
		super();
		this.nom_prenom = nom_prenom;
		this.mail = mail;
		this.sujet = sujet;
		this.message = message;
		this.date_envoi = date_envoi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_prenom() {
		return nom_prenom;
	}
	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate_envoi() {
		return date_envoi;
	}
	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}
	 
	
	
}