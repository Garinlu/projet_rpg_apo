package RPGMaladie;

public class Personnage {

	private String nomPersonnage;
	private Map<Caracteristique, Integer> caracs;
	private int niveau;
	private int poidsMax;
	private int SanteMax;
	private int DexteriteMax;
	private List<Item> inventaire;

	public void appliqueEffet() {
		// TODO - implement Personnage.appliqueEffet
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Arme
	 */
	public void equipeArme(int Arme) {
		// TODO - implement Personnage.equipeArme
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Medicament
	 */
	public void prendMedicament(int Medicament) {
		// TODO - implement Personnage.prendMedicament
		throw new UnsupportedOperationException();
	}

	public int getPoidsInventaire() {
		// TODO - implement Personnage.getPoidsInventaire
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Item
	 */
	public void retireInventaire(int Item) {
		// TODO - implement Personnage.retireInventaire
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Item
	 */
	public void ajouteInventaire(int Item) {
		// TODO - implement Personnage.ajouteInventaire
		throw new UnsupportedOperationException();
	}

	public void calculSanteMax() {
		// TODO - implement Personnage.calculSanteMax
		throw new UnsupportedOperationException();
	}

	public void calculDexteriteMax() {
		// TODO - implement Personnage.calculDexteriteMax
		throw new UnsupportedOperationException();
	}

	public void incrementNiveau() {
		// TODO - implement Personnage.incrementNiveau
		throw new UnsupportedOperationException();
	}

	public int sumCarac() {
		// TODO - implement Personnage.sumCarac
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Caracteristique
	 */
	public int getValeurCarac(int Caracteristique) {
		// TODO - implement Personnage.getValeurCarac
		throw new UnsupportedOperationException();
	}

	public void initCaracteristiques() {
		// TODO - implement Personnage.initCaracteristiques
		throw new UnsupportedOperationException();
	}

	public void verifierCaracteristique() {
		// TODO - implement Personnage.verifierCaracteristique
		throw new UnsupportedOperationException();
	}

	public void initCapacite() {
		// TODO - implement Personnage.initCapacite
		throw new UnsupportedOperationException();
	}

}