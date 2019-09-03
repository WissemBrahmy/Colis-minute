package entities;

 

public class Annonce {
	private int id ;
	private String datedep ;
	private String datearriv ;
	private String villedep ;
	private String villearriv ;
	private Utlisateur user ; 
	private int prix ;
	private int kg ;
	private String etat ;
	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Annonce(int id, String datedep,
			String datearriv, String villedep, String villearriv, int prix,
			int kg) {
		super();
		this.id = id;
		this.datedep = datedep;
		this.datearriv = datearriv;
		this.villedep = villedep;
		this.villearriv = villearriv;
		this.prix = prix;
		this.kg = kg;
	}


	public Annonce(String datedep, String datearriv,
			String villedep, String villearriv, Utlisateur user, int prix,
			int kg, String etat) {
		super();
		this.datedep = datedep;
		this.datearriv = datearriv;
		this.villedep = villedep;
		this.villearriv = villearriv;
		this.user = user;
		this.prix = prix;
		this.kg = kg;
		this.etat = etat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatedep() {
		return datedep;
	}
	public void setDatedep(String datedep) {
		this.datedep = datedep;
	}
	public String getDatearriv() {
		return datearriv;
	}
	public void setDatearriv(String datearriv) {
		this.datearriv = datearriv;
	}
	public String getVilledep() {
		return villedep;
	}
	public void setVilledep(String villedep) {
		this.villedep = villedep;
	}
	public String getVillearriv() {
		return villearriv;
	}
	public void setVillearriv(String villearriv) {
		this.villearriv = villearriv;
	}
	public Utlisateur getUser() {
		return user;
	}
	public void setUser(Utlisateur user) {
		this.user = user;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getKg() {
		return kg;
	}
	public void setKg(int kg) {
		this.kg = kg;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	 

}
