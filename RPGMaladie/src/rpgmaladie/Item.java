package rpgmaladie;

public class Item {

	private String nom;
	private int poids;

	/**
	 * 
	 * @param nom
	 * @param poids
	 */
	public Item(String nom, int poids) {

	}

	/**
	 * 
	 * @param effet
     * @return 
	 */
	public int getValeurEffet(Effet effet) {
            return effet.getValeur();
	}

	/**
	 * 
	 * @param effet
	 */
	public void ajouteEffet(Effet effet) {

	}

}