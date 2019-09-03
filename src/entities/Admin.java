package entities;

public class Admin {
	private int id; 
	private String nom; 
	private String prenom ; 
	private int tel ; 
	private String login ; 
	private String password ;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
		
	}

	public Admin(String nom, String prenom, int tel, String login,
			String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
