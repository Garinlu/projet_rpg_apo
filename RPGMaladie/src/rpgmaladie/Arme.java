package rpgmaladie;

public class Arme extends Item {// ajout de la proba de reussite+ les gets.+ je comprends pas trop la stats de soin
                                //il faudrat ajouter le prix

	private final int degat;
	private final int soin;
	private final int maniabilite;
        private final int proba; 

	public Arme(String nom, int poids, Caracteristique caracteristique, int valeur, int degat, int soin, int maniabilite,int proba) {
		super(nom,poids,caracteristique, valeur);
                this.degat=degat;
                this.soin=soin;
                this.maniabilite=maniabilite;
                this.proba=proba;
	}
        
        
        public int getManiabilite(){
            return this.maniabilite;
        }
        
        public int getProba(){
            return proba;
            
        }
        public int getDegat(){
            return degat;
        }
        public int getSoin(){
            return soin;
        }
        

}