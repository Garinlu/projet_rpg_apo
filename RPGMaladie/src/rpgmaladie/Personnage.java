package rpgmaladie;

import java.util.Map;
import java.util.List;

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
	 * @param arme
	 */
	public void equipeArme(Arme arme) {

	}

	/**
	 * 
	 * @param medoc
	 */
	public void prendMedicament(Medicament medoc) {

	}

	public int getPoidsInventaire() {
		// TODO - implement Personnage.getPoidsInventaire
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param item
	 */
	public void retireInventaire(Item item) {

	}

	/**
	 * 
	 * @param item
	 */
	public void ajouteInventaire(Item item) {

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


	public Map<Caracteristique, Integer> getValeurCarac() {
            return this.caracs;
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