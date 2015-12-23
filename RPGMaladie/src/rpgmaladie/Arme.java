package rpgmaladie;

public class Arme extends Item {

	private int degat;
	private int soin;
	private int maniabilite;

	/**
	 * 
	 * @param nom
	 * @param poids
	 * @param degat
	 * @param soin
	 * @param maniabilite
	 */
	public Arme(String nom, int poids, int degat, int soin, int maniabilite) {
		super(nom,poids);
	}

}