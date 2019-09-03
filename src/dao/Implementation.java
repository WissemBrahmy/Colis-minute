package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Admin;
import entities.Annonce;
import entities.Contact;
import entities.Demande_liv;
import entities.Statistique;
import entities.Utlisateur;

public class Implementation implements IGestion {
	@Override
	public void addUtlisateur(Utlisateur u) {
		Connection cnx = CnxBD.getCon(); 
		try {
			PreparedStatement st = cnx.prepareStatement("insert into utilisateur (nom, prenom , tel , email ,  login , password , etat) values (?, ?, ?, ?, ?, ?, ?)");
		    st.setString(1, u.getNom()); 
		    st.setString(2, u.getPrenom());
		    st.setInt(3, u.getTel()); 
		    st.setString(4, u.getMail());
		    st.setString(5, u.getLogin()); 
		    st.setString(6, u.getPassword()); 
		    st.setString(7, u.getEtat());
		    st.executeUpdate(); 
		    
		} catch (SQLException u1) {
			// TODO Auto-generated catch block
			u1.printStackTrace();
		} 
		
	}

	@Override
	public void updateUtlisateur(Utlisateur u) {
		
		Connection cnx = CnxBD.getCon(); 
		try {
			PreparedStatement st = cnx.prepareStatement("update utilisateur set nom = ?, prenom = ?, tel = ?, email = ?, login = ?, password = ? where id_user = ?");
		    st.setString(1, u.getNom()); 
		    st.setString(2, u.getPrenom());
		    st.setInt(3, u.getTel()); 
		    st.setString(4, u.getMail()); 
		    st.setString(5, u.getLogin()); 
		    st.setString(6, u.getPassword());  
		    st.setInt(7, u.getId());
		    st.executeUpdate(); 
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		// TODO Auto-generated method stub
		
	}


	@Override
	public Utlisateur loginUtlisateur(String login, String password) {
		Connection cnx = CnxBD.getCon(); 
		Utlisateur utl = new Utlisateur(); 
		try {
			PreparedStatement st = cnx.prepareStatement("select * from utilisateur where login = ? and password = ? "); 
		    st.setString(1, login); 
		    st.setString(2, password); 
		    ResultSet  rs =  st.executeQuery(); 
		    while(rs.next()){
		    	utl.setId(rs.getInt("id_user")); 
		    	utl.setNom(rs.getString("nom")); 
		    	utl.setPrenom(rs.getString("prenom")); 
		    	utl.setTel(rs.getInt("tel")); 
		    	utl.setMail(rs.getString("email"));
		    	utl.setLogin(rs.getString("login"));
		    	utl.setPassword(rs.getString("password"));
		    	utl.setEtat(rs.getString("etat"));
		    }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		return utl;
	}


	@Override
	public void addAnnonce(Annonce c){
		
		Connection cnx = CnxBD.getCon(); 
		try {
			PreparedStatement st = cnx.prepareStatement("insert into annonce ( date_depart, date_arrive,ville_depart, ville_arrive, prix, kg, etat, id_user) values (?, ?, ?, ?, ?, ?,?,?)");
		    st.setString(1, c.getDatedep()); 
		    st.setString(2, c.getDatearriv()); 
		    st.setString(3, c.getVilledep());
		    st.setString(4, c.getVillearriv());
		    st.setInt(5, c.getPrix());
		    st.setInt(6, c.getKg());
		    st.setString(7, c.getEtat());
		    st.setInt(8, c.getUser().getId());
		    st.executeUpdate(); 
		    
		} catch (SQLException c1) {
			// TODO Auto-generated catch block
			c1.printStackTrace();
		} 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAnnonce(Annonce c) {
		Connection cnx = CnxBD.getCon(); 
		try {
			PreparedStatement st = cnx.prepareStatement("update annonce set date_depart = ?, date_arrive = ?, ville_depart = ?, ville_arrive = ?, prix = ?, kg = ? where id_annonce = ?");
		    st.setString(1, c.getDatedep()); 
		    st.setString(2, c.getDatearriv()); 
		    st.setString(3, c.getVilledep());
		    st.setString(4, c.getVillearriv());
		    st.setInt(5, c.getPrix());
		    st.setInt(6, c.getKg());
		    st.setInt(7, c.getId());
		    st.executeUpdate(); 
		    
		} catch (SQLException c1) {
			// TODO Auto-generated catch block
			c1.printStackTrace();
		} 
		// TODO Auto-generated method stub
			
	}

	@Override
	public void deleteAnnonce(int code) {
	
		Connection cnx = CnxBD.getCon(); 
		try {
			PreparedStatement st = cnx.prepareStatement("delete from annonce where id_annonce = ? ");
		    st.setInt(1, code); 
		    st.executeUpdate(); 
		    
		} catch (SQLException c1) {
			// TODO Auto-generated catch block
			c1.printStackTrace();
		} 
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Annonce> getAllAnnonce() {
		Connection cnx = CnxBD.getCon(); 
		List<Annonce> lst = new ArrayList<>(); 
		try {
			PreparedStatement st = cnx.prepareStatement("select * from annonce where etat ='valide'  ");  
		    ResultSet  rs =  st.executeQuery(); 
		    while(rs.next()){
		    	Annonce a = new Annonce();
		    	a.setId(rs.getInt("id_annonce")); 
		    	a.setDatedep(rs.getString("date_depart"));
		    	a.setDatearriv(rs.getString("date_arrive"));
		    	a.setVilledep(rs.getString("ville_depart"));
		    	a.setVillearriv(rs.getString("ville_arrive"));
		    	a.setUser(getUtilisateurById(rs.getInt("id_user")));
		    	a.setPrix(rs.getInt("prix"));
		    	a.setKg(rs.getInt("kg"));
		    	a.setEtat(rs.getString("etat"));
		    	
		    	lst.add(a);
		    }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} 
		return lst;
	}

	@Override
	public List<Utlisateur> getAllUtlisateur() {
		Connection cnx = CnxBD.getCon(); 
		List<Utlisateur> lst = new ArrayList<>(); 
		try {
			PreparedStatement st = cnx.prepareStatement("select * from utilisateur where  etat ='active'");  
		    ResultSet  rs =  st.executeQuery(); 
		    while(rs.next()){
		    	Utlisateur ll = new Utlisateur();
		    	 ll.setId(rs.getInt("id_user")); 
		    	 ll.setNom(rs.getString("nom"));
		    	 ll.setPrenom(rs.getString("prenom"));
		    	 ll.setTel(rs.getInt("tel"));
		    	 ll.setMail(rs.getString("email"));
		    	 ll.setLogin(rs.getString("login"));
		    	 ll.setPassword(rs.getString("password"));
		    	 ll.setEtat(rs.getString("etat"));
		         lst.add(ll);
		    }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} 
		return lst;
	}

	@Override
	public List<Utlisateur> getAllUtlisateurEnAttente() {
		Connection cnx = CnxBD.getCon(); 
		List<Utlisateur> lst = new ArrayList<>(); 
		try {
			PreparedStatement st = cnx.prepareStatement("select * from utilisateur where etat='en cours'");  
		    ResultSet  rs =  st.executeQuery(); 
		    while(rs.next()){
		    	Utlisateur ll = new Utlisateur();
		    	 ll.setId(rs.getInt("id_user")); 
		    	 ll.setNom(rs.getString("nom"));
		    	 ll.setPrenom(rs.getString("prenom"));
		    	 ll.setTel(rs.getInt("tel"));
		    	 ll.setMail(rs.getString("email"));
		    	 ll.setLogin(rs.getString("login"));
		    	 ll.setPassword(rs.getString("password"));
		    	 ll.setEtat(rs.getString("etat"));
		         lst.add(ll);
		    }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} 
		return lst;
	}


	@Override
	public void validerCompte(String etat, int id) {
		 Connection cnx = CnxBD.getCon(); 
		try {
			PreparedStatement st = cnx.prepareStatement("update utilisateur set etat= ? where id_user = ?");
		    st.setString(1, etat); 
		    st.setInt(2, id);
		    st.executeUpdate(); 
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validerAnnonce(String etat, int id) {
		Connection cnx = CnxBD.getCon(); 
		try {
			PreparedStatement st = cnx.prepareStatement("update annonce set etat= ? where id_annonce = ?");
		    st.setString(1, etat); 
		    st.setInt(2, id);
		    st.executeUpdate(); 
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		// TODO Auto-generated method stub
	}
 
	

@Override
public void deleteUtilisateur(int id) {
	// TODO Auto-generated method stub
	Connection cnx = CnxBD.getCon(); 
	try {
		PreparedStatement st = cnx.prepareStatement("delete from utilisateur where id_user = ? ");
	    st.setInt(1, id); 
	    st.executeUpdate(); 
	    
	} catch (SQLException c1) {
		// TODO Auto-generated catch block
		c1.printStackTrace();
	} 
	// TODO Auto-generated method stub
	
	
}

@Override
public void deleteMessage(int id) {
	// TODO Auto-generated method stub
	Connection cnx = CnxBD.getCon(); 
	try {
		PreparedStatement st = cnx.prepareStatement("delete from message where id_msg = ? ");
	    st.setInt(1, id); 
	    st.executeUpdate(); 
	    
	} catch (SQLException c1) {
		// TODO Auto-generated catch block
		c1.printStackTrace();
	} 
	// TODO Auto-generated method stub
	
}

@Override
public List<Annonce> getAllAnnonce(String depart, String arrivve, String date) {

	Connection cnx = CnxBD.getCon(); 
	List<Annonce> lst = new ArrayList<>(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select * from annonce where ville_depart = ? and  ville_arrive = ? and date_depart = ?");  
		st.setString(1, depart);
		st.setString(2, arrivve);
		st.setString(3, date);
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	Annonce a = new Annonce();
	    	a.setId(rs.getInt("id_annonce")); 
	    	a.setDatedep(rs.getString("date_depart"));
	    	a.setDatearriv(rs.getString("date_arrive"));
	    	a.setVilledep(rs.getString("ville_depart"));
	    	a.setVillearriv(rs.getString("ville_arrive"));
	    	a.setPrix(rs.getInt("prix"));
	    	a.setUser(getUtilisateurById(rs.getInt("id_user")));
	    	a.setKg(rs.getInt("kg"));
	    	a.setEtat(rs.getString("etat"));
	    	
	    	lst.add(a);
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return lst;

}

@Override
public void contacterAdmin(Contact c) {
	Connection cnx = CnxBD.getCon(); 
	try {
		PreparedStatement st = cnx.prepareStatement("insert into contact (sujet, message, nom_prenom , email , date_envoie) values (?, ?, ?, ?, ?)");
	    st.setString(1, c.getSujet());
	    st.setString(2, c.getMessage()); 
	    st.setString(3, c.getNom_prenom());
	    st.setString(4, c.getMail());
	    st.setDate(5, c.getDate_envoi()); 
	    st.executeUpdate(); 
	    
	} catch (SQLException u1) {
		// TODO Auto-generated catch block
		u1.printStackTrace();

	
}
}

@Override
public List<Annonce> getAllAnnonceEnAttente() {
	Connection cnx = CnxBD.getCon(); 
	List<Annonce> lst = new ArrayList<>(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select * from annonce where etat ='invalide'  ");  
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	Annonce a = new Annonce();
	    	a.setId(rs.getInt("id_annonce")); 
	    	a.setDatedep(rs.getString("date_depart"));
	    	a.setDatearriv(rs.getString("date_arrive"));
	    	a.setVilledep(rs.getString("ville_depart"));
	    	a.setVillearriv(rs.getString("ville_arrive"));
	    	a.setPrix(rs.getInt("prix"));
	    	a.setKg(rs.getInt("kg"));
	    	a.setEtat(rs.getString("etat"));
	    	
	    	lst.add(a);
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return lst;
}

@Override
public void  sendDemande(Demande_liv m) {
	Connection cnx = CnxBD.getCon(); 
	try {
		PreparedStatement st = cnx.prepareStatement("insert into demande_liv (date_liv, etat_liv, id_user, id_annonce) values (?, ?, ?, ?)");
	    st.setString(1, m.getDate_liv());
	    st.setString(2, m.getEtat_liv()); 
	    st.setInt(3, m.getUser().getId());
	    st.setInt(4, m.getAnnonce().getId());
	    st.executeUpdate(); 
	    
	} catch (SQLException u1) {
		// TODO Auto-generated catch block
		u1.printStackTrace();

	
}
}

@Override
public Annonce getAnnonceById(int id) {
	Connection cnx = CnxBD.getCon(); 
	Annonce a = new Annonce(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select * from annonce where id_annonce = ?");  
		st.setInt(1, id);
		  ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	 a.setId(rs.getInt("id_annonce")); 
	    	a.setDatedep(rs.getString("date_depart"));
	    	a.setDatearriv(rs.getString("date_arrive"));
	    	a.setVilledep(rs.getString("ville_depart"));
	    	a.setVillearriv(rs.getString("ville_arrive"));
	    	a.setPrix(rs.getInt("prix"));
	    	a.setKg(rs.getInt("kg"));
	    	a.setEtat(rs.getString("etat")); 
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return a;
}

@Override
public List<Annonce> getAllAnnonceFromUtilisateur(int id) {
	
	Connection cnx = CnxBD.getCon(); 
	List<Annonce> lst = new ArrayList<>(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select * from annonce where id_user = ?  ");
		st.setInt(1, id);
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	Annonce a = new Annonce();
	    	a.setId(rs.getInt("id_annonce")); 
	    	a.setDatedep(rs.getString("date_depart"));
	    	a.setDatearriv(rs.getString("date_arrive"));
	    	a.setVilledep(rs.getString("ville_depart"));
	    	a.setVillearriv(rs.getString("ville_arrive"));
	    	a.setPrix(rs.getInt("prix"));
	    	a.setKg(rs.getInt("kg"));
	    	a.setEtat(rs.getString("etat"));
	    	
	    	lst.add(a);
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return lst;
	} 


@Override
public List<Demande_liv> getAllDemandeFromUtilisateur(int id){
	
	Connection cnx = CnxBD.getCon(); 
	List<Demande_liv> lst = new ArrayList<>(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select * from demande_liv  where id_user = ?  ");
		st.setInt(1, id);
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	Demande_liv d = new Demande_liv();
	    	d.setId_liv(rs.getInt("id_liv")); 
	    	d.setDate_liv(rs.getString("date_liv"));
	    	d.setEtat_liv(rs.getString("etat_liv"));
	    	d.setUser(getUtilisateurById(rs.getInt("id_user")));
	    	d.setAnnonce(getAnnonceById(rs.getInt("id_annonce"))); 
	    	lst.add(d);
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return lst;
}

@Override
public Utlisateur getUtilisateurById(int id) {
	Connection cnx = CnxBD.getCon(); 
	Utlisateur ll = new Utlisateur(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select * from utilisateur where  id_user = ? ");  
		st.setInt(1, id);
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	
	    	 ll.setId(rs.getInt("id_user")); 
	    	 ll.setNom(rs.getString("nom"));
	    	 ll.setPrenom(rs.getString("prenom"));
	    	 ll.setTel(rs.getInt("tel"));
	    	 ll.setMail(rs.getString("email"));
	    	 ll.setLogin(rs.getString("login"));
	    	 ll.setPassword(rs.getString("password"));
	    	 ll.setEtat(rs.getString("etat")); 
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return ll;
}

@Override
public int verficationMail(String mail) {
	Connection cnx = CnxBD.getCon(); 
	int nbr = 0; 
	try {
		PreparedStatement st = cnx.prepareStatement("select count(id_user) as nombre from utilisateur where email = ?  ");
		st.setString(1, mail);
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){ 
	    	nbr = rs.getInt("nombre"); 
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return nbr;
 
}
/*
@Override
public List<Statistique> getStatistique() {
	Connection cnx = CnxBD.getCon(); 
	List<Statistique> lst = new ArrayList<>(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select count(id_annonce)as nbr, ville_arrive  from annonce  where month(date_depart) = month(CURDATE()) Group By Ville_arrive  order by nbr DESC");  
		
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	Statistique a = new Statistique(); 
	    	a.setDestination(rs.getString("ville_arrive"));
	    	a.setNbr_visite(rs.getInt("nbr"));
	    	
	    	lst.add(a);
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return lst;

}
*/

@Override
public List<Demande_liv> getAllDemandeRecuUtilisateur(int id) {
	Connection cnx = CnxBD.getCon(); 
	List<Demande_liv> lst = new ArrayList<>(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select distinct demande_liv.id_liv, demande_liv.date_liv, demande_liv.etat_liv, utilisateur.id_user , annonce.id_annonce from annonce,demande_liv, utilisateur   where demande_liv.id_annonce = annonce.id_annonce AND demande_liv.id_user = utilisateur.id_user and annonce.id_user = ?");
		st.setInt(1, id);
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	Demande_liv d = new Demande_liv();
	    	d.setId_liv(rs.getInt("id_liv")); 
	    	d.setDate_liv(rs.getString("date_liv"));
	    	d.setEtat_liv(rs.getString("etat_liv"));
	    	d.setUser(getUtilisateurById(rs.getInt("id_user")));
	    	d.setAnnonce(getAnnonceById(rs.getInt("id_annonce"))); 
	    	lst.add(d);
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
		
	} 
	return lst;

}

@Override
public void deleteDemande(int code) {
	Connection cnx = CnxBD.getCon(); 
	try {
		PreparedStatement st = cnx.prepareStatement("delete from demande_liv where id_liv = ? ");
	    st.setInt(1, code); 
	    st.executeUpdate(); 
	    
	} catch (SQLException c1) {
		// TODO Auto-generated catch block
		c1.printStackTrace();
	} 
	// TODO Auto-generated method stub
	
	// TODO Auto-generated method stub
	
}

@Override
public void traiterDemande(String etat, int id) {
	Connection cnx = CnxBD.getCon(); 
	try {
		PreparedStatement st = cnx.prepareStatement("update demande_liv set etat_liv = ? where id_liv = ?");
	    st.setString(1, etat); 
	    st.setInt(2, id);
	    st.executeUpdate(); 
	    
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	// TODO Auto-generated method stub
	

	
}

@Override
public List<Statistique> getStatistique() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Admin loginAdmin(String login, String password) {
	Connection cnx = CnxBD.getCon(); 
	Admin ad = new Admin(); 
	try {
		PreparedStatement st = cnx.prepareStatement("select * from admin where login = ? and password = ? "); 
	    st.setString(1, login); 
	    st.setString(2, password); 
	    ResultSet  rs =  st.executeQuery(); 
	    while(rs.next()){
	    	ad.setId(rs.getInt("id_admin")); 
	    	ad.setNom(rs.getString("nom")); 
	    	ad.setPrenom(rs.getString("prenom"));  
	    	ad.setLogin(rs.getString("login"));
	    	ad.setPassword(rs.getString("password"));
	    	ad.setTel(rs.getInt("tel"));
	    }
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	return ad;
}
}
