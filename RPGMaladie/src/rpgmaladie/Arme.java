package rpgmaladie;

public class Arme extends Item {// ajout de la proba de reussite+ les gets.+ je comprends pas trop la stats de soin
                                //il faudrat ajouter le prix

	private final int degat;

	private final int maniabilite;
        private final int proba; 

	public Arme(String nom, int poids, Caracteristique caracteristique, int valeur, int degat, int maniabilite,int proba,int prix) {
		super(nom,poids,caracteristique, valeur,prix);
                this.degat=degat;

                this.maniabilite=maniabilite;
                this.proba=proba;
	}
        
        
        public void afficheInfosArme(){
            System.out.println("Nom: "+this.nom);
            System.out.println("Poids: "+this.poids);
            System.out.println("Bonus: +"+this.valeur+" en "+this.caracteristique.getNom());
            System.out.println("Degats de base: "+this.degat);
            System.out.println("Malus possibles...");
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
        

}