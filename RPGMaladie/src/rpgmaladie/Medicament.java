package rpgmaladie;

public class Medicament extends Item {
    Caracteristique malus;
    int valeurMalus;
    
    


	public Medicament(String nom, int poids, Effet effet,Caracteristique caracVie, int valeurVie, Caracteristique malus, int valeurMalus) {
            super(nom,poids,caracVie,valeurVie);
            this.malus=malus;
            this.valeurMalus=valeurMalus;
            
	}


}