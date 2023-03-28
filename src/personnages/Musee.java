package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = new Trophee(gaulois, equipement);
		nbTrophee++;
	}
	
	public String extraireInstructionsCaml() {
		String res = "let musee = [" + "\n";
	
		for(int i = nbTrophee; i >= 0; i--) {
			if (i != 0) {
				res += "\"" + trophees[i].getGaulois().getNom() 
						+ "\"" + "," + "\"" + trophees[i] + "\"" + ";";
			} else {
				res += "\"" + trophees[i].getGaulois().getNom()
						+ "\"" + "," + "\"" + trophees[i] + "\"";
			}	
		}
		res += "]";
		return res;
	}
}
