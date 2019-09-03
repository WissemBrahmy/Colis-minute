package entities;

public class Demande_liv {
	
	private int id_liv ;
	private String date_liv ;
	private String etat_liv ;
	private Utlisateur user ; 
	private Annonce annonce ; 
	public Demande_liv() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Demande_liv(String date_liv, String etat_liv, Utlisateur user,
			Annonce annonce) {
		super();
		this.date_liv = date_liv;
		this.etat_liv = etat_liv;
		this.user = user;
		this.annonce = annonce;
	}
	public int getId_liv() {
		return id_liv;
	}
	public void setId_liv(int id_liv) {
		this.id_liv = id_liv;
	}
	public String getDate_liv() {
		return date_liv;
	}
	public void setDate_liv(String date_liv) {
		this.date_liv = date_liv;
	}
	public String getEtat_liv() {
		return etat_liv;
	}
	public void setEtat_liv(String etat_liv) {
		this.etat_liv = etat_liv;
	}
	public Utlisateur getUser() {
		return user;
	}
	public void setUser(Utlisateur user) {
		this.user = user;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	 
 
}
