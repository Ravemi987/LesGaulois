package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\" " + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert force >= 0;
		// force = points de vie / energie
		int forceAvant = force;
		force -= forceCoup;
		int forceApres = force;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert forceApres < forceAvant;
	}
	
	public void sEquiper(Equipement equipement) {
		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom 
					+ " est deja bien protégé !");
			break;
			
		case 1:
			if(equipements[0] == equipement) {
				System.out.println("Le soldat " + this.nom
						+ "possède déjà un " + equipement.toString() + "!");
			} else {
				ajouterEquipement(equipement);
			}
			break;

		default:
			ajouterEquipement(equipement);
			break;
		}
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[1] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + this.nom
				+ " s'équipe avec un " + equipement.toString() + ".");
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus.prendreParole());
		minus.parler("Ave !");
		minus.recevoirCoup(3);
		System.out.println("Points de vies de " + minus.nom + " : " + minus.force);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}
