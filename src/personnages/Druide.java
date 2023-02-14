package personnages;

import java.util.random.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force "
				+ effetPotionMin + " à" + effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}
	
	private void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
		
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void name() {
		
	}
	
}
