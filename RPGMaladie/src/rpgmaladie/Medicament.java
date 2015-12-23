package rpgmaladie;

public class Medicament extends Item {

	/**
	 * 
	 * @param nom
	 * @param poids
	 * @param effet
	 * @param maniabilite
	 */
	public Medicament(String nom, int poids, Effet effet) {
            super(nom,poids);
	}

	private Effet effet;

}