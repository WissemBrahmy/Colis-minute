package entities;

	public class Statistique {
		private int id ; 
		private String destination ; 
		private int nbr_visite;
		public Statistique(int id, String destination, int nbr_visite) {
			super();
			this.id = id;
			this.destination = destination;
			this.nbr_visite = nbr_visite;
		}
		public Statistique() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDestination() {
			return destination;
		}
		public void setDestination(String destination) {
			this.destination = destination;
		}
		public int getNbr_visite() {
			return nbr_visite;
		}
		public void setNbr_visite(int nbr_visite) {
			this.nbr_visite = nbr_visite;
		} 
		
		
		
}
