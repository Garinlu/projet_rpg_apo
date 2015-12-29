package rpgmaladie;

public class Arme extends Item {

	private final int degat;
	private final int soin;
	private final int maniabilite;


	public Arme(String nom, int poids, Caracteristique caracteristique, int valeur, int degat, int soin, int maniabilite) {
		super(nom,poids,caracteristique, valeur);
                this.degat=degat;
                this.soin=soin;
                this.maniabilite=maniabilite;
                
	}
        
        public int getManiabilite(){
            return this.maniabilite;
        }

}