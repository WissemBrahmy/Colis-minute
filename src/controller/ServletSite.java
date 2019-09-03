package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Admin;
import entities.Annonce;
import entities.Contact;
import entities.Demande_liv;
import dao.Implementation;
import entities.Statistique;
import entities.Utlisateur;

/**
 * Servlet implementation class ServletSite
 * @param <HttpSession>
 */
@WebServlet("/ServletSite")
public class ServletSite<HttpSession> extends HttpServlet {
	javax.servlet.http.HttpSession session ;
	Implementation gestion = new Implementation(); 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("gerer");
		
		if(action!=null){
			
			 if(action.equals("Vcomptes")){
				 List<Utlisateur> lstue = new ArrayList();
				 lstue = gestion.getAllUtlisateurEnAttente();  
				 request.setAttribute("VC", lstue);
				 request.getRequestDispatcher("comptes_utilisateurs.jsp").forward(request, response);
			 }
			 if(action.equals("lstComptes")){
				 List<Utlisateur> lstu = new ArrayList();
				 lstu = gestion.getAllUtlisateur();  
				 request.setAttribute("LU", lstu);
				 request.getRequestDispatcher("liste_utilisateurs.jsp").forward(request, response);
			 }
			 
			 if(action.equals("Vannonces")){
				 List<Annonce> lstann = new ArrayList();
				 lstann = gestion.getAllAnnonceEnAttente();  
				 request.setAttribute("VA", lstann);
				 request.getRequestDispatcher("annonce.jsp").forward(request, response);
			 }
			 if(action.equals("LstAnnonces")){
				 List<Annonce> lstann1 = new ArrayList();
				 lstann1 = gestion.getAllAnnonce();  
				 request.setAttribute("LA", lstann1);
				 request.getRequestDispatcher("liste_annonce.jsp").forward(request, response);
			 }
			 
			 
			 if(action.equals("validerUser")){
				 
				 int id = Integer.parseInt(request.getParameter("idd"));
				 gestion.validerCompte("active", id); 
				 request.getRequestDispatcher("menu_admin.jsp").forward(request, response);
			 }
			 
			 if(action.equals("validerAnn")){
				 
				 int id = Integer.parseInt(request.getParameter("idd"));
				 gestion.validerAnnonce("valide", id); 
				 request.getRequestDispatcher("menu_admin.jsp").forward(request, response);
			 }
			 
			 if(action.equals("deleteAnn")){
				 
				 int id = Integer.parseInt(request.getParameter("idd"));
				 gestion.deleteAnnonce(id);
				 request.getRequestDispatcher("menu_admin.jsp").forward(request, response);
			 }
			
			 if(action.equals("deleteUti")){
				 
				 int id = Integer.parseInt(request.getParameter("idd"));
				 gestion.deleteUtilisateur( id); 
				 request.getRequestDispatcher("menu_admin.jsp").forward(request, response);
			 }
			 
			 if(action.equals("deleteMsg")){
				 
				 int id = Integer.parseInt(request.getParameter("idd"));
				 gestion.deleteMessage( id); 
				 request.getRequestDispatcher("menu_admin.jsp").forward(request, response);
			 }
           if(action.equals("affAnn")){
				  
				 request.getRequestDispatcher("details_annonce.jsp").forward(request, response);
			 }
			
			
		 }
		
		
		
		
		
		
		
		
		
		
		
		
		List<Statistique> lst = gestion.getStatistique(); 
    	request.setAttribute("LSS", lst); 
		 if(action!=null){
		    if(action.equals("mesannonces")){
		    	int idu = Integer.parseInt(request.getParameter("id"));
		    	List<Annonce> la = gestion.getAllAnnonceFromUtilisateur(idu); 
		    	request.setAttribute("LA", la);
		    	request.getRequestDispatcher("Mes_annoces.jsp").forward(request, response);
		    }
		    if(action.equals("demandeRecu")){
		    	int idu = Integer.parseInt(request.getParameter("id"));
		    	List<Demande_liv> ld = gestion.getAllDemandeRecuUtilisateur(idu); 
		    	request.setAttribute("LD", ld);
		    	request.getRequestDispatcher("demande_reçue.jsp").forward(request, response);
		    }
		    if(action.equals("demande")){
		    	int idu = Integer.parseInt(request.getParameter("id"));
		    	List<Demande_liv> ld = gestion.getAllDemandeFromUtilisateur(idu); 
		    	request.setAttribute("LD", ld);
		    	request.getRequestDispatcher("demande.jsp").forward(request, response);
		    }
		    if(action.equals("acceptDmd")){ 
		    	int idu = Integer.parseInt(request.getParameter("idd"));
		    	System.out.println("idddd : "+idu);
		    	gestion.traiterDemande("Accepte", idu);
		    	request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
		    }
		    if(action.equals("refusDmd")){ 
		    	int idu = Integer.parseInt(request.getParameter("idd"));
		    	gestion.traiterDemande("Refuse", idu);
		    	request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
		    }
		    if(action.equals("modAnnonce")){ 
		    	int idannonce = Integer.parseInt(request.getParameter("id"));
		    	Annonce a =  gestion.getAnnonceById(idannonce);
		    	request.setAttribute("AN", a);
		    	request.getRequestDispatcher("edit_Annonces.jsp").forward(request, response);
		    }
		    if(action.equals("suppAnnonce")){
		    	int idu = Integer.parseInt(request.getParameter("id"));
		    	gestion.deleteAnnonce(idu);
		    	javax.servlet.http.HttpSession session = request.getSession(); 
		    	Utlisateur us = (Utlisateur) session.getAttribute("USER"); 
		    	response.sendRedirect("/ServletSite?gerer=mesannonces&id="+us.getId());
		    	request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
		    }
		    
		    if(action.equals("suppdmd")){
		    	int idd = Integer.parseInt(request.getParameter("idd"));
		    	gestion.deleteDemande(idd);
		    	javax.servlet.http.HttpSession session = request.getSession(); 
		    	Utlisateur us = (Utlisateur) session.getAttribute("USER"); 
		    	request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
		    	
		    }
		    
		    if(action.equals("Rech")){
		    	List<Annonce> la = gestion.getAllAnnonce();
		    	if(la!=null){
		    	request.setAttribute("LAA", la);
		    	}else {
					request.setAttribute("MS", "Aucune annonce de Covalisage Trouvée");
				}
		    	request.getRequestDispatcher("recherche.jsp").forward(request, response);
		    }
		    
		    if(action.equals("SendDMD")){
		    	javax.servlet.http.HttpSession session = request.getSession(false);
			    	Utlisateur us = (Utlisateur) session.getAttribute("USER"); 
			    	System.out.println("ussss : "+us);
			    	if(us==null){ 
				    	request.getRequestDispatcher("connexion.jsp").forward(request, response);
			    	}else {
			    		int idu = Integer.parseInt(request.getParameter("id"));
			    		Date dZ = new Date();
			    		SimpleDateFormat dd =new SimpleDateFormat("YYYY-mm-dd");
			    		Demande_liv  d= new Demande_liv( dd.format(dZ.getDate()), "En Attente", us, gestion.getAnnonceById(idu));
			    		gestion.sendDemande(d);
			    		response.sendRedirect("index.jsp");
			    	}
		    }
		    
		 }else {
		    	List<Statistique> lstt = gestion.getStatistique(); 
		    	request.setAttribute("LSS", lstt); 
		    	 request.getRequestDispatcher("index.jsp").forward(request, response);
		    }
		 }
			
		 


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("gerer"); 
		 System.out.println("actionn : "+action);
		 if(action!=null){
		    if(action.equals("Se Connecter")){
				 String username = request.getParameter("login"); 
				 String password = request.getParameter("password");
				 Utlisateur u1 = gestion.loginUtlisateur(username, password); 
				 String etat_user = u1.getEtat();
				 System.out.println("tttttttttt : "+etat_user);
				 if(u1.getNom()!=null){
					 if(etat_user.equals("active")){
						 session = request.getSession(true);
						 session.setAttribute("USER", u1); 
						 request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
					 }
					 else
					 { 
						 request.setAttribute("ERREUR","Compte inactive"); 
						 request.getRequestDispatcher("connexion.jsp").forward(request, response);
					 }
					
				 }else {
					 request.setAttribute("ERREUR", "svp  verifier votre login et password");
					 request.getRequestDispatcher("connexion.jsp").forward(request, response);
				 
			 }
		 }
	
			 }
			 if(action.equals("save")){ 		
				 // recuperation de contenue des champs 
				 String nom = request.getParameter("nom"); 
				 String prenom = request.getParameter("prenom"); 
				 int tel = Integer.parseInt(request.getParameter("tel")); 
				 int id = Integer.parseInt(request.getParameter("id")); 
				 String mail = request.getParameter("mail");
				 String usernamee = request.getParameter("login"); 
				 String password = request.getParameter("password"); 
				 Utlisateur  u1 = new  Utlisateur(id, prenom, nom, tel, usernamee, password, mail, "active"); 
				 gestion.updateUtlisateur(u1);
				 request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
			 }
			 if(action.equals("envoyer")){
				 String sujet = request.getParameter("sujet");
				 String email = request.getParameter("mail"); 
				 String message = request.getParameter("msg");
				 String np = request.getParameter("nom_prenom");
				 Date dd = new Date(); 
				SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
				String dat = dt1.format(dd) ;
				 Contact c = new Contact(np, email, sujet, message, new java.sql.Date(dd.getTime()));
				 gestion.contacterAdmin(c);
				 request.getRequestDispatcher("contact.jsp").forward(request, response);	
			 }
			 if(action.equals("modddAnnonce")){
				 String datedep = request.getParameter("datedepart");
				 String datearriv = request.getParameter("datearrive");
				 String villedep = request.getParameter("depart");
				 String villearriv = request.getParameter("arrive");
				 int prix = Integer.parseInt(request.getParameter("prix")); 
				 int idannonce = Integer.parseInt(request.getParameter("ida"));
				 int kg = Integer.parseInt(request.getParameter("poids"));   
				  Annonce a1 = new Annonce(idannonce, datedep, datearriv, villedep, villearriv, prix, kg);
				 gestion.updateAnnonce(a1); 
				 request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
			 }
			 if(action.equals("chercher")){
				 System.out.println("je suis la");
				 String ville_dep = request.getParameter("depart");
				 String ville_arriv = request.getParameter("arrive");
				 String date_dep = request.getParameter("date");
				 System.out.println(ville_dep);
				 System.out.println(ville_arriv);
				 System.out.println(date_dep);
				 List<Annonce>  laa = gestion.getAllAnnonce(ville_dep, ville_arriv, date_dep);
				 request.setAttribute("LAA", laa);
				 request.getRequestDispatcher("recherche.jsp").forward(request, response);
			 }
			 if(action.equals("publierAnnonce")){
				 String datedep = request.getParameter("depart");
				 String datearriv = request.getParameter("arrive");
				 String villedep = request.getParameter("villedepart");
				 String villearriv = request.getParameter("villearrive");
				 int prix = Integer.parseInt(request.getParameter("prix"));
				 int id = Integer.parseInt(request.getParameter("id"));
				 int kg = Integer.parseInt(request.getParameter("poids")); 
				 if(java.sql.Date.valueOf(datearriv).compareTo(java.sql.Date.valueOf(datedep))==-1){
					 System.out.println("---------");
					 request.setAttribute("MSG", "Date d'arrivé incoorect");
					 request.getRequestDispatcher("menu_utili.jsp").forward(request, response);
					 return ; 
				 }/*else {
					 System.out.println("++++++++");
				 }*/
				 Utlisateur uu = gestion.getUtilisateurById(id);
				  Annonce c1 = new Annonce( datedep, datearriv, villedep, villearriv, uu, prix, kg, "invalide");
				 gestion.addAnnonce(c1); 
			 }
			 
			 if(action.equals("inscrire")){
				 String nom = request.getParameter("nom");
				 String prenom = request.getParameter("prenom");
				 int tel = Integer.parseInt(request.getParameter("tel"));
				 String login = request.getParameter("login");
				 String password = request.getParameter("password");
				 String email = request.getParameter(("mail"));
				 int nbrr = gestion.verficationMail(email);System.out.println("nnnnn : "+nbrr);
				 if(nbrr>0){
					 request.setAttribute("MSG", "Email déja existe"); 
					 request.getRequestDispatcher("connexion.jsp").forward(request, response);
					 return ; 
				 }else{
				 Utlisateur  u1 = new  Utlisateur (nom, prenom, tel, login, password, email, "en cours","0"); 
				 gestion.addUtlisateur(u1);
				 
				 response.sendRedirect("connexion.jsp");
				 }
			 }
			 
			 
			 
		 }
	}


