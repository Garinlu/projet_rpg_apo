package rpgmaladie;

public class Arme extends Item {

	private String nom;
	private int poids;
	private int degat;
	private int soin;
	private int maniabilite;


	public Arme(String nom, int poids, int degat, int soin, int maniabilite) {
            this.nom=nom;
            this.poids=poids;
            this.degat=degat;
            this.soin=soin;
            this.maniabilite=maniabilite;
	}

}