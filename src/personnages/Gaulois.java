package personnages;

public class Gaulois {
	
	private String nom;
	private int effetPotion = 1;
	private int force; 
	private int nb_trophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\" " + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de "
//				+ romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//		
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i < tropheesBataille.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = tropheesBataille[i];
		}
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonation(Musee musee) {
		if(nb_trophees > 0) {
			System.out.println(prendreParole() + "Je donne au musee tous mes trophees : ");
			for(int i = nb_trophees; i >= 0; i--)
			{
				System.out.println("- " + trophees[i] + "\n");
				musee.donnerTrophees(this, trophees[i]);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + 
				", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.prendreParole());
		asterix.parler("Bonjour !");
		asterix.boirePotion(5);
		System.out.println(asterix.effetPotion);
		System.out.println(asterix);
	}
}
