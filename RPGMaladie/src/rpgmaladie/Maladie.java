package rpgmaladie;

public class Maladie {

	private final String nomMaladie;
	private int sante;
        private int defense;
        private final int niveau;//de 1 a 10-> augmente la puissance des attaques
        //on ajoute des probabilités pour determiner quelle attaque a le plus de chance d'etre realisée.
        private final int probaGM=45;//GrosseMigraine
        private final int probaFT=25;
        private final int probaCG=10;
        private final int probaMV=20;
        
        
        public Maladie(String nom, int sante, int niveau){
            this.nomMaladie=nom;
            this.niveau=niveau;
            this.sante=sante;
            
        }
        
        

	public void GrosseMigraine (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-6)*niveau);
            Effet effetSymptome= new Effet(Caracteristique.DEXTERITE,(-4)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome);
           	
	}

	public void FievreTerrible (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-7)*niveau);
            Effet effetSymptome1= new Effet(Caracteristique.DEXTERITE,(-3)*niveau);
            Effet effetSymptome2= new Effet(Caracteristique.DEFENSE,(-3)*niveau);
            Effet effetSymptome3= new Effet(Caracteristique.FORCE,(-3)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome1);
            cible.appliqueEffet(effetSymptome2);
            cible.appliqueEffet(effetSymptome3);

	}

	public void CoupdeGrace (Personnage cible) {
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-10)*niveau);
            Effet effetSymptome= new Effet(Caracteristique.DEFENSE,(-2)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome);

	}

	public void MauxdeVentre (Personnage cible){
            Effet effetDegat= new Effet(Caracteristique.SANTE,(-8)*niveau);
            Effet effetSymptome1= new Effet(Caracteristique.DEXTERITE,(-2)*niveau);
            Effet effetSymptome2= new Effet(Caracteristique.DEFENSE,(-2)*niveau);
            Effet effetSymptome3= new Effet(Caracteristique.FORCE,(-2)*niveau);
            cible.appliqueEffet(effetDegat);
            cible.appliqueEffet(effetSymptome1);
            cible.appliqueEffet(effetSymptome2);
            cible.appliqueEffet(effetSymptome3);
            

	}
        
        public int getDefense(){
            return this.defense;
        }

}