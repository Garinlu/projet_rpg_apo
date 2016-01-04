package rpgmaladie;

public class Medicament extends Item {
    Caracteristique malus;
    int valeurMalus;


	public Medicament(String nom, int poids,Caracteristique carac, int valeur, Caracteristique malus, int valeurMalus) {
            super(nom,poids,carac,valeur);
            this.malus=malus; //Pourquoi tu mets ces deux attributs ? L'effet est déjà créé avec le super?
            this.valeurMalus=valeurMalus;
            
	}


}