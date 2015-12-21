package rpgmaladie;

public interface Capacite {

	/**
	 * 
	 * @param src
	 * @param cible
	 */
	Effet[] effet(Personnage src, Personnage cible);

	/**
	 * 
	 * @param src
	 */
	double probaReussite(Personnage src);

}