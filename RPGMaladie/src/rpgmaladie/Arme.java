package rpgmaladie;

public class Arme extends Item {

	private int degat;
	private int soin;
	private int maniabilite;

	public Arme(String nom, int poids, Caracteristique caracteristique, int valeur, int degat, int soin, int maniabilite) {
		super(nom,poids,caracteristique, valeur);
                this.degat=degat;
                this.soin=soin;
                this.maniabilite=maniabilite;
                
	}

}