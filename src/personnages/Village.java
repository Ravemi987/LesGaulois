package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (this.nbVillageois < nbVillageoisMaximum) {
			villageois[this.nbVillageois] = gaulois;
			this.nbVillageois++;
		}
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() 
				+ " vivent les légendaires gaulois : ");
		for(int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);
		
		/* Gaulois gaulois = village.trouverHabitant(30);
		 * 
		 * Cette erreur provient du fait que le tableau "villageois
		 * a une taille de 30 donc l'indice le plus grand est 29.
		 */
		
		Chef chef = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.setChef(chef);
		village.ajouterHabitant(asterix);
		
		/*
		 * Gaulois gaulois = village.trouverHabitant(1);
		 *  System.out.println(gaulois);
		 *  
		 * Cette erreur est due au fait que gaulois est ajouté
		 * à l'indice 0, pas à l'indice 1.
		 */
		
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
	}
}
