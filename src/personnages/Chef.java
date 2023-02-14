package personnages;

public class Chef {

	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	public Chef(String nom, int force, Village village) {
		super();
		this.nom = nom;
		this.force = force;
		this.village = village;
	}
	
	public String getNom() {
		return nom;
	}
	
	private void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
		
	}

	private String prendreParole() {
		return "Le chef " + nom + " du village " + village.getNom() + ": ";
		
	}
	
	private void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + 
	romain.getNom());
		romain.recevoirCoup(force / 3);
	}
}
